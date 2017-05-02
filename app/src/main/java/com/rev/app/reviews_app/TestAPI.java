package com.rev.app.reviews_app;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by katto on 4/30/2017.
 */

public class TestAPI  {

    Context context;
    ArrayList<Fetched_Data> arrayList = new ArrayList<>();
    ArrayAdapter<Fetched_Data> adapter = new ArrayAdapter<Fetched_Data>(context,R.layout.activity_list_view_products_reviews,arrayList);
    String json_url = "http://api.walmartlabs.com/v1/reviews/21805451?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq";


    public TestAPI (Context context){
        this.context = context;
    }


    public ArrayList<Fetched_Data> getList(){

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, (String)json_url, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                        JSONArray i = null;
                        try {

                            i = response.getJSONArray(Integer.parseInt("reviews"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        int count = 0;
                        while (count<i.length()){
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);
                                Fetched_Data fetched_data = new Fetched_Data(jsonObject.getString("name"),
                                                                             jsonObject.getString("title"),
                                                                             jsonObject.getString("reviewer"),
                                                                             jsonObject.getString("reviewText"),
                                                                             jsonObject.getString("upVotes"),
                                                                             jsonObject.getString("downVotes"),jsonObject.getString(""));

                                arrayList.add(fetched_data);
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
                Toast.makeText(context, "Error....",Toast.LENGTH_SHORT).show();

            }
        }


        );

        MySingleton.getmInstance(context).addToRequestqueue(jsonArrayRequest);

        return arrayList;
    }


}
