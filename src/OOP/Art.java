package OOP;

import java.io.Serializable;

abstract class Art<T> implements Serializable {
    private double height, width;

    Art(){

    }

    public Art (double width, double height) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeigth(double heigth) {
        this.height = heigth;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

}
