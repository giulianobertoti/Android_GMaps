package com.example.giuliano.googlemaps;

import android.os.StrictMode;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.io.InputStreamReader;
import java.util.LinkedList;
import org.json.JSONObject;
/**
 * Created by Giuliano on 01/10/2015.
 */
public class Connection {

    public List<Marker> getData() throws JSONException {


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        final StringBuilder result = new StringBuilder();

        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL("https://api.myjson.com/bins/23k9u");

            urlConnection = (HttpURLConnection) url
                    .openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader isw = new InputStreamReader(in);



            int data = isw.read();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                result.append(current);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                urlConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println(result);

        List<Marker> finalResult = generateJSON(new JSONArray(result.toString()));

        return finalResult;
    }


    public List<Marker> generateJSON(JSONArray json){

        List<Marker> found = new LinkedList<Marker>();

        try {


            for (int i = 0; i < json.length(); i++) {
                JSONObject obj = json.getJSONObject(i);
                found.add(new Marker(obj.getJSONObject("geometry").getJSONArray("coordinates").getDouble(0),obj.getJSONObject("geometry").getJSONArray("coordinates").getDouble(1), obj.getJSONObject("properties").getString("name")));
            }

        } catch (JSONException e) {
            // handle exception
        }

        return found;

    }

}