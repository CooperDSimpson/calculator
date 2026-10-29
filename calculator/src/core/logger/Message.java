
package core.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class Message {

    private static final DateTimeFormatter TIMESTAMP_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final DateTimeFormatter TIMESTAMP_FORMAT_MS =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    private final LocalDateTime timestamp;
    private final LogLevel level;
    private final String text;
    private final String source;
    private final Throwable exception;

    public Message(
            LogLevel level,
            String text,
            String source,
            Throwable exception
    ) {
        this.timestamp = LocalDateTime.now();
        this.level = level;
        this.text = text;
        this.source = source;
        this.exception = exception;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getText() {
        return text;
    }

    public String getSource() {
        return source;
    }

    public Throwable getException() {
        return exception;
    }

    public String format(
            boolean showTimestamp,
            boolean showMilliseconds,
            boolean showLogLevel,
            boolean showSource
    ) {
        StringBuilder result = new StringBuilder();

        if (showTimestamp) {
            DateTimeFormatter formatter = showMilliseconds
                    ? TIMESTAMP_FORMAT_MS
                    : TIMESTAMP_FORMAT;

            result.append("[")
                  .append(timestamp.format(formatter))
                  .append("] ");
        }

        if (showLogLevel) {
            result.append("[")
                  .append(level)
                  .append("] ");
        }

        if (showSource && source != null && !source.isBlank()) {
            result.append("[")
                  .append(source)
                  .append("] ");
        }

        result.append(text);

        return result.toString();
    }

    @Override
    public String toString() {
        return format(true, true, true, true);
    }
}
