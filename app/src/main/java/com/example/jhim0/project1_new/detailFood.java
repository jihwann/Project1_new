package com.example.jhim0.project1_new;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by USER on 2017-10-03.
 */

public class detailFood extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);

        Intent intentimage = getIntent();
        int image = intentimage.getIntExtra("image", 0);
        ImageView image1 = (ImageView)findViewById(R.id.Foodimage1);
        image1.setImageResource(image);


        Intent intentname = getIntent();
        String Textname = intentname.getStringExtra("name");
        TextView tv1 = (TextView)findViewById(R.id.FoodText1);
        tv1.setText(Textname);

        Intent intentcost = getIntent();
        String Textcost = intentcost.getStringExtra("cost");
        TextView tv2 = (TextView)findViewById(R.id.FoodText2);
        tv2.setText(Textcost);

        Intent intentlast = getIntent();
        String Textlast = intentlast.getStringExtra("taste");
        TextView tv3 = (TextView)findViewById(R.id.FoodText3);
        tv3.setText(Textlast);
    }
}