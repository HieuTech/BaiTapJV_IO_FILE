package baitaptonghop.design;

import baitaptonghop.entity.Product;

public interface IProduct extends IGeneric<Product, String>{

    void sortByPrice();

    void findProductByName();

    void findProductByRangePrice();

}
