package com.rev.app.reviews_app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.ListView;
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
import java.util.ArrayList;

public class ProductInfo extends AppCompatActivity {

    String[] reviewerName;
    String[] thumbsUp;
    String[] thumbsDown;
    String[] mainReview;
    String[] stars;


    TextView textViewProductName;
    TextView textViewPrice;
    TextView textViewReview;
    String TAG = "ABC";
    String ids;

    datas d;


    ListView listViewReviews;
   // ListView.AdapterContextMenuInfo adapterContextMenuInfo;
   // ListView.LayoutParams layoutParams;

    WebView webViewProductImage;
   // String id;
    String UPC = null;
    Intent i;
    String product_name;
    Wallmart_API wallmart_api = new Wallmart_API();
    Model m_wallmart = new Model();

    ArrayList<Fetched_Data> fetched_datas;
    UsersAdapter adapter;
    TestAPI testAPI;

    @Override
    protected void onStart() {
        super.onStart();

       // testAPI = new TestAPI(this);

      //  fetched_datas = testAPI.getList();

       // String url1 = "http://api.walmartlabs.com/v1/reviews/"+ ids +"?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";

        String url1 = "http://api.walmartlabs.com/v1/reviews/21805451?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";


        //   final String[] finalReviewerName = reviewerName;
   /*     JsonObjectRequest jsonObjReq1 = new JsonObjectRequest(Request.Method.GET,
                url1, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                Log.d("Response", response.toString());

                try {
                    String jsonResponse = null;
                    // Parsing json object response
                    // response will be a json object
                    JSONArray ii = response
                            .getJSONArray("reviews");

                    for (int i = 0; i<2; i++) {

                        JSONObject items = (JSONObject) ii.get(i);
                        // JSONObject rate = items.getJSONObject("overallRating");
                        String rate = items.getJSONObject("overallRating").getString("rating");
                        // JSONObject rate = items.getJSONObject("overallRating");

                        //int stars = rate.getInt("rating");

*//*
                        //   JSONObject items = response.getJSONObject("items");
                        String reviewer = items.getString("reviewer");
                        // reviewerName[0] = reviewer;

                        String reviewText = items.getString("reviewText");
                        //  mainReview = reviewText;
                        String title = items.getString("title");
                        String upVotes = items.getString("upVotes");
                        //   thumbsUp = upVotes;
                        String downVotes = items.getString("downVotes");
                        //   thumbsDown[0] = downVotes;


                        jsonResponse = "";
                        jsonResponse += "     Reviewer: " + reviewer;
                        // m.setProductName(name);
                        jsonResponse += "     Review Text: " + reviewText;
                        // m.setUPC(upc);
                        jsonResponse += "     Title: " + title;
                        // m.setImageSrc(image);
                        jsonResponse += "     Up Votes: " + upVotes;
                        jsonResponse += "     Down Votes: " + downVotes;
                        // m.setPrice(price);
                        // jsonResponse = thumbsUp;

*//*
//                        textViewProductName.setText(jsonResponse);

                        Fetched_Data fetched_data = new Fetched_Data(items.getString("name"),
                                items.getString("title"),
                                items.getString("reviewer"),
                                items.getString("reviewText"),
                                items.getString("upVotes"),
                                items.getString("downVotes"),rate);

                        fetched_datas.add(fetched_data);
                        // Toast.makeText(getApplicationContext(),fetched_data.getTitle(),Toast.LENGTH_SHORT);




//                            }
                    }
                    textViewReview.setText(fetched_datas.get(1).getTitle());
                    adapter.notifyDataSetChanged();


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
        Volley.newRequestQueue(this).add(jsonObjReq1);


*/




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);

        i = getIntent();
        product_name = (String) i.getSerializableExtra("prodName");
        //final Model m = (Model)i.getSerializableExtra("Model");
        //final ImageView imageViewProductImage = (ImageView) findViewById(R.id.imageViewProductImage);
        textViewProductName = (TextView) findViewById(R.id.textViewProductName);
        textViewPrice = (TextView) findViewById(R.id.textViewPrice);
        textViewReview = (TextView) findViewById(R.id.textViewReview);
        listViewReviews = (ListView) findViewById(R.id.listViewReviews);
        webViewProductImage = (WebView) findViewById(R.id.webViewProductImage);

        fetched_datas = new ArrayList<Fetched_Data>();
       // adapter = new UsersAdapter(this,R.layout.activity_list_view_products_reviews, R.id.textViewStars,fetched_datas);
        adapter = new UsersAdapter(this,fetched_datas);
        String json_url = "http://api.walmartlabs.com/v1/reviews/21805451?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";

        listViewReviews.setAdapter(adapter);

     //   testAPI = new TestAPI(this);

       // fetched_datas = testAPI.getList();

     //   if(fetched_datas == null){

     //   }

        //final String[] id = new String[1];

      //  final Model m = new Model();




        String url = "http://api.walmartlabs.com/v1/search?apiKey=x8cww2sgbv3ekax7d6n7tanq&query="+product_name;

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());

                try {
                    String jsonResponse;
                    // Parsing json object response
                    // response will be a json object
                    JSONArray ii = response
                            .getJSONArray("items");

                    JSONObject items = (JSONObject) ii.get(0);

                    //   JSONObject items = response.getJSONObject("items");
                    String name = items.getString("name");
                    String product_id = items.getString("itemId");
                 //   d = new datas(product_id);
                 //   setId(Integer.parseInt(product_id));
                 //   m.setItemId(id[0]);
                    textViewProductName.setText(product_id);
                    String upc = items.getString("upc");
                    String image = items.getString("mediumImage");

                    webViewProductImage.loadUrl(image);






                    String price = items.getString("salePrice");
                    textViewPrice.setText(price);
                    int productID = items.getInt("itemId");
                    // m.setItemId(productID);
                    int idsss = productID;
                    execute(idsss);

                    jsonResponse = "";
                    jsonResponse += "Name: " + name;
                    // m.setProductName(name);
                    jsonResponse += "UPC: " + upc;
                    // m.setUPC(upc);
                    jsonResponse += "image: " + image;
                    // m.setImageSrc(image);
                    jsonResponse += "Price: " + price;
                    // m.setPrice(price);

//                            }
               //     Toast.makeText(getApplicationContext(),"Yellow Mellow",Toast.LENGTH_SHORT);
                    //  tv.setText(jsonResponse);

//                    VolleyCallback callback = null;
//                    callback.onSuccess(ids);

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
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                // hidepDialog();
            }
        });

        // Adding request to request queue
        //
        // AppController.getInstance().addToRequestQueue(jsonObjReq);
        Volley.newRequestQueue(ProductInfo.this).add(jsonObjReq);
        //  Volley.










    //   String pp = (String) textViewProductName.getText();
       // textViewPrice.setText(ids);



















/*



        String url1 = "http://api.walmartlabs.com/v1/reviews/"+ d.getIds() +"?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";

        //   final String[] finalReviewerName = reviewerName;
        JsonObjectRequest jsonObjReq1 = new JsonObjectRequest(Request.Method.GET,
                url1, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                Log.d("Response", response.toString());

                try {
                    String jsonResponse = null;
                    // Parsing json object response
                    // response will be a json object
                    JSONArray ii = response
                            .getJSONArray("reviews");

                    for (int i = 0; i<2; i++) {

                        JSONObject items = (JSONObject) ii.get(i);
                       // JSONObject rate = items.getJSONObject("overallRating");
                        String rate = items.getJSONObject("overallRating").getString("rating");
                       // JSONObject rate = items.getJSONObject("overallRating");

                        //int stars = rate.getInt("rating");
*/
/*
                        //   JSONObject items = response.getJSONObject("items");
                        String reviewer = items.getString("reviewer");
                        // reviewerName[0] = reviewer;

                        String reviewText = items.getString("reviewText");
                        //  mainReview = reviewText;
                        String title = items.getString("title");
                        String upVotes = items.getString("upVotes");
                        //   thumbsUp = upVotes;
                        String downVotes = items.getString("downVotes");
                        //   thumbsDown[0] = downVotes;


                        jsonResponse = "";
                        jsonResponse += "     Reviewer: " + reviewer;
                        // m.setProductName(name);
                        jsonResponse += "     Review Text: " + reviewText;
                        // m.setUPC(upc);
                        jsonResponse += "     Title: " + title;
                        // m.setImageSrc(image);
                        jsonResponse += "     Up Votes: " + upVotes;
                        jsonResponse += "     Down Votes: " + downVotes;
                        // m.setPrice(price);
                        // jsonResponse = thumbsUp;

*/
//                        textViewProductName.setText(jsonResponse);
/*
                        Fetched_Data fetched_data = new Fetched_Data(items.getString("name"),
                                items.getString("title"),
                                items.getString("reviewer"),
                                items.getString("reviewText"),
                                items.getString("upVotes"),
                                items.getString("downVotes"),rate);

                         fetched_datas.add(fetched_data);
                        // Toast.makeText(getApplicationContext(),fetched_data.getTitle(),Toast.LENGTH_SHORT);




//                            }
                    }
                    textViewReview.setText(fetched_datas.get(1).getTitle());
                    adapter.notifyDataSetChanged();


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
        Volley.newRequestQueue(this).add(jsonObjReq1);


*/




            //textViewProductName.setText(id.toString());










/*
     //   String url1 = "http://api.walmartlabs.com/v1/reviews/"+ Integer.parseInt(id[0]) +"?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";

        //   final String[] finalReviewerName = reviewerName;
        JsonObjectRequest jsonObjReq1 = new JsonObjectRequest(Request.Method.GET,
                json_url, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                Log.d("Response", response.toString());

                try {
                    String jsonResponse = null;
                    // Parsing json object response
                    // response will be a json object
                    JSONArray ii = response
                            .getJSONArray("reviews");

                    for (int i = 0; i<1; i++) {

                        JSONObject items = (JSONObject) ii.get(i);


                        //   JSONObject items = response.getJSONObject("items");
                        String reviewer = items.getString("reviewer");
                        // reviewerName[0] = reviewer;

                        String reviewText = items.getString("reviewText");
                        //  mainReview = reviewText;
                        String title = items.getString("title");
                        String upVotes = items.getString("upVotes");
                        //   thumbsUp = upVotes;
                        String downVotes = items.getString("downVotes");
                        //   thumbsDown[0] = downVotes;


                        jsonResponse = "";
                        jsonResponse += "     Reviewer: " + reviewer;
                        // m.setProductName(name);
                        jsonResponse += "     Review Text: " + reviewText;
                        // m.setUPC(upc);
                        jsonResponse += "     Title: " + title;
                        // m.setImageSrc(image);
                        jsonResponse += "     Up Votes: " + upVotes;
                        jsonResponse += "     Down Votes: " + downVotes;
                        // m.setPrice(price);
                        // jsonResponse = thumbsUp;
//                            }

                        textViewProductName.setText(jsonResponse);

                        Fetched_Data fetched_data = new Fetched_Data(items.getString("name"),
                                items.getString("title"),
                                items.getString("reviewer"),
                                items.getString("reviewText"),
                                items.getInt("upVotes"),
                                items.getInt("downVotes"));

                       // fetched_datas.add(fetched_data);
                       // Toast.makeText(getApplicationContext(),fetched_data.getTitle(),Toast.LENGTH_SHORT);


                    }


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

       // textViewReview.setText("Hello");







*/














/*



        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, (String)json_url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        int count = 0;
                        while (count<1){
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);
                                Fetched_Data fetched_data = new Fetched_Data(jsonObject.getString("name"),
                                        jsonObject.getString("salePrice"),
                                        jsonObject.getString("categoryPath"),
                                        jsonObject.getString("brandName"),
                                        jsonObject.getInt("upc"),
                                        0);

                                fetched_datas.add(fetched_data);
                                count++;

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        //adapter.notifyDataSetChanged();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Error....",Toast.LENGTH_SHORT).show();

            }
        }


        );


*/
















      //  MySingleton.getmInstance(this).addToRequestqueue(jsonObjReq1);






       // Fetched_Data f = (Fetched_Data)fetched_datas.get(0);


       // Toast.makeText(this,""  ,Toast.LENGTH_SHORT);










        //

      //  Model m = wallmart_api.dispatchRequest();

      //  textViewPrice.setText(m.getPrice() + m.getImageSrc());



      //  String url1 = "http://api.walmartlabs.com/v1/reviews/21805451?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";

        //   final String[] finalReviewerName = reviewerName;


//        AppController.getInstance().addToRequestQueue(jsonObjReq1);

      //  JsonObjectRequest jsonObjReq1 = null;

//       m_wallmart = wallmart_api.fetchWallmart(url1);




    //    Volley.newRequestQueue(this).add(jsonObjReq1);

//        textViewProductName.setText(m_wallmart.getReviewer_Name()+m_wallmart.getDownvotes()+"  "+m_wallmart.getUpvotes());


























        //imageViewProductImage.setImageDrawable(LoadImageFromWebOperations(m.getImageSrc()));


/*        InputStream URLcontent = null;
        try {
            URLcontent = (InputStream) new URL(m.getImageSrc()).getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Drawable image = Drawable.createFromStream(URLcontent,m.getImageSrc());

        imageViewProductImage.setImageDrawable(image);


*/


        //ImageView iv = (ImageView) findViewById(R.id.imageView);
        //String str = m.getImageSrc();

//        ImageLoader.getInstance().displayImage(str, imageViewProductImage);


        // textViewProductName.setText(m.getImageSrc());
        // textViewPrice.setText(m.getPrice());


/*
        String url = "http://api.walmartlabs.com/v1/search?apiKey=x8cww2sgbv3ekax7d6n7tanq&query="+product_name;

    JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
            url, null, new Response.Listener<JSONObject>() {


        @Override
        public void onResponse(JSONObject response) {
            Log.d(TAG, response.toString());

            try {
                String jsonResponse;
                // Parsing json object response
                // response will be a json object
                JSONArray ii = response
                        .getJSONArray("items");

                JSONObject items = (JSONObject) ii.get(0);

                //   JSONObject items = response.getJSONObject("items");
                String name = items.getString("name");
                String product_id = items.getString("itemId");
                id[0] = product_id;
                textViewProductName.setText(product_id);
                String upc = items.getString("upc");
                String image = items.getString("mediumImage");

                webViewProductName.loadUrl(image);






                String price = items.getString("salePrice");
                textViewPrice.setText(price);
                int productID = items.getInt("itemId");
               // m.setItemId(productID);

                jsonResponse = "";
                jsonResponse += "Name: " + name;
               // m.setProductName(name);
                jsonResponse += "UPC: " + upc;
               // m.setUPC(upc);
                jsonResponse += "image: " + image;
               // m.setImageSrc(image);
                jsonResponse += "Price: " + price;
               // m.setPrice(price);

//                            }

              //  tv.setText(jsonResponse);

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
            VolleyLog.d(TAG, "Error: " + error.getMessage());
            Toast.makeText(getApplicationContext(),
                    error.getMessage(), Toast.LENGTH_SHORT).show();
            // hide the progress dialog
            // hidepDialog();
        }
    });

    // Adding request to request queue
    //
    // AppController.getInstance().addToRequestQueue(jsonObjReq);
        Volley.newRequestQueue(ProductInfo.this).add(jsonObjReq);
      //  Volley.




*/

















      //  ListViewProductsReviews adapter = new ListViewProductsReviews(this,reviewerName,stars,thumbsUp,thumbsDown,mainReview);


    //    listViewReviews.setAdapter(adapter);








        /*


        String url1 = "http://api.walmartlabs.com/v1/reviews/21805451?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";

     //   final String[] finalReviewerName = reviewerName;
        JsonObjectRequest jsonObjReq1 = new JsonObjectRequest(Request.Method.GET,
                url1, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                Log.d("Response", response.toString());

                try {
                    String jsonResponse = null;
                    // Parsing json object response
                    // response will be a json object
                    JSONArray ii = response
                            .getJSONArray("reviews");

                    for (int i = 0; i<2; i++) {

                        JSONObject items = (JSONObject) ii.get(i);


                        //   JSONObject items = response.getJSONObject("items");
                        String reviewer = items.getString("reviewer");
                       // reviewerName[0] = reviewer;

                        String reviewText = items.getString("reviewText");
                      //  mainReview = reviewText;
                        String title = items.getString("title");
                        String upVotes = items.getString("upVotes");
                     //   thumbsUp = upVotes;
                        String downVotes = items.getString("downVotes");
                     //   thumbsDown[0] = downVotes;


                        jsonResponse = "";
                        jsonResponse += "     Reviewer: " + reviewer;
                        // m.setProductName(name);
                        jsonResponse += "     Review Text: " + reviewText;
                        // m.setUPC(upc);
                        jsonResponse += "     Title: " + title;
                        // m.setImageSrc(image);
                        jsonResponse += "     Up Votes: " + upVotes;
                        jsonResponse += "     Down Votes: " + downVotes;
                        // m.setPrice(price);
                       // jsonResponse = thumbsUp;
//                            }
                    }
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
        Volley.newRequestQueue(this).add(jsonObjReq1);




      //  ListViewProductsReviews adapter = new ListViewProductsReviews(this,reviewerName,stars,thumbsUp,thumbsDown,mainReview);


    //    listViewReviews.setAdapter(adapter);








        */


















/*
        String b = null;


        try {

            URL url = new URL("http://api.walmartlabs.com/v1/reviews/21805451?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq");
//            String url1 = "http://api.walmartlabs.com/v1/reviews/"+ Integer.parseInt(id[0]) +"?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
                bufferedReader.close();
                b = stringBuilder.toString();
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage(), e);
        }

       // b = b.substring(0,200);

        textViewReview.setText(b);
*/

    }


    public void execute(int idsss){

         String url1 = "http://api.walmartlabs.com/v1/reviews/"+ idsss +"?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";

     //   String url1 = "http://api.walmartlabs.com/v1/reviews/21805451?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";


        //   final String[] finalReviewerName = reviewerName;
        JsonObjectRequest jsonObjReq1 = new JsonObjectRequest(Request.Method.GET,
                url1, null, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {
                Log.d("Response", response.toString());

                try {
                    String jsonResponse = null;
                    // Parsing json object response
                    // response will be a json object
                    JSONArray ii = response
                            .getJSONArray("reviews");

                        int i = 0;
                 //       for (int i=0; i< 10; i++){
                        while(ii.length() >= i ){
                            if(i==5) break;

                        JSONObject items = (JSONObject) ii.get(i);
                        // JSONObject rate = items.getJSONObject("overallRating");
                        String rate = items.getJSONObject("overallRating").getString("rating");
                        // JSONObject rate = items.getJSONObject("overallRating");

                        //int stars = rate.getInt("rating");

/*
                        //   JSONObject items = response.getJSONObject("items");
                        String reviewer = items.getString("reviewer");
                        // reviewerName[0] = reviewer;

                        String reviewText = items.getString("reviewText");
                        //  mainReview = reviewText;
                        String title = items.getString("title");
                        String upVotes = items.getString("upVotes");
                        //   thumbsUp = upVotes;
                        String downVotes = items.getString("downVotes");
                        //   thumbsDown[0] = downVotes;


                        jsonResponse = "";
                        jsonResponse += "     Reviewer: " + reviewer;
                        // m.setProductName(name);
                        jsonResponse += "     Review Text: " + reviewText;
                        // m.setUPC(upc);
                        jsonResponse += "     Title: " + title;
                        // m.setImageSrc(image);
                        jsonResponse += "     Up Votes: " + upVotes;
                        jsonResponse += "     Down Votes: " + downVotes;
                        // m.setPrice(price);
                        // jsonResponse = thumbsUp;

*/
//                        textViewProductName.setText(jsonResponse);

                        Fetched_Data fetched_data = new Fetched_Data(items.getString("name"),
                                items.getString("title"),
                                items.getString("reviewer"),
                                items.getString("reviewText"),
                                items.getString("upVotes"),
                                items.getString("downVotes"),rate);

                        fetched_datas.add(fetched_data);
                        // Toast.makeText(getApplicationContext(),fetched_data.getTitle(),Toast.LENGTH_SHORT);




                           // if (ii.get(i+1)==null)
                            //    break;
                            i++;
//                            }

                    }
                    textViewReview.setText(fetched_datas.get(1).getTitle());
                    adapter.notifyDataSetChanged();


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
        Volley.newRequestQueue(this).add(jsonObjReq1);









    }









 /*   public interface VolleyCallback {
        void onSuccess(String idss);
    }

    public void onResume(){
        super.onResume();

        getString(new VolleyCallback(){


            @Override
            public void onSuccess(String idss) {
                ids = idss;
            }
        });








    }

    private void getString(VolleyCallback volleyCallback) {
    }
*/

    private static class datas{

    public datas(String ids) {
        this.ids = ids;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    String ids;



}

/*

    private void fetch(RequestQueue requestQueue) {
        JsonArrayRequest request = new JsonArrayRequest("http://example.com/feed.json",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        for(int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                //fetched_datas = new Fetched_Data();
                                fetched_datas.add(jsonObject.getString(""));
                            }
                            catch(JSONException e) {
                                mEntries.add("Error: " + e.getLocalizedMessage());
                            }
                        }

                        allDone();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(ProductInfo.this, "Unable to fetch data: " + volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

        mEntries = new ArrayList<>();
        requestQueue.add(request);
    }




*/






















    public Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is,"Image");
            return d;
        } catch (Exception e) {
            return null;
        }
    }

    public Bitmap getbmpfromURL(String surl){
        try {
            URL url = new URL(surl);
            HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
            urlcon.setDoInput(true);
            urlcon.connect();
            InputStream in = urlcon.getInputStream();
            Bitmap mIcon = BitmapFactory.decodeStream(in);
            return  mIcon;
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
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
