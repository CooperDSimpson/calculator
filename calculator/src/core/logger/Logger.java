
package core.logger;

import core.logger.LogLevel;
import core.logger.Message;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.EnumSet;

public final class Logger {

    private static boolean showTimestamp = true;
    private static boolean showLogLevel = true;
    private static boolean showMilliseconds = true;
    private static boolean showSource = true;
    private static boolean showColors = true;

    private static LogLevel minimumLevel = LogLevel.TRACE;
    
    private static final EnumSet<LogLevel> enabledLevels =
            EnumSet.allOf(LogLevel.class);

    private static int maxHistory = 1000;

    private static final ArrayDeque<Message> history =
            new ArrayDeque<>();

    private static BufferedWriter fileWriter;

    private Logger() {
        // Static utility class.
    }

    // ==================== CORE LOGGING ====================

    public static void log(LogLevel level, String text) {
        log(level, text, null);
    }

    public static synchronized void log(
            LogLevel level,
            String text,
            Throwable exception
    ) {
        Objects.requireNonNull(level, "level cannot be null");
        Objects.requireNonNull(text, "text cannot be null");

        if (!level.isEnabledBy(minimumLevel) || !enabledLevels.contains(level)) {
            return;
        }

        String source = findCaller();

        Message message = new Message(
                level,
                text,
                source,
                exception
        );

        addToHistory(message);

        String formatted = message.format(
                showTimestamp,
                showMilliseconds,
                showLogLevel,
                showSource
        );

        if (showColors) {
            formatted = colorize(formatted, level);
        }

        if (level.getValue() >= LogLevel.WARN.getValue()) {
            System.err.println(formatted);
        } else {
            System.out.println(formatted);
        }

        if (exception != null) {
            exception.printStackTrace(
                    level.getValue() >= LogLevel.WARN.getValue()
                            ? System.err
                            : System.out
            );
        }

        writeToFile(message);
    }

    // ==================== CONVENIENCE METHODS ====================

    public static void trace(String text) {
        log(LogLevel.TRACE, text);
    }

    public static void debug(String text) {
        log(LogLevel.DEBUG, text);
    }

    public static void info(String text) {
        log(LogLevel.INFO, text);
    }

    public static void warn(String text) {
        log(LogLevel.WARN, text);
    }

    public static void error(String text) {
        log(LogLevel.ERROR, text);
    }

    public static void fatal(String text) {
        log(LogLevel.FATAL, text);
    }

    public static void error(String text, Throwable exception) {
        log(LogLevel.ERROR, text, exception);
    }

    public static void fatal(String text, Throwable exception) {
        log(LogLevel.FATAL, text, exception);
    }

    public static void warn(String text, Throwable exception) {
        log(LogLevel.WARN, text, exception);
    }

    // ==================== BACKWARD COMPATIBILITY ====================

    public static void log(String text) {
        log(LogLevel.CUSTOM, text);
    }

    public static void log(String text, int logLevel) {
        log(LogLevel.fromValue(logLevel), text);
    }

    // ==================== CONFIGURATION ====================

    public static void setMinimumLevel(LogLevel level) {
        minimumLevel = Objects.requireNonNull(level);
    }

    public static LogLevel getMinimumLevel() {
        return minimumLevel;
    }

    public static void ShowLogLevel() {
        showLogLevel = true;
    }

    public static void HideLogLevel() {
        showLogLevel = false;
    }

    public static void ShowMilliseconds() {
        showMilliseconds = true;
    }

    public static void HideMilliseconds() {
        showMilliseconds = false;
    }

    public static void ShowTimestamp() {
        showTimestamp = true;
    }

    public static void HideTimestamp() {
        showTimestamp = false;
    }

    public static void ShowSource() {
        showSource = true;
    }

    public static void HideSource() {
        showSource = false;
    }

    public static void ShowColors() {
        showColors = true;
    }

    public static void HideColors() {
        showColors = false;
    }

    // ==================== MESSAGE HISTORY ====================

    private static void addToHistory(Message message) {
        if (maxHistory <= 0) {
            return;
        }

        while (history.size() >= maxHistory) {
            history.removeFirst();
        }

        history.addLast(message);
    }

    public static synchronized List<Message> getMessages() {
        return List.copyOf(history);
    }

    public static synchronized List<Message> getMessages(
            LogLevel level
    ) {
        return history.stream()
                .filter(message -> message.getLevel() == level)
                .toList();
    }

    public static synchronized void clearHistory() {
        history.clear();
    }

    public static synchronized void setMaxHistory(int maximum) {
        if (maximum < 0) {
            throw new IllegalArgumentException(
                    "Maximum history cannot be negative"
            );
        }

        maxHistory = maximum;

        while (history.size() > maxHistory) {
            history.removeFirst();
        }
    }

    // ==================== FILE LOGGING ====================

    public static synchronized void setLogFile(Path path)
            throws IOException {

        Objects.requireNonNull(path, "path cannot be null");

        closeLogFile();

        Path absolutePath = path.toAbsolutePath();
        Path parent = absolutePath.getParent();

        if (parent != null) {
            Files.createDirectories(parent);
        }

        fileWriter = Files.newBufferedWriter(
                absolutePath,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE,
                StandardOpenOption.APPEND
        );
    }

    private static void writeToFile(Message message) {
        if (fileWriter == null) {
            return;
        }

        try {
            fileWriter.write(message.toString());
            fileWriter.newLine();

            if (message.getException() != null) {
                fileWriter.write(
                        message.getException().toString()
                );
                fileWriter.newLine();

                for (StackTraceElement element :
                        message.getException().getStackTrace()) {
                    fileWriter.write("\tat " + element);
                    fileWriter.newLine();
                }
            }

            fileWriter.flush();
        } catch (IOException exception) {
            System.err.println(
                    "Logger file write failed: "
                            + exception.getMessage()
            );
        }
    }

    public static synchronized void closeLogFile() {
        if (fileWriter == null) {
            return;
        }

        try {
            fileWriter.close();
        } catch (IOException exception) {
            System.err.println(
                    "Logger file close failed: "
                            + exception.getMessage()
            );
        } finally {
            fileWriter = null;
        }
    }

    // ==================== INTERNAL UTILITIES ====================

    private static String findCaller() {
        return StackWalker.getInstance(
                StackWalker.Option.RETAIN_CLASS_REFERENCE
        ).walk(frames -> frames
                .filter(frame ->
                        frame.getDeclaringClass() != Logger.class
                        && frame.getDeclaringClass() != Thread.class)
                .findFirst()
                .map(frame ->
                        frame.getClassName()
                                + "."
                                + frame.getMethodName()
                                + ":"
                                + frame.getLineNumber())
                .orElse("Unknown"));
    }

    private static String colorize(
            String text,
            LogLevel level
    ) {
        String color = switch (level) {
            case TRACE -> "\u001B[90m";
            case DEBUG -> "\u001B[36m";
            case INFO  -> "\u001B[32m";
            case WARN  -> "\u001B[33m";
            case ERROR -> "\u001B[31m";
            case FATAL -> "\u001B[1;31m";
            case OFF   -> "";
            case CUSTOM -> "\u001B[97m"; // Bright white
        };

        return color + text + "\u001B[0m";
    }
    
 // ==================== INDIVIDUAL LOG LEVELS ====================

    public static synchronized void ShowLevel(LogLevel level) {
        Objects.requireNonNull(level, "level cannot be null");
        enabledLevels.add(level);
    }

    public static synchronized void HideLevel(LogLevel level) {
        Objects.requireNonNull(level, "level cannot be null");
        enabledLevels.remove(level);
    }

    public static synchronized boolean IsLevelEnabled(LogLevel level) {
        Objects.requireNonNull(level, "level cannot be null");
        return enabledLevels.contains(level);
    }

    public static synchronized void ShowAllLevels() {
        enabledLevels.addAll(EnumSet.allOf(LogLevel.class));
    }

    public static synchronized void HideAllLevels() {
        enabledLevels.clear();
    }
}
