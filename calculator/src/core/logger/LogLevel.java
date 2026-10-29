package core.logger;

public enum LogLevel {
    TRACE(0),
    DEBUG(1),
    INFO(2),
    WARN(3),
    ERROR(4),
    FATAL(5),
    OFF(6),
	CUSTOM(7);

    private final int value;

    LogLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEnabledBy(LogLevel minimum) {
        return minimum != OFF && value >= minimum.value;
    }

    public static LogLevel fromValue(int value) {
        for (LogLevel level : values()) {
            if (level.value == value) {
                return level;
            }
        }

        throw new IllegalArgumentException(
                "Invalid log level: " + value
        );
    }
}

