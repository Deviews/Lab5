package OOP;

import java.io.IOException;

public interface Container<T> {
    void add (T element);

    void update(int index);

    void printAll();

    void delete(int index);

    void upload() throws IOException;

    void load() throws IOException, ClassNotFoundException;

    void SortByWidth();

    void SortByHeigth();

    double SumWidth();

}
