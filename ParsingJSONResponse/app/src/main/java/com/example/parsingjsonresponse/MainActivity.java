package com.example.parsingjsonresponse;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arrNames = new ArrayList<>();

        listView = findViewById(R.id.listView);

//        String url= "https://jsonplaceholder.typicode.com/todos/1/users"; //Get



        RequestQueue requestQueue;
        requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/todos/1/users", null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {

                try {
//                    Log.d("myApp","The response is "+ response.getString("title"));
                    for (int i = 0; i<response.length(); i++){
                        JSONObject objResult = response.getJSONObject(i);
                        String name = objResult.getString("name");

                        arrNames.add(name);

                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, arrNames);
                        listView.setAdapter(arrayAdapter);


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("myapp", "Something went wrong");
            }
        });

        requestQueue.add(jsonArrayRequest);
    }
}