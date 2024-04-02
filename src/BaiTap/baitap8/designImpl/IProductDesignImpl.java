package BaiTap.baitap8.designImpl;

import BaiTap.baitap8.design.IProductDesign;
import BaiTap.baitap8.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class IProductDesignImpl implements IProductDesign {
    public static List<Product> productList = new ArrayList<>();

    @Override
    public Product findById(String id) {
        return null;
    }

    @Override
    public void addNew() {
        System.out.println("How many product you want to add");


    }

    @Override
    public void displayAll() {

    }

    @Override
    public void editElement() {

    }

    @Override
    public void deleteElement() {

    }
}
