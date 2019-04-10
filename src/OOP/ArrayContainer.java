package OOP;

import java.io.*;
import java.util.Scanner;

public class ArrayContainer<T> implements Container<T>, Serializable {
    private T[] array = (T[]) new Object[100];
    private int count = 0;
    private File file = new File("in.bin");


    private Scanner sc = new Scanner(System.in);
    private Factory fn = new Factory();

    int getCount() {
        return count;
    }



    @Override
    public void add(T element) {
        if (count == array.length) {
            int newSize = (int) (array.length * 1.5) + 1;
            T[] newArray = (T[]) new Object[newSize];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[count] = element;
        count++;
    }


    @Override
    public void update(int index) {
        if (index >= count) {
            System.out.println("index>count");
        } else {
            T element = array[index];
            if (element.getClass().equals(Painting.class)) {
                System.out.println(" Введите новую ширину");
                double width = sc.nextDouble();
                System.out.println(" Введите новую высоту");
                double heigth = sc.nextDouble();
                System.out.println(" Введите новый тип краски");
                System.out.println(" 1.ACRYLIC 2.OIL 3.WATER");
                int code = sc.nextInt();
                array[index] = (T) fn.createPainting(width, heigth, PaintType.valueOf(code));
            } else if (element.getClass().equals(Sculpture.class)) {
                System.out.println(" Введите новую ширину");
                double width = sc.nextDouble();
                System.out.println(" Введите новую высоту");
                double heigth = sc.nextDouble();
                System.out.println(" Введите новую длинну");
                double length = sc.nextDouble();
                System.out.println(" Введите новый тип материала");
                System.out.println(" 1.MARBLE 2.IRON 3.STONE");
                int code = sc.nextInt();
                array[index] = (T) fn.createSculpture(width, heigth, length, Material.valueOf(code));
            }
        }
    }

    @Override
    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(i + "[" + array[i] + "]");
        }
    }

    @Override
    public void delete(int index) {
        if (count - 1 - index >= 0) System.arraycopy(array, index + 1, array, index, count - 1 - index);
        count--;

    }

    @Override
    public void upload() throws IOException {

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        if (count > 0) {

            try {
                File file = new File("in.bin");
                fos = new FileOutputStream(file);
                oos = new ObjectOutputStream(fos);
                oos.writeInt(count);
                for (int i = 0; i < count; i++) {
                    oos.writeObject(array[i]);
                }
            } finally {
                if (fos != null) {
                    fos.close();
                }
                if (oos != null) {
                    oos.close();
                }
            }
        } else {
            System.out.println("Массив не содержит объектов");
        }
    }


    @Override
    public void load() throws IOException, ClassNotFoundException, NullPointerException {
        if (file.length()==0)
        {
            System.out.println("Файл пуст ");

        }
        else
            try (FileInputStream in = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(in)) {
//            file = new File("in.bin");

                count = ois.readInt();
                System.out.println(count);
                for (int i = 0; i < count; i++) {
                    array[i] = (T) ois.readObject();
                }

            }
    }

    @Override
    public void SortByWidth() {
        for (int i = 0; i < count - 1; i++) {
            Art component = (Art) array[i];
            Art component2 = (Art) array[i + 1];

            if (component.getWidth() > component2.getWidth()) {
                Art buf = (Art) array[i];
                array[i] = array[i + 1];
                array[i + 1] = (T) buf;

            }
        }
    }

    public void SortByHeigth() {
        for (int i = 0; i < count - 1; i++) {
            Art component = (Art) array[i];
            Art component2 = (Art) array[i + 1];

            if (component.getHeight() > component2.getHeight()) {
                Art buf = (Art) array[i];
                array[i] = array[i + 1];
                array[i + 1] = (T) buf;

            }
        }
    }


    @Override
    public double SumWidth() {
        double sum = 0;
        for (int i = 0; i < count; i++) {
            Art component = (Art) array[i];
            sum = sum + component.getWidth();
        }
        return sum;
    }

}
