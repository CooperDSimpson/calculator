
package core;

import javax.swing.SwingUtilities;

import core.logger.Logger;
import core.logger.LogLevel;

import windows.MainWindow;

public final class WindowManager {

    private static final BitWise flags8 = new BitWise(0, 1);

    private static MainWindow mainWindow;

    static {
        flags8.addName("ShowMainWindow", 0);

        Logger.debug("Registered flag 'ShowMainWindow'.");
    }

    private WindowManager() {
        // Static utility class.
    }

    // ==================== LIFECYCLE ====================

    public static void Initialize() {
        Logger.info("Initializing WindowManager.");

        SwingUtilities.invokeLater(() -> {
            Logger.debug("Initialization running on the Swing EDT.");

            if (mainWindow != null) {
                Logger.warn(
                        "Main window already exists; initialization skipped."
                );
                return;
            }

            try {
                Logger.info("Creating main window.");

                mainWindow = new MainWindow();

                Logger.info("Main window created successfully.");

                UpdateMainWindow();

            } catch (RuntimeException | Error exception) {
                Logger.fatal(
                        "Failed to initialize the main window.",
                        exception
                );

                throw exception;
            }
        });

        Logger.debug("Initialization queued on the Swing EDT.");
    }

    public static void ShutDown() {
        Logger.info("Shutting down WindowManager.");

        flags8.clearAll();

        Logger.debug("All window flags cleared.");

        UpdateMainWindow();

        Logger.info("WindowManager shut down.");
    }

    // ==================== WINDOW CONTROL ====================

    public static void OpenMainWindow() {
        Logger.info("Opening main window.");

        flags8.set("ShowMainWindow", true);

        Logger.debug("ShowMainWindow flag set to true.");

        UpdateMainWindow();

        Logger.debug("Open main window request completed.");
    }

    public static void CloseMainWindow() {
        Logger.info("Closing main window.");

        flags8.set("ShowMainWindow", false);

        Logger.debug("ShowMainWindow flag set to false.");

        UpdateMainWindow();

        Logger.debug("Close main window request completed.");
    }

    public static Boolean IsMainWindowOpen() {
        boolean isOpen = flags8.get("ShowMainWindow");

        Logger.debug("Main window open state queried: " + isOpen);

        return isOpen;
    }

    // ==================== VISIBILITY ====================

    private static void UpdateMainWindow() {
        Logger.debug("Scheduling main window visibility update.");

        Runnable update = () -> {
            Logger.debug("Updating main window visibility.");

            if (mainWindow == null) {
                Logger.debug(
                        "Main window is null; visibility update skipped."
                );
                return;
            }

            boolean visible = flags8.get("ShowMainWindow");

            mainWindow.setVisible(visible);

            Logger.info(
                    "Main window visibility set to " + visible + "."
            );
        };

        if (SwingUtilities.isEventDispatchThread()) {
            Logger.debug(
                    "Already on the Swing EDT; running update immediately."
            );

            update.run();
        } else {
            Logger.debug(
                    "Not on the Swing EDT; queuing visibility update."
            );

            SwingUtilities.invokeLater(update);
        }
    }
}
