
package calculator;

import core.WindowManager;
import core.logger.Logger;
import core.logger.LogLevel;

public class App {

    private static volatile boolean ShutDown = false;

    public static void ShutDown() {
        Logger.info("Shutdown requested.");
        ShutDown = true;
    }

    // scotty edit
    public static void main(String[] args) {

        // ==================== LOGGER CONFIGURATION ====================

        Logger.setMinimumLevel(LogLevel.DEBUG);

        Logger.ShowTimestamp();
        Logger.ShowMilliseconds();
        Logger.ShowLogLevel();

        Logger.ShowSource();

        Logger.ShowColors();

        // ==================== APPLICATION STARTUP ====================

        Logger.info("Program starting...");

        try {
            WindowManager.Initialize();

            Logger.info("Program started.");

            WindowManager.OpenMainWindow();
            WindowManager.OpenSandboxWindow();

            // ==================== APPLICATION LOOP ====================

            while (!ShutDown) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                    Logger.warn("Application loop interrupted.");
                    ShutDown = true;
                }
            }

            // ==================== APPLICATION SHUTDOWN ====================

            Logger.info("Shutting down application...");

            WindowManager.ShutDown();

            Logger.info("Application shutdown completed.");

        } catch (RuntimeException | Error exception) {
            Logger.fatal("Unhandled application failure.", exception);
            throw exception;

        } finally {
            Logger.closeLogFile();
        }
    }
}
