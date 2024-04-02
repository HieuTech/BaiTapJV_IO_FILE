package BaiTap.baitap8.design;

public interface IGeneric <T,E>{

    T findById(E id);
    void addNew();
    void displayAll();
    void editElement();
    void deleteElement();
}
