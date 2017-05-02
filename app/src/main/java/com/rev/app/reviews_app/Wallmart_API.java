package com.rev.app.reviews_app;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.R.attr.id;
import static com.rev.app.reviews_app.R.id.textViewProductName;
import static com.rev.app.reviews_app.R.id.textViewReview;

/**
 * Created by katto on 4/26/2017.
 */

public class Wallmart_API extends Service {

    public Model fetchWallmart(String url1){


   final String TAG = "Error";
        final Model m = new Model();
        JsonObjectRequest jsonObjReq1 = new JsonObjectRequest(Request.Method.GET,
                url1, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    String jsonResponse = null;
                    // Parsing json object response
                    // response will be a json object
                    JSONArray ii = response
                            .getJSONArray("reviews");

                 //   for (int i = 0; i<2; i++) {

                        JSONObject items = (JSONObject) ii.get(0);


                        //   JSONObject items = response.getJSONObject("items");
                        String reviewer = items.getString("reviewer");
                        // reviewerName[0] = reviewer;
                            m.setReviewer_Name(reviewer);
                        String reviewText = items.getString("reviewText");
                        //  mainReview = reviewText;
                        String title = items.getString("title");
                        int upVotes = items.getInt("upVotes");
                            m.setUpvotes(upVotes);
                        //   thumbsUp = upVotes;
                        int downVotes = items.getInt("downVotes");
                        //   thumbsDown[0] = downVotes;
                            m.setDownvotes(downVotes);


              //          jsonResponse = "";
              //          jsonResponse += "     Reviewer: " + reviewer;
              //          // m.setProductName(name);
              //          jsonResponse += "     Review Text: " + reviewText;
                        // m.setUPC(upc);
              //          jsonResponse += "     Title: " + title;
                        // m.setImageSrc(image);
              //          jsonResponse += "     Up Votes: " + upVotes;
              //          jsonResponse += "     Down Votes: " + downVotes;
                        // m.setPrice(price);
                        // jsonResponse = thumbsUp;
//                            }
              //      }
               //     textViewReview.setText(jsonResponse);

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

        Volley.newRequestQueue(this).add(jsonObjReq1);



        return m;
    }

    private static void populate(String image, String price, String name, Model m) {
      //  Model m = new Model();
        m.setImageSrc(image);
        m.setProductName(name);
       // m.setItemId(id);
    }

    // Adding request to request queue
    //

















    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }




    /*


    public Model dispatchRequest() {
        Model response = null;
        final String query = String.format("http://api.walmartlabs.com/v1/reviews/?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq");

        try {
            URL url = new URL(query);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            Log.d("RetrieveFeedTask", "checkpoint1");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            bufferedReader.close();

            Log.d("WalmartService", stringBuilder.toString());
            JSONObject object = (JSONObject) new JSONTokener(stringBuilder.toString()).nextValue();
            JSONArray items = object.getJSONArray("items");
            JSONObject item = items.getJSONObject(0);
            response = new Model();
            response.setProductName(item.getString("name"));
            response.setPrice("$" + item.getString("salePrice"));
            //response.setType(ServiceType.WALMART);
            //response.setItemPurchaseURL(item.getString("addToCartUrl"));
            response.setUPC(item.getString("itemId"));
            response.setImageSrc(item.getString("thumbnailImage"));

        } catch (JSONException e) {
            e.printStackTrace();

        } catch (MalformedURLException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (Exception e) {
            Log.d("RetrieveFeedTask", e.toString());
            //return e.toString();
        }

        return response;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

*/


}



