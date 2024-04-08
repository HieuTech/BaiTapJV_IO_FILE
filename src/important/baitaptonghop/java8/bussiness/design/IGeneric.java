package important.baitaptonghop.java8.bussiness.design;

public interface IGeneric <T,E,B>{

    T findById(E id);

    void addElement();

    void editElement();
    void deleteElement();

    void displayAllData();
    T inputData(B isAdd, T object);
}
