package com.rev.app.reviews_app;

/**
 * Created by katto on 4/4/2017.
 */

public class Model {


    private String SearchFieldName;
    private String UPC;
    private String ProductName;
    private String Price;

    public String getSearchFieldName() {
        return SearchFieldName;
    }

    public void setSearchFieldName(String searchFieldName) {
        SearchFieldName = searchFieldName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }


    public String getUPC() {
        return UPC;
    }

    public void setUPC(String UPC) {
        this.UPC = UPC;
    }


    public String getData() {
        return SearchFieldName;
    }

    public void setData(String data) {
        this.SearchFieldName = data;
    }



    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }
}
