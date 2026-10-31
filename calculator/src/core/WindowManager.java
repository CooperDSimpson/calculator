
package core;

import javax.swing.SwingUtilities;

import core.logger.Logger;

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
    private static SandboxWindow sandboxWindow;
    private static ProfilerWindow profilerWindow;

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
        flags32.addName("ShowSandboxWindow", 11);
        flags32.addName("ShowProfilerWindow", 11);

        Logger.debug("Registered all window flags in WindowManager.");
    }

    private WindowManager() {
        // Static utility class.
    }

    // ==================== LIFECYCLE ====================

    public static void Initialize() {
        Logger.info("Initializing WindowManager.");

        flags32.clearAll();

        Logger.debug("WindowManager initialized successfully.");
    }

    public static void ShutDown() {
        Logger.info("Shutting down WindowManager.");

        runOnEDT(() -> {
            flags32.clearAll();

            Logger.debug("All window flags cleared.");

            UpdateAll();

            Logger.info("WindowManager shut down.");
        });
    }

    // ==================== WINDOW CONTROL: CIRCLE ====================

    public static void OpenCircleWindow() {
        Logger.info("Opening circle window.");

        runOnEDT(() -> {
            if (circleWindow == null) {
                Logger.debug("Creating CircleWindow.");
                circleWindow = new CircleWindow();
            }

            flags32.set("ShowCircleWindow", true);
            circleWindow.setVisible(true);
        });
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

        runOnEDT(() -> {
            if (cubeWindow == null) {
                Logger.debug("Creating CubeWindow.");
                cubeWindow = new CubeWindow();
            }

            flags32.set("ShowCubeWindow", true);
            cubeWindow.setVisible(true);
        });
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

        runOnEDT(() -> {
            if (currencyWindow == null) {
                Logger.debug("Creating CurrencyWindow.");
                currencyWindow = new CurrencyWindow();
            }

            flags32.set("ShowCurrencyWindow", true);
            currencyWindow.setVisible(true);
        });
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

        runOnEDT(() -> {
            if (cylinderWindow == null) {
                Logger.debug("Creating CylinderWindow.");
                cylinderWindow = new CylinderWindow();
            }

            flags32.set("ShowCylinderWindow", true);
            cylinderWindow.setVisible(true);
        });
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

        runOnEDT(() -> {
            if (mainWindow == null) {
                Logger.debug("Creating MainWindow.");
                mainWindow = new MainWindow();
            }

            flags32.set("ShowMainWindow", true);
            mainWindow.setVisible(true);
        });
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

        runOnEDT(() -> {
            if (rectPrismWindow == null) {
                Logger.debug("Creating RectPrismWindow.");
                rectPrismWindow = new RectPrismWindow();
            }

            flags32.set("ShowRectPrismWindow", true);
            rectPrismWindow.setVisible(true);
        });
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

        runOnEDT(() -> {
            if (squareWindow == null) {
                Logger.debug("Creating SquareWindow.");
                squareWindow = new SquareWindow();
            }

            flags32.set("ShowSquareWindow", true);
            squareWindow.setVisible(true);
        });
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

        runOnEDT(() -> {
            if (temperatureWindow == null) {
                Logger.debug("Creating TemperatureWindow.");
                temperatureWindow = new TemperatureWindow();
            }

            flags32.set("ShowTemperatureWindow", true);
            temperatureWindow.setVisible(true);
        });
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

        runOnEDT(() -> {
            if (timeWindow == null) {
                Logger.debug("Creating TimeWindow.");
                timeWindow = new TimeWindow();
            }

            flags32.set("ShowTimeWindow", true);
            timeWindow.setVisible(true);
        });
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

        runOnEDT(() -> {
            if (triangleWindow == null) {
                Logger.debug("Creating TriangleWindow.");
                triangleWindow = new TriangleWindow();
            }

            flags32.set("ShowTriangleWindow", true);
            triangleWindow.setVisible(true);
        });
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

        runOnEDT(() -> {
            if (volumeWindow == null) {
                Logger.debug("Creating VolumeWindow.");
                volumeWindow = new VolumeWindow();
            }

            flags32.set("ShowVolumeWindow", true);
            volumeWindow.setVisible(true);
        });
    }

    public static void CloseVolumeWindow() {
        Logger.info("Closing volume window.");
        flags32.set("ShowVolumeWindow", false);
        UpdateVolumeWindow();
    }

    public static Boolean IsVolumeWindowOpen() {
        return flags32.get("ShowVolumeWindow");
    }
    
    // ==================== WINDOW CONTROL: PROFILER ====================

    public static void OpenProfilerWindow() {
        Logger.info("Opening profiler window.");

        runOnEDT(() -> {
            if (profilerWindow == null) {
                Logger.debug("Creating ProfilerWindow.");
                profilerWindow = new ProfilerWindow();
            }

            flags32.set("ShowProfilerWindow", true);
            profilerWindow.setVisible(true);
        });
    }

    public static void CloseProfilerWindow() {
        Logger.info("Closing profiler window.");
        flags32.set("ShowProfilerWindow", false);
        UpdateCircleWindow();
    }

    public static Boolean IsProfilerWindowOpen() {
        return flags32.get("ShowCircleWindow");
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
        UpdateProfilerWindow();
    }

    private static void UpdateCircleWindow() {
        runOnEDT(() -> {
            if (circleWindow != null) {
                circleWindow.setVisible(flags32.get("ShowCircleWindow"));
            }
        });
    }

    private static void UpdateCubeWindow() {
        runOnEDT(() -> {
            if (cubeWindow != null) {
                cubeWindow.setVisible(flags32.get("ShowCubeWindow"));
            }
        });
    }

    private static void UpdateCurrencyWindow() {
        runOnEDT(() -> {
            if (currencyWindow != null) {
                currencyWindow.setVisible(flags32.get("ShowCurrencyWindow"));
            }
        });
    }

    private static void UpdateCylinderWindow() {
        runOnEDT(() -> {
            if (cylinderWindow != null) {
                cylinderWindow.setVisible(flags32.get("ShowCylinderWindow"));
            }
        });
    }

    private static void UpdateMainWindow() {
        runOnEDT(() -> {
            if (mainWindow != null) {
                mainWindow.setVisible(flags32.get("ShowMainWindow"));
            }
        });
    }

    private static void UpdateRectPrismWindow() {
        runOnEDT(() -> {
            if (rectPrismWindow != null) {
                rectPrismWindow.setVisible(flags32.get("ShowRectPrismWindow"));
            }
        });
    }

    private static void UpdateSquareWindow() {
        runOnEDT(() -> {
            if (squareWindow != null) {
                squareWindow.setVisible(flags32.get("ShowSquareWindow"));
            }
        });
    }

    private static void UpdateTemperatureWindow() {
        runOnEDT(() -> {
            if (temperatureWindow != null) {
                temperatureWindow.setVisible(flags32.get("ShowTemperatureWindow"));
            }
        });
    }

    private static void UpdateTimeWindow() {
        runOnEDT(() -> {
            if (timeWindow != null) {
                timeWindow.setVisible(flags32.get("ShowTimeWindow"));
            }
        });
    }

    private static void UpdateTriangleWindow() {
        runOnEDT(() -> {
            if (triangleWindow != null) {
                triangleWindow.setVisible(flags32.get("ShowTriangleWindow"));
            }
        });
    }

    private static void UpdateVolumeWindow() {
        runOnEDT(() -> {
            if (volumeWindow != null) {
                volumeWindow.setVisible(flags32.get("ShowVolumeWindow"));
            }
        });
    }
    
    private static void UpdateProfilerWindow() {
        runOnEDT(() -> {
            if (volumeWindow != null) {
                volumeWindow.setVisible(flags32.get("ShowProfilerWindow"));
            }
        });
    }

    // ==================== SWING EDT ====================

    private static void runOnEDT(Runnable task) {
        if (SwingUtilities.isEventDispatchThread()) {
            task.run();
        } else {
            SwingUtilities.invokeLater(task);
        }
    }
    
    public static void OpenSandboxWindow() {
        Logger.info("Opening sandbox window.");

        runOnEDT(() -> {
            if (sandboxWindow == null) {
                Logger.debug("Creating SandboxWindow.");
                sandboxWindow = new SandboxWindow();
            }

            flags32.set("ShowSandboxWindow", true);
            sandboxWindow.setVisible(true);
        });
    }
    
    public static MainWindow getMainWindow() {
    	return mainWindow;
    }
}
