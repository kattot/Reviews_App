package com.rev.app.reviews_app;

import java.io.Serializable;

/**
 * Created by katto on 4/4/2017.
 */

public class Model implements Serializable {


    private String SearchFieldName;
    private String UPC;
    private String ProductName;
    private String Price;
    private String imageSrc;
    private int itemId;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }



    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }



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
