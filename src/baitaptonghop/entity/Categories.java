package baitaptonghop.entity;

import baitaptonghop.config.ShopConfig;

import java.io.Serializable;
import java.util.List;

public class Categories implements Serializable {

    private int catalogId;

    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;


    public Categories() {
    }

    public Categories(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = catalogId;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "catalogId=" + catalogId +
                ", catalogName='" + catalogName + '\'' +
                ", descriptions='" + descriptions + '\'' +
                ", catalogStatus=" + catalogStatus +
                '}';
    }

    public void displayData() {
        System.out.printf("| ID : %-5s | Name : %-15s | CatalogDesc: %-50s | status: %-5s \n",
                catalogId, catalogName, descriptions, catalogStatus);
        System.out.println("----------------------------------------------------------------------------------");
    }

    public void inputData(boolean isAdd, List<Categories> categoriesList) {
        if (isAdd) {
            this.catalogId = getNewId(categoriesList);
        }
        this.catalogName = checkCatalogName(categoriesList);
        this.descriptions = checkDesc();
        this.catalogStatus = checkStatus();
    }

    private String checkDesc() {
        System.out.println("Input Description");
        return ShopConfig.scanner.nextLine();
    }

    private boolean checkStatus() {

        while (true) {
            System.out.println("Input Status");
            String status = ShopConfig.scanner.nextLine();
            if (status.matches("(true|false)")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Input must true or false");
            }
        }
    }

    private String checkCatalogName(List<Categories> categoriesList) {

        while (true) {
            System.out.println("Input CatalogName");
            String catalogName = ShopConfig.scanner.nextLine();
            if (catalogName.length() < 50 && !catalogName.isEmpty()) {
                if (categoriesList.stream().noneMatch(cate -> cate.getCatalogName().equals(catalogName))) {
                    return catalogName;
                } else {
                    System.err.println("catalogName is exist");
                }
            } else {
                System.err.println("catalogName wrong format");

            }
        }
    }

    private int getNewId(List<Categories> categoriesList) {
        int idMax = 0;
        for (Categories categories : categoriesList) {
            if (categories.getCatalogId() > idMax) {
                idMax = categories.getCatalogId() ;
            }
        }
        return idMax +1;
    }


}
