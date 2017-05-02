package com.rev.app.reviews_app;
//package com.android.volley.toolbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class MainActivity extends AppCompatActivity {


    String TAG = "ABC";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PullAPICon pull = new PullAPICon();
        setContentView(R.layout.activity_main);
        final EditText editText = (EditText) findViewById(R.id.editTextProductName);
        final TextView tv = (TextView) findViewById(R.id.textViewProductName);
        Button buttonSearch = (Button) findViewById(R.id.buttonSearchProduct);
        Button buttonBarcode = (Button)findViewById(R.id.buttonBarcode);
        Button buttonVoice = (Button) findViewById(R.id.buttonVoice);
        final Model m = new Model();
        //final String data = editText.getText().toString();

        final String[] productName = new String[1];
/*
        String url = "http://api.walmartlabs.com/v1/search?apiKey=x8cww2sgbv3ekax7d6n7tanq&query=ipod";

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
                    String upc = items.getString("upc");
                    String image = items.getString("mediumImage");
                    String price = items.getString("salePrice");
                    int productID = items.getInt("itemId");
                    m.setItemId(productID);

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

                    tv.setText(jsonResponse);

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
        Volley.newRequestQueue(MainActivity.this).add(jsonObjReq);


*/










        buttonSearch.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

               // productName[0] = editText.getText().toString();
               // m.setProductName(productName[0]);



                Intent i = new Intent(MainActivity.this,ProductInfo.class);
                i.putExtra("prodName", editText.getText().toString());
                startActivity(i);


            }
        });




/*
        String url = "http://api.walmartlabs.com/v1/reviews/12417832?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";

            JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                    url, null, new Response.Listener<JSONObject>() {


                @Override
                public void onResponse(JSONObject response) {
                    Log.d(TAG, response.toString());

                    try {
                        String jsonResponse;
                        // Parsing json object response
                        // response will be a json object
                        String name = response.getString("name");
                        String email = response.getString("upc");
                        //JSONObject phone = response.getJSONObject("brandName");
                        String home = response.getString("brandName");
                        //String mobile = phone.getString("mobile");

                        jsonResponse = "";
                        jsonResponse += "upc: " + name;
                        jsonResponse += "Email: " + email;
                        jsonResponse += "Home: " + home;
                        //jsonResponse += "Mobile: " + mobile + "\n\n";

                        tv.setText(jsonResponse);

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
        Volley.newRequestQueue(this).add(jsonObjReq);

*/









/*
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                        try {
                            String jsonResponse;
                            // Parsing json array response
                            // loop through each json object
                            jsonResponse = "";
                          //  for (int i = 0; i < response.length(); i++) {

                                JSONObject person = (JSONObject) response
                                        .get(0);

                                JSONObject items = person.getJSONObject("items");
                                String name = items.getString("name");
                                String upc = items.getString("upc");
                                String image = items.getString("mediumImage");
                                String price = items.getString("salePrice");

                                jsonResponse += "Name: " + name;
                                jsonResponse += "UPC: " + upc;
                                jsonResponse += "image: " + image;
                                jsonResponse += "Price: " + price;

//                            }

                            tv.setText(jsonResponse);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }

                      //  hidepDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
           //     hidepDialog();
            }
        });

        // Adding request to request queue
        Volley.newRequestQueue(this).add(req);

*/














        /*
// Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handling
                        tv.setText(response.substring(0,100));

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                tv.setText("Something went wrong!");
                error.printStackTrace();

            }
        });

// Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);



//asdasdas

*/




//        String url = "http://httpbin.org/get?site=code&network=tutsplus";
/*
        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // the response is already constructed as a JSONObject!
                        try {
                            //response = response.getJSONObject("upc");
                            String site = response.getJSONObject("upc").getString("upc");
                                   // network = response.getString("network");
                            tv.setText("Site: "+site+"\nNetwork: ");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        Volley.newRequestQueue(this).add(jsonRequest);


*/





        //showpDialog();
        //String ur = "http://api.walmartlabs.com/v1/reviews/12417832?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";












        //   tv.setText(pull.pullRequest());


/*
        Context context = getApplicationContext();
        String str = pull.pullRequest();
        CharSequence text = str;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
       // tv.setText(TAG);



       // tv.setText(request());


        //editText.setText(request());




       // m.setData(pull.pullRequest());



        if(m.getData() != null) {
           // text = m.getData();
         //   toast.show();

          //  tv.setText("Success");
          //  editText.setText("Success");
        }else {

          //  tv.setText("Wrong");
          //  editText.setText("Wrong");
       }



*/








        //String url = "http://api.walmartlabs.com/v1/reviews/12417832?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";
/*
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                tv.setText("Response: " + response.toString());
                Toast.makeText(getApplicationContext(),response.toString(),Toast.LENGTH_SHORT);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub

            }
        });

// Access the RequestQueue through your singleton class.
      //  MySingleton.getInstance(this).addToRequestQueue(jsObjRequest);





*/





/*
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        tv.setText("Response is: "+ response.substring(0,500));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText("That didn't work!");
            }
        });


*/
















/*


        try {

            StringBuilder result = new StringBuilder();
            URL u = new URL("http://api.walmartlabs.com/v1/reviews/12417832?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq");
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line="";
            while ((line = rd.readLine()) != null) {
                //System.out.print(line);
                result.append(line);
            }
            rd.close();

            data = result.toString();

            //System.out.println(data);
            tv.setText(data);

        }catch (Exception e) {
            tv.setText("Wrong");
        }



*/


/*        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                urlConnection.setRequestMethod("GET");
                //urlConnection.connect();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                data = stringBuilder.toString();
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            data = "Wrong";
        }




*/


/*
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        // Will contain the raw JSON response as a string.
        String forecastJsonStr = null;

        try {
            // Construct the URL for the OpenWeatherMap query
            // Possible parameters are avaiable at OWM's forecast API page, at
            // http://openweathermap.org/API#forecast
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7");

            // Create the request to OpenWeatherMap, and open the connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
           // if (inputStream == null) {
                // Nothing to do.
           //     data =  null;
           // }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line + "\n");
            }

          //  if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
          //      data =  null;
          //  }
            forecastJsonStr = buffer.toString();
        } catch (IOException e) {
            Log.e("PlaceholderFragment", "Error ", e);
            // If the code didn't successfully get the weather data, there's no point in attemping
            // to parse it.
            data = "Wrong";
        } finally{
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }

        data = forecastJsonStr;





*/

























        //  tv.setText(data);
        //  editText.setText(data);


    }





    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }











/*

    public String request(){

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;

        // Will contain the raw JSON response as a string.
        String forecastJsonStr = null;

        try {
            // Construct the URL for the OpenWeatherMap query
            // Possible parameters are avaiable at OWM's forecast API page, at
            // http://openweathermap.org/API#forecast
            URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7");

            // Create the request to OpenWeatherMap, and open the connection
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // Read the input stream into a String
            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();
            if (inputStream == null) {
                // Nothing to do.
                return null;
            }
            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                // But it does make debugging a *lot* easier if you print out the completed
                // buffer for debugging.
                buffer.append(line + "\n");
            }

            if (buffer.length() == 0) {
                // Stream was empty.  No point in parsing.
                return null;
            }
            forecastJsonStr = buffer.toString();
        } catch (IOException e) {
            Log.e("PlaceholderFragment", "Error ", e);
            // If the code didn't successfully get the weather data, there's no point in attemping
            // to parse it.
            return null;
        } finally{
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("PlaceholderFragment", "Error closing stream", e);
                }
            }
        }

        return forecastJsonStr;
    }

*/





}
