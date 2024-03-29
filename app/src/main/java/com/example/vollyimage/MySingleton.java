package com.example.vollyimage;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static MySingleton minstance;
    private RequestQueue requestQueue;
    private static Context mcontext;
    private  MySingleton(Context context){
        mcontext=context;
        requestQueue=getRequestqueue();

    }
    public RequestQueue getRequestqueue(){
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(mcontext.getApplicationContext());

        }
        return requestQueue;
    }
    public static synchronized MySingleton getInstance(Context context){
        if(minstance==null){
            minstance=new MySingleton(context);
        }
        return minstance;
    }
    public void AddtoRequestqueue(Request request){
        requestQueue.add(request);

    }

}
