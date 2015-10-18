package game2048;

/**
 * Created by anri on 18.10.15.
 */
public enum CellColor {
    WHITE("\u001b[37m"),
    DEFAULT("\u001b[0m"),
    RED("\u001b[31m"),
    GREEN("\u001b[32m"),
    YELOW("\u001b[33m"),
    BLUE("\u001b[34m"),
    PURPLE("\u001b[35m"),
    WHITEBLUE("\u001b[36m");

    private String color;

    CellColor(String color) {
        this.color = color;
    }

    public String toString() {
        return color;
    }
}
