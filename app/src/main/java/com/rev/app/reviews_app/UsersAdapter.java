package com.rev.app.reviews_app;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by katto on 5/1/2017.
 */

public class UsersAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<Fetched_Data> DataList;
  //  ImageLoader imageLoader = Controller.getPermission().getImageLoader();

    public UsersAdapter(Activity activity, List<Fetched_Data> dataitem) {
        this.activity = activity;
        this.DataList = dataitem;
    }

    @Override
    public int getCount() {
        return DataList.size();
    }

    @Override
    public Object getItem(int location) {
        return DataList.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.activity_list_view_products_reviews, null);

   //     if (imageLoader == null)
   //         imageLoader = Controller.getPermission().getImageLoader();
   //     NetworkImageView thumbNail = (NetworkImageView) convertView
   //             .findViewById(R.id.thumbnail);
        TextView textViewReviewerName = (TextView) convertView.findViewById(R.id.textViewReviewername);
        TextView textViewThumbsUp = (TextView) convertView.findViewById(R.id.textViewThumbsUp);
        TextView textViewThumbsDown = (TextView) convertView.findViewById(R.id.textViewThumbsDown);
        TextView textViewStars = (TextView) convertView.findViewById(R.id.textViewStars);
        TextView textViewMainReview = (TextView) convertView.findViewById(R.id.textViewMainReview);
        Fetched_Data m = DataList.get(position);
      //  thumbNail.setImageUrl(m.getImage(), imageLoader);

        textViewReviewerName.setText(m.getName());
        textViewMainReview.setText(m.getReview_text());
        textViewStars.setText(m.getStars());
        textViewThumbsDown.setText(m.getDownVotes());
        textViewThumbsUp.setText(m.getUpVotes());
       // worth.setText(String.valueOf(m.getWorth()));
      //  year.setText(String.valueOf(m.getYear()));

        return convertView;
    }

}


        /*

        extends ArrayAdapter<Fetched_Data> {
    public UsersAdapter(Context context, ArrayList<Fetched_Data> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View rowView, ViewGroup parent) {
        // Get the data item for this position
        Fetched_Data user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (rowView == null) {
            rowView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_view_products_reviews, parent, false);
        }
        // Lookup view for data population
        TextView textViewReviewerName = (TextView) rowView.findViewById(R.id.textViewReviewername);
        TextView textViewThumbsUp = (TextView) rowView.findViewById(R.id.textViewThumbsUp);
        TextView textViewThumbsDown = (TextView) rowView.findViewById(R.id.textViewThumbsDown);
        TextView textViewStars = (TextView) rowView.findViewById(R.id.textViewStars);
        TextView textViewMainReview = (TextView) rowView.findViewById(R.id.textViewMainReview);
         //   Populate the data into the template view using the data object
        textViewReviewerName.setText(user.getName());
        textViewThumbsDown.setText(user.getDownVotes());
        // Return the completed view to render on screen
        return rowView;
    }
}








        */