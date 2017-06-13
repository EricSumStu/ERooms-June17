package com.example.eowemcn.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class initialui extends Activity {

    public Button textview1;

        public void init(){
            textview1 = (Button)findViewById(R.id.textview1);
            textview1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent newscreen = new Intent(initialui.this,list.class);

                    startActivity(newscreen);

                }
            });


        }

    @Override
    protected void onCreate(Bundle savedInstancesState) {
        super.onCreate(savedInstancesState);
        setContentView(R.layout.initialui);
        Typeface myTypeFace1 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView1 = (TextView) findViewById(R.id.textview1);
        myTextView1.setTypeface(myTypeFace1);
        Typeface myTypeFace2 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView2 = (TextView) findViewById(R.id.textview2);
        myTextView2.setTypeface(myTypeFace2);
        Typeface myTypeFace3 = Typeface.createFromAsset(getAssets(), "abc.ttf");
        TextView myTextView3 = (TextView) findViewById(R.id.textview3);
        myTextView3.setTypeface(myTypeFace3);

        ImageView myImageView = (ImageView) findViewById(R.id.imageView1);
        myImageView.setImageResource(R.drawable.logo);

        init();

    }

}