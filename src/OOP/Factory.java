package OOP;

class Factory {


    Painting createPainting( double width, double heigth, PaintType paint) {
        return new Painting( width, heigth, paint);
    }

    Sculpture createSculpture(double width, double heigth, double length, Material material) {
        return new Sculpture(width, heigth, length, material);
    }
}
