package com.example.vollyimage;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=(Button)findViewById(R.id.button);
        final ImageView image=(ImageView)findViewById(R.id.imageView);
        final String myurl="https://developer.android.com/";
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageRequest imageRequest=new ImageRequest(myurl, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                  image.setImageBitmap(response);
                    }
                }, 0, 0, null, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("Error","Error"+error);
                    }
                }
            );
                MySingleton.getInstance(MainActivity.this).AddtoRequestqueue(imageRequest);
        }
    });
    }
}
