package OOP;

public enum Material {
    MARBLE (1),
    IRON(2),
    STONE(3);

    private final int code;

    Material(int code) {
        this.code = code;
    }

    int getCode () {
        return code;
    }

    public static Material valueOf(int index) {
        for (Material value : values()) {
            if (value.ordinal() == index) {
                return value;
            }
        }
        return null;
    }

}
