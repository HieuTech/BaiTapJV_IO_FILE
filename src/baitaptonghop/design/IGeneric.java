package baitaptonghop.design;

import java.util.List;

public interface IGeneric <T, E>{

    T findById(E id);

    void addNew();

    void editElement();


    void displayData();

    void deleteElement();

//    void writeData();
//
//    List<T> readData();

}
