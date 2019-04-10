package OOP;

import java.io.Serializable;

class Painting<T> extends Art<Painting<T>> implements Serializable {

    private PaintType paint;

    Painting (double width, double heigth, PaintType paint) {
        setHeigth(heigth);
        setWidth(width);
        this.paint = paint;
    }


    public PaintType getPaintType() {
        return paint;
    }

    public void setPaintType(PaintType p) {
        this.paint = p;
    }

//    double dimension() {
//        return getHeight()*getWidth();
//    }

    public String toString() {
        return
            "height: " + getHeight() +
            "; width : " + getWidth() +
            "; dye : " + paint;
        }
    }

