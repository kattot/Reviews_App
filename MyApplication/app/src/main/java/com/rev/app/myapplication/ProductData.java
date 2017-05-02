package com.rev.app.myapplication;

import java.util.ArrayList;

/**
 * Created by katto on 4/28/2017.
 */

public class ProductData {
    String name;
    String reviewer;
    String title;

    public ProductData(String name, String reviewer, String title) {
        this.name = name;
        this.reviewer = reviewer;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
