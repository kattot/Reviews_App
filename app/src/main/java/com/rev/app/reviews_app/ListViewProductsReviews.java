package com.rev.app.reviews_app;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewProductsReviews extends ArrayAdapter<String> {

    private final Activity context;
    String[] reviewerName;
    String[] stars;
    String[] ups;
    String[] downs;
    String[] mainReview;

    public ListViewProductsReviews(Activity context, String[] reviewerName,
                                                     String[] stars,
                                                     String[] ups,
                                                     String[] downs,
                                                     String[] mainReview) {
        super(context, R.layout.activity_list_view_products_reviews, reviewerName);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.reviewerName = reviewerName;
        this.stars = stars;
        this.ups = ups;
        this.downs = downs;
        this.mainReview = mainReview;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_list_view_products_reviews, null,true);

        TextView textViewReviewerName = (TextView) rowView.findViewById(R.id.textViewReviewername);
        TextView textViewThumbsUp = (TextView) rowView.findViewById(R.id.textViewThumbsUp);
        TextView textViewThumbsDown = (TextView) rowView.findViewById(R.id.textViewThumbsDown);
        TextView textViewStars = (TextView) rowView.findViewById(R.id.textViewStars);
        TextView textViewMainReview = (TextView) rowView.findViewById(R.id.textViewMainReview);

        textViewReviewerName.setText(reviewerName[position]);
        textViewStars.setText(stars[position]);
        textViewThumbsDown.setText(downs[position]);
        textViewThumbsUp.setText(ups[position]);
        textViewMainReview.setText(mainReview[position]);
        return rowView;

    };





}
