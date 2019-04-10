package OOP;

public enum PaintType {
    ACRYLIC (1),
    OIL (2),
    WATER(3);

    private final int code;

    PaintType(int code) {
        this.code = code;
    }

    int getCode () {
        return code;
    }

    public static PaintType valueOf(int index) {
        for (PaintType value : values()) {
            if (value.ordinal() == index) {
                return value;
            }
        }
        return null;
    }
}
