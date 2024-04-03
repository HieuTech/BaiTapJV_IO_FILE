package baitaptonghop.entity;

import baitaptonghop.config.ShopConfig;
import baitaptonghop.run.CategoriesManagement;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

public class Product implements Serializable {
    private String productId, productName, description;
    private int catalogId, productStatus;
    private LocalDate created;
    private float price;

    public Product() {
    }

    public Product(String productId, String productName, String description, int catalogId, int productStatus, LocalDate created, float price) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
        this.created = created;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void displayData(){
        System.out.printf("| ID : %-5s | Name : %-15s | date: %-10s | status: %-7s | price: %-4s | catalogID %-3s\n",
                productId, productName, created, (productStatus == 0 ? "Dang ban" :
                        (productStatus == 1 ? "Het hang ": "ko ban ")), price, catalogId);
        System.out.println("----------------------------------------------------------------------------------");


    }

    public void inputData(boolean isAdd,List<Categories> categoriesList, List<Product> productList){
        if(isAdd){
            this.productId = checkProductID(productList);
        }
        this.productName = checkProductName(productList);
        this.productStatus = checkProductStatus();
        this.price = checkPrice();
        this.created = checkProductDate();
        System.out.println("input description");
        this.description = ShopConfig.scanner.nextLine();
        this.catalogId = checkCatalogId(categoriesList);
    }

    public int checkCatalogId(List<Categories> categoriesList){

        if(categoriesList.isEmpty()){
            System.out.println("Categories is empty, you must add categories first");
            CategoriesManagement categoriesManagement = new CategoriesManagement();
            categoriesManagement.displayCategoriesMenu();
        }
       while (true){
           System.out.println("input catalog ID");
           int catalogId = ShopConfig.getInt();

           if(categoriesList.stream().anyMatch(cate -> cate.getCatalogId() == catalogId)){
               return catalogId;
           }else{
               System.out.println("catalogID not found, please try another categories");

           }
       }
    }

    public int checkProductStatus(){
        while (true){
            System.out.println("Input product status");
            int status = ShopConfig.getInt();
            if(status == 0 || status == 1 || status == 2){
               return status;
            }else{
                System.err.println("status must in value 0 | 1 |2");
            }
        }

    }

    public LocalDate checkProductDate(){

        while (true){
            System.out.println("Input product Date");
            String productDate = ShopConfig.scanner.nextLine();
            try{
                return LocalDate.parse(productDate,ShopConfig.dtf);
            }catch (DateTimeParseException e) {
                System.err.println("Value must match pattern dd/MM/yyyy");
            }
        }
    }

    public String checkProductID(List<Product> productList) {

        while (true) {
            System.out.println("Input productID");
            String productID = ShopConfig.scanner.nextLine();
            if ((productID.startsWith("P") || productID.startsWith("C") || productID.startsWith("S")) && productID.length() >= 4) {
                if (productList.stream().noneMatch(p -> p.productId.equals(productID))) {
                    return productID;
                } else {
                    System.err.println("product ID is exist");
                }
            } else {
                System.err.println("product ID start with P___ | S___ | C___");
            }
        }
    }
    public String checkProductName(List<Product> productList){

        while (true){
            System.out.println("input productName");
            String productName = ShopConfig.scanner.nextLine();
            if(productName.length() > 10 && productName.length() < 50){
                if(productList.stream().noneMatch(p -> p.productName.equals(productName))){
                    return productName;
                }else{
                    System.err.println("product name is exist");
                }
            }else{
                System.err.println("product name between 10 and 50 characters");
            }
        }
    }
    public float checkPrice(){
        while (true){
            System.out.println("Input price");
            float price = ShopConfig.getFLoat();
            if(price > 0){
                return price;
            }else{
                System.err.println("price must greater than 0");
            }
        }
    }

}
