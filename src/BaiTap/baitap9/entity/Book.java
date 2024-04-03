package BaiTap.baitap9.entity;

import BaiTap.baitap9.config.ShopConfig;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private String publisher;
    private float price;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", price=" + price +
                '}';
    }

    public Book(String title, String author, String publisher, float price) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void inputData(){
        System.out.println("Input Book Title");
        this.title = ShopConfig.inputData();
        System.out.println("Input Book Author");
        this.author = ShopConfig.inputData();
        System.out.println("Input Book Publisher");
        this.publisher = ShopConfig.inputData();
        System.out.println("Input Book Price");
        this.price = ShopConfig.getByte();
    }

    public void displayData(){
        System.out.printf("| Title : %-10s | Author : %-15s | price : %-4s | Publisher : %-10s |\n",
                title,author,price,publisher);
        System.out.println("------------------------------------------------------------------------");
    }


}

