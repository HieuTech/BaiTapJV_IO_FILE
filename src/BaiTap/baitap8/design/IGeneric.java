package BaiTap.baitap8.design;

import java.util.List;

public interface IGeneric <T,E>{

    T findById(E id);
    void addNew();
    void displayAll();
    void editElement();
    void deleteElement();

    List<T> readData();
    void writeData();
}
