package OOP;

import java.io.Serializable;

class Sculpture<T> extends Art<Sculpture<T>> implements Serializable {
    private double length;
    private Material material;


    Sculpture (double width, double height, double length, Material material) {
        setWidth(width);
        setHeigth(height);
        this.length = length;
        this.material = material;
    }

    double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

//    double dimension() {
//        return getHeight()*getWidth()*getLength();
//    }

    public String toString() {
        return
                "height: " + getHeight() +
                "; width : " + getWidth() +
                "; length : " + length +
                "; material :" + material;
    }
}
