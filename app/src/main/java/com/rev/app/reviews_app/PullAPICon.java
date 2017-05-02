package com.rev.app.reviews_app;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
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

import static com.android.volley.VolleyLog.TAG;


public class PullAPICon extends AsyncTask<Void, Void, String> {

    private Exception exception;

    protected void onPreExecute() {
       // progressBar.setVisibility(View.VISIBLE);
       // responseView.setText("");
    }

    protected String doInBackground(Void... urls) {
       // String email = emailText.getText().toString();
        // Do some validation here

        try {
            URL url = new URL("http://api.walmartlabs.com/v1/reviews/"+ 123456789 +"?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq");
//            String url1 = "http://api.walmartlabs.com/v1/reviews/"+ Integer.parseInt(id[0]) +"?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }
    }

    protected void onPostExecute(String response) {
        if(response == null) {
            response = "THERE WAS AN ERROR";
        }
      //  progressBar.setVisibility(View.GONE);
        Log.i("INFO", response);
      //  responseView.setText(response);
    }
}

