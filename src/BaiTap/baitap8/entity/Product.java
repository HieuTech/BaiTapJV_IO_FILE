package BaiTap.baitap8.entity;

import BaiTap.baitap8.config.ShopConfig;

import java.util.List;

public class Product {
    private String id;
    private String productName;
    private String producer;
    private float price;

    public Product() {
    }

    public Product(String id, String productName, String producer, float price, String desc) {
        this.id = id;
        this.productName = productName;
        this.producer = producer;
        this.price = price;
        this.desc = desc;
    }

    private String desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                '}';
    }

    public void displayData(Product product){
        System.out.println(product.toString());
    }

    public void inputData(List<Product> productList) {

        this.id = checkInputProductID(productList);
        this.productName = checkInputProductID(productList);
        this.desc = checkDescription();
        this.price = checkPrice();
        this.producer = checkProducer();

    }


    public String checkInputProductID(List<Product> productList) {
        while (true) {
            System.out.println("Input ProductID");
            String productID = ShopConfig.getInput();
            if (productID.matches("P\\w{3}")) {
                if (productList.stream().noneMatch(product -> productID.equals(product.getId()))) {
                    return productID;
                } else {
                    System.out.println("Product ID is exist");
                }
            } else {
                System.err.println("Product ID format P___");

            }
        }
    }

    public String checkProductName(List<Product> products){

        while (true){
            System.out.println("Input productName");
            String productName = ShopConfig.getInput();

            if(productName.length() > 5 && productName.length() < 50){
                if(products.stream().noneMatch(p -> p.getProductName().equals(productName))){
                    return productName;
                }else{
                    System.err.println("Product Name is separate");
                }
            }else{
                System.err.println("Product name must greater than 5 characters and less than 50 characters");
            }
        }
    }
    public String checkProducer(){

        while (true){
            System.out.println("Input Producer");
            String producer = ShopConfig.getInput();
            if(producer.length() > 5 && producer.length() < 50){
                return producer;
            }else{
                System.err.println("producer must greater than 5 characters and less than 50 characters");
            }
        }
    }
    public String checkDescription(){

        while (true){
            System.out.println("Input Producer");
            String description = ShopConfig.getInput();
            if(description.length() > 5 && description.length() < 50){
                return description;
            }else{
                System.err.println("description must greater than 5 characters and less than 50 characters");
            }
        }
    }
    public float checkPrice(){
        while (true){
            System.out.println("Input Producer");
            float price = ShopConfig.getFloat();
            if(price > 0){
                return price;
            }else{
                System.err.println("producer must greater than 0");
            }
        }
    }
}
