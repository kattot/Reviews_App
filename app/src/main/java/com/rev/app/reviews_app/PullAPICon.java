package com.rev.app.reviews_app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



public class PullAPICon {
    String builder;
    HttpURLConnection conn;
    BufferedReader read;
    StringBuffer sb;

    public PullAPICon()
    {
        String builder = "";
        HttpURLConnection conn = null;
        BufferedReader read = null;
        StringBuffer sb = new StringBuffer();

    }

    public String pullRequest(){
        try

        {
            URL url = new URL("http://api.walmartlabs.com/v1/reviews/12417832?format=json&apiKey=x8cww2sgbv3ekax7d6n7tanq");

            conn = (HttpURLConnection) url.openConnection();
            // conn.setRequestMethod("GET");
            conn.connect();

            InputStream IS = conn.getInputStream();
            read = new BufferedReader(new InputStreamReader(IS));

            while((read.readLine()) != null){
                sb.append(builder);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
            return builder = "Wrong";

        }
        finally {
            if (conn != null)
                conn.disconnect();
            if (read != null)
                try {
                    read.close();

                }catch (IOException e){
                    e.printStackTrace();
                }
        }

        return builder;


    }

}

