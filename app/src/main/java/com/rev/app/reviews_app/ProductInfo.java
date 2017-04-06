package com.rev.app.reviews_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ProductInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        Intent i = getIntent();
        final Model m = (Model)i.getSerializableExtra("Model");
        ImageView imageViewProductImage = (ImageView) findViewById(R.id.imageViewProductImage);
        final TextView textViewProductName = (TextView) findViewById(R.id.textViewProductName);
        final TextView textViewPrice = (TextView) findViewById(R.id.textViewPrice);
        final TextView textViewReview = (TextView) findViewById(R.id.textViewReview);

        imageViewProductImage.setImageDrawable(LoadImageFromWebOperations(m.getImageSrc()));

/*        InputStream URLcontent = null;
        try {
            URLcontent = (InputStream) new URL(m.getImageSrc()).getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Drawable image = Drawable.createFromStream(URLcontent,m.getImageSrc());

        imageViewProductImage.setImageDrawable(image);


*/



        textViewProductName.setText(m.getImageSrc());
        textViewPrice.setText(m.getPrice());


        String url = "http://api.walmartlabs.com/v1/search?apiKey=x8cww2sgbv3ekax7d6n7tanq&query=ipod";

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                Log.d("Response", response.toString());

                try {
                    String jsonResponse;
                    // Parsing json object response
                    // response will be a json object
                    JSONArray ii = response
                            .getJSONArray("items");

                    JSONObject items = (JSONObject) ii.get(0);

                    //   JSONObject items = response.getJSONObject("items");
                    String name = items.getString("name");
                    String upc = items.getString("upc");
                    String image = items.getString("mediumImage");
                    String price = items.getString("salePrice");

                    jsonResponse = "";
                    jsonResponse += "Name: " + name;
                    m.setProductName(name);
                    jsonResponse += "UPC: " + upc;
                    m.setUPC(upc);
                    jsonResponse += "image: " + image;
                    m.setImageSrc(image);
                    jsonResponse += "Price: " + price;
                    m.setPrice(price);

//                            }

                    textViewReview.setText(jsonResponse);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
                //hidepDialog();
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Error", "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                // hidepDialog();
            }
        });

        // Adding request to request queue
        //
        // AppController.getInstance().addToRequestQueue(jsonObjReq);
        Volley.newRequestQueue(this).add(jsonObjReq);






























    }


    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is,"https://www.w3schools.com/css/img_fjords.jpg");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src",src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap","returned");
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
            return null;
        }
    }



}
