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
    private String itemId;
    private int upvotes, downvotes, stars;
    private String reviewer_Name;
    private String review;

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getReviewer_Name() {
        return reviewer_Name;
    }

    public void setReviewer_Name(String reviewer_Name) {
        this.reviewer_Name = reviewer_Name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title;


    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
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
