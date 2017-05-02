package com.rev.app.reviews_app;

/**
 * Created by katto on 5/1/2017.
 */

public class Fetched_Data {

    String name;
    String title;
    String reviewer;
    String review_text;
    String  upVotes;
    String downVotes;
    String stars;

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public Fetched_Data(String name, String title, String reviewer, String review_text, String upVotes, String downVotes, String stars) {
        this.name = name;
        this.title = title;
        this.reviewer = reviewer;
        this.review_text = review_text;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.stars = stars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReview_text() {
        return review_text;
    }

    public void setReview_text(String review_text) {
        this.review_text = review_text;
    }

    public String getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(String upVotes) {
        this.upVotes = upVotes;
    }

    public String getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(String downVotes) {
        this.downVotes = downVotes;
    }




}
