package com.example.turbo.expandablelistviewdemo.WebRequests;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.turbo.expandablelistviewdemo.Constants.AppControler;
import com.example.turbo.expandablelistviewdemo.Activities.MainActivity;

/**
 * Created by turbo on 2016/7/26.
 */
public class MenuRequest{

    private Context context;
    private String url;
    private StringRequest stringRequest;

    public MenuRequest(Context context, String url) {
        this.context = context;
        this.url = url;
    }

    public void sendMenuRequest()
    {
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(context, "success", Toast.LENGTH_SHORT).show();
                if(url.equals("https://www.google.ca"))
                {
                    ((MainActivity)context).RefreshMainMenu("Main", -1);
                }
                else if(url.equals("https://www.baidu.com"))
                {
                    ((MainActivity)context).RefreshSubMenu("Sub", -1);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue = AppControler.getRequestQueue();
        requestQueue.add(stringRequest);
    }


}
