package core;

import javax.swing.SwingUtilities;

import core.logger.Logger;
import core.logger.LogLevel;

import windows.*;

public final class WindowManager {

    private static final BitWise flags32 = new BitWise(0, 4);

    private static CircleWindow circleWindow;
    private static CubeWindow cubeWindow;
    private static CurrencyWindow currencyWindow;
    private static CylinderWindow cylinderWindow;
    private static MainWindow mainWindow;
    private static RectPrismWindow rectPrismWindow;
    private static SquareWindow squareWindow;
    private static TemperatureWindow temperatureWindow;
    private static TimeWindow timeWindow;
    private static TriangleWindow triangleWindow;
    private static VolumeWindow volumeWindow;

    static {
        flags32.addName("ShowCircleWindow", 0);
        flags32.addName("ShowCubeWindow", 1);
        flags32.addName("ShowCurrencyWindow", 2);
        flags32.addName("ShowCylinderWindow", 3);
        flags32.addName("ShowMainWindow", 4);
        flags32.addName("ShowRectPrismWindow", 5);
        flags32.addName("ShowSquareWindow", 6);
        flags32.addName("ShowTemperatureWindow", 7);
        flags32.addName("ShowTimeWindow", 8);
        flags32.addName("ShowTriangleWindow", 9);
        flags32.addName("ShowVolumeWindow", 10);

        Logger.debug("Registered all window flags in WindowManager.");
    }

    private WindowManager() {
        // Static utility class.
    }

    // ==================== LIFECYCLE ====================

    public static void Initialize() {
        Logger.info("Initializing WindowManager.");

        SwingUtilities.invokeLater(() -> {
            Logger.debug("Initialization running on the Swing EDT.");

            try {
                Logger.info("Creating all application windows.");

                if (circleWindow == null) circleWindow = new CircleWindow();
                if (cubeWindow == null) cubeWindow = new CubeWindow();
                if (currencyWindow == null) currencyWindow = new CurrencyWindow();
                if (cylinderWindow == null) cylinderWindow = new CylinderWindow();
                if (mainWindow == null) mainWindow = new MainWindow();
                if (rectPrismWindow == null) rectPrismWindow = new RectPrismWindow();
                if (squareWindow == null) squareWindow = new SquareWindow();
                if (temperatureWindow == null) temperatureWindow = new TemperatureWindow();
                if (timeWindow == null) timeWindow = new TimeWindow();
                if (triangleWindow == null) triangleWindow = new TriangleWindow();
                if (volumeWindow == null) volumeWindow = new VolumeWindow();

                Logger.info("All windows created successfully.");

                UpdateAll();

            } catch (RuntimeException | Error exception) {
                Logger.fatal(
                        "Failed to initialize application windows.",
                        exception
                );

                throw exception;
            }
        });

        Logger.debug("Initialization queued on the Swing EDT.");
    }

    public static void ShutDown() {
        Logger.info("Shutting down WindowManager.");

        flags32.clearAll();

        Logger.debug("All window flags cleared.");

        UpdateAll();

        Logger.info("WindowManager shut down.");
    }

    // ==================== WINDOW CONTROL: CIRCLE ====================

    public static void OpenCircleWindow() {
        Logger.info("Opening circle window.");
        flags32.set("ShowCircleWindow", true);
        UpdateCircleWindow();
    }

    public static void CloseCircleWindow() {
        Logger.info("Closing circle window.");
        flags32.set("ShowCircleWindow", false);
        UpdateCircleWindow();
    }

    public static Boolean IsCircleWindowOpen() {
        return flags32.get("ShowCircleWindow");
    }

    // ==================== WINDOW CONTROL: CUBE ====================

    public static void OpenCubeWindow() {
        Logger.info("Opening cube window.");
        flags32.set("ShowCubeWindow", true);
        UpdateCubeWindow();
    }

    public static void CloseCubeWindow() {
        Logger.info("Closing cube window.");
        flags32.set("ShowCubeWindow", false);
        UpdateCubeWindow();
    }

    public static Boolean IsCubeWindowOpen() {
        return flags32.get("ShowCubeWindow");
    }

    // ==================== WINDOW CONTROL: CURRENCY ====================

    public static void OpenCurrencyWindow() {
        Logger.info("Opening currency window.");
        flags32.set("ShowCurrencyWindow", true);
        UpdateCurrencyWindow();
    }

    public static void CloseCurrencyWindow() {
        Logger.info("Closing currency window.");
        flags32.set("ShowCurrencyWindow", false);
        UpdateCurrencyWindow();
    }

    public static Boolean IsCurrencyWindowOpen() {
        return flags32.get("ShowCurrencyWindow");
    }

    // ==================== WINDOW CONTROL: CYLINDER ====================

    public static void OpenCylinderWindow() {
        Logger.info("Opening cylinder window.");
        flags32.set("ShowCylinderWindow", true);
        UpdateCylinderWindow();
    }

    public static void CloseCylinderWindow() {
        Logger.info("Closing cylinder window.");
        flags32.set("ShowCylinderWindow", false);
        UpdateCylinderWindow();
    }

    public static Boolean IsCylinderWindowOpen() {
        return flags32.get("ShowCylinderWindow");
    }

    // ==================== WINDOW CONTROL: MAIN ====================

    public static void OpenMainWindow() {
        Logger.info("Opening main window.");
        flags32.set("ShowMainWindow", true);
        UpdateMainWindow();
    }

    public static void CloseMainWindow() {
        Logger.info("Closing main window.");
        flags32.set("ShowMainWindow", false);
        UpdateMainWindow();
    }

    public static Boolean IsMainWindowOpen() {
        return flags32.get("ShowMainWindow");
    }

    // ==================== WINDOW CONTROL: RECT PRISM ====================

    public static void OpenRectPrismWindow() {
        Logger.info("Opening rectangular prism window.");
        flags32.set("ShowRectPrismWindow", true);
        UpdateRectPrismWindow();
    }

    public static void CloseRectPrismWindow() {
        Logger.info("Closing rectangular prism window.");
        flags32.set("ShowRectPrismWindow", false);
        UpdateRectPrismWindow();
    }

    public static Boolean IsRectPrismWindowOpen() {
        return flags32.get("ShowRectPrismWindow");
    }

    // ==================== WINDOW CONTROL: SQUARE ====================

    public static void OpenSquareWindow() {
        Logger.info("Opening square window.");
        flags32.set("ShowSquareWindow", true);
        UpdateSquareWindow();
    }

    public static void CloseSquareWindow() {
        Logger.info("Closing square window.");
        flags32.set("ShowSquareWindow", false);
        UpdateSquareWindow();
    }

    public static Boolean IsSquareWindowOpen() {
        return flags32.get("ShowSquareWindow");
    }

    // ==================== WINDOW CONTROL: TEMPERATURE ====================

    public static void OpenTemperatureWindow() {
        Logger.info("Opening temperature window.");
        flags32.set("ShowTemperatureWindow", true);
        UpdateTemperatureWindow();
    }

    public static void CloseTemperatureWindow() {
        Logger.info("Closing temperature window.");
        flags32.set("ShowTemperatureWindow", false);
        UpdateTemperatureWindow();
    }

    public static Boolean IsTemperatureWindowOpen() {
        return flags32.get("ShowTemperatureWindow");
    }

    // ==================== WINDOW CONTROL: TIME ====================

    public static void OpenTimeWindow() {
        Logger.info("Opening time window.");
        flags32.set("ShowTimeWindow", true);
        UpdateTimeWindow();
    }

    public static void CloseTimeWindow() {
        Logger.info("Closing time window.");
        flags32.set("ShowTimeWindow", false);
        UpdateTimeWindow();
    }

    public static Boolean IsTimeWindowOpen() {
        return flags32.get("ShowTimeWindow");
    }

    // ==================== WINDOW CONTROL: TRIANGLE ====================

    public static void OpenTriangleWindow() {
        Logger.info("Opening triangle window.");
        flags32.set("ShowTriangleWindow", true);
        UpdateTriangleWindow();
    }

    public static void CloseTriangleWindow() {
        Logger.info("Closing triangle window.");
        flags32.set("ShowTriangleWindow", false);
        UpdateTriangleWindow();
    }

    public static Boolean IsTriangleWindowOpen() {
        return flags32.get("ShowTriangleWindow");
    }

    // ==================== WINDOW CONTROL: VOLUME ====================

    public static void OpenVolumeWindow() {
        Logger.info("Opening volume window.");
        flags32.set("ShowVolumeWindow", true);
        UpdateVolumeWindow();
    }

    public static void CloseVolumeWindow() {
        Logger.info("Closing volume window.");
        flags32.set("ShowVolumeWindow", false);
        UpdateVolumeWindow();
    }

    public static Boolean IsVolumeWindowOpen() {
        return flags32.get("ShowVolumeWindow");
    }

    // ==================== VISIBILITY UPDATERS ====================

    private static void UpdateAll() {
        UpdateCircleWindow();
        UpdateCubeWindow();
        UpdateCurrencyWindow();
        UpdateCylinderWindow();
        UpdateMainWindow();
        UpdateRectPrismWindow();
        UpdateSquareWindow();
        UpdateTemperatureWindow();
        UpdateTimeWindow();
        UpdateTriangleWindow();
        UpdateVolumeWindow();
    }

    private static void UpdateCircleWindow() {
        runOnEDT(() -> {
            if (circleWindow != null) {
                boolean visible = flags32.get("ShowCircleWindow");
                circleWindow.setVisible(visible);
                Logger.info("Circle window visibility set to " + visible + ".");
            }
        });
    }

    private static void UpdateCubeWindow() {
        runOnEDT(() -> {
            if (cubeWindow != null) {
                boolean visible = flags32.get("ShowCubeWindow");
                cubeWindow.setVisible(visible);
                Logger.info("Cube window visibility set to " + visible + ".");
            }
        });
    }

    private static void UpdateCurrencyWindow() {
        runOnEDT(() -> {
            if (currencyWindow != null) {
                boolean visible = flags32.get("ShowCurrencyWindow");
                currencyWindow.setVisible(visible);
                Logger.info("Currency window visibility set to " + visible + ".");
            }
        });
    }

    private static void UpdateCylinderWindow() {
        runOnEDT(() -> {
            if (cylinderWindow != null) {
                boolean visible = flags32.get("ShowCylinderWindow");
                cylinderWindow.setVisible(visible);
                Logger.info("Cylinder window visibility set to " + visible + ".");
            }
        });
    }

    private static void UpdateMainWindow() {
        runOnEDT(() -> {
            if (mainWindow != null) {
                boolean visible = flags32.get("ShowMainWindow");
                mainWindow.setVisible(visible);
                Logger.info("Main window visibility set to " + visible + ".");
            }
        });
    }

    private static void UpdateRectPrismWindow() {
        runOnEDT(() -> {
            if (rectPrismWindow != null) {
                boolean visible = flags32.get("ShowRectPrismWindow");
                rectPrismWindow.setVisible(visible);
                Logger.info("Rectangular prism window visibility set to " + visible + ".");
            }
        });
    }

    private static void UpdateSquareWindow() {
        runOnEDT(() -> {
            if (squareWindow != null) {
                boolean visible = flags32.get("ShowSquareWindow");
                squareWindow.setVisible(visible);
                Logger.info("Square window visibility set to " + visible + ".");
            }
        });
    }

    private static void UpdateTemperatureWindow() {
        runOnEDT(() -> {
            if (temperatureWindow != null) {
                boolean visible = flags32.get("ShowTemperatureWindow");
                temperatureWindow.setVisible(visible);
                Logger.info("Temperature window visibility set to " + visible + ".");
            }
        });
    }

    private static void UpdateTimeWindow() {
        runOnEDT(() -> {
            if (timeWindow != null) {
                boolean visible = flags32.get("ShowTimeWindow");
                timeWindow.setVisible(visible);
                Logger.info("Time window visibility set to " + visible + ".");
            }
        });
    }

    private static void UpdateTriangleWindow() {
        runOnEDT(() -> {
            if (triangleWindow != null) {
                boolean visible = flags32.get("ShowTriangleWindow");
                triangleWindow.setVisible(visible);
                Logger.info("Triangle window visibility set to " + visible + ".");
            }
        });
    }

    private static void UpdateVolumeWindow() {
        runOnEDT(() -> {
            if (volumeWindow != null) {
                boolean visible = flags32.get("ShowVolumeWindow");
                volumeWindow.setVisible(visible);
                Logger.info("Volume window visibility set to " + visible + ".");
            }
        });
    }

    private static void runOnEDT(Runnable task) {
        if (SwingUtilities.isEventDispatchThread()) {
            task.run();
        } else {
            SwingUtilities.invokeLater(task);
        }
    }
}