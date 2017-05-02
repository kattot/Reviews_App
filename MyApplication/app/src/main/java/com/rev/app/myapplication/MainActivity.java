package com.rev.app.myapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;


public class MainActivity extends ListActivity {

    public class JSONParser extends ListActivity {

        /** Called when the activity is first created. */
        @SuppressWarnings("unchecked")
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            setListAdapter(new ArrayAdapter(
                    this,android.R.layout.simple_list_item_1,
                    this.populate()));
            Toast.makeText(getApplicationContext(),"Sussex",Toast.LENGTH_SHORT);
        }

        private ArrayList<String> populate() {
            ArrayList<String> items = new ArrayList<String>();

            try {
                URL url = new URL
                        ("http://ip.jsontest.com/?callback=showMyIP");
                HttpURLConnection urlConnection =
                        (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                // gets the server json data
                BufferedReader bufferedReader =
                        new BufferedReader(new InputStreamReader(
                                urlConnection.getInputStream()));


                String next;
                while ((next = bufferedReader.readLine()) != null){
                    JSONArray ja = new JSONArray(next);

                    for (int i = 0; i < ja.length(); i++) {
                        JSONObject jo = (JSONObject) ja.get(i);
                        items.add(jo.getString("ip"));
                    }
                }
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT);
                e.printStackTrace();
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT);
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (JSONException e) {
                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT);
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return items;
        }
    }





}


