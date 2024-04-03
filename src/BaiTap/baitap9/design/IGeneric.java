package BaiTap.baitap9.design;

import java.util.List;

public interface IGeneric <T, E>{

    T findByName(E name);

    void addNew();
    void editElement();
    void displayAll();
    void deleteElement();

    List<T> readData();

    void writeData();


}
