package com.example.turbo.expandablelistviewdemo.Constants;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by turbo on 2016/7/26.
 */
public class AppControler extends Application {

    private static volatile AppControler mInstance;
    private static RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        if(mInstance == null)
        {
            synchronized (AppControler.class)
            {
                if(mInstance == null)
                {
                    mInstance = new AppControler();
                }
            }
        }
        requestQueue = Volley.newRequestQueue(this);
    }

    public static AppControler getmInstance()
    {

        return mInstance;
    }

    public static RequestQueue getRequestQueue()
    {
        return requestQueue;
    }

}
