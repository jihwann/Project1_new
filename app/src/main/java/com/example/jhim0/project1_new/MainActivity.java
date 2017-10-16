package com.example.jhim0.project1_new;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    static MenuAdapter Menus;
    ArrayList<MenuItem> Item = new ArrayList<MenuItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String Food1 = getResources().getString(R.string.coldNoodles);
        String Food2 = getResources().getString(R.string.naengmyeon);
        String Food3 = getResources().getString(R.string.stew);
        String Food4 = getResources().getString(R.string.gimbap);
        String Cost1 = getResources().getString(R.string.coldNoodlescost);
        String Cost2 = getResources().getString(R.string.naengmyeoncost);
        String Cost3 = getResources().getString(R.string.stewcost);
        String Cost4 = getResources().getString(R.string.gimbapcost);

        Item.add(new MenuItem(R.drawable.coldnoodles, Food1, Cost1));
        Item.add(new MenuItem(R.drawable.naengmyeon, Food2, Cost2));
        Item.add(new MenuItem(R.drawable.stew, Food3,Cost3));
        Item.add(new MenuItem(R.drawable.gimbap, Food4, Cost4));

        Menus = new MenuAdapter(this, R.layout.list, Item);

        ListView Views = (ListView)findViewById(R.id.listViews);
        Views.setAdapter(Menus);

        Views.setDivider(new ColorDrawable(Color.GRAY));
        Views.setDividerHeight(3);

        //Clicked ListView

        Views.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long ld) {
                ListView list1 = (ListView) adapterView;


                Intent intents = new Intent(getApplicationContext(), detailFood.class);

                intents.putExtra("image", Item.get(i).image);
                intents.putExtra("name", Item.get(i).Name);
                intents.putExtra("cost", Item.get(i).cost);

                if(i==0)
                {
                    String taste1 = getResources().getString(R.string.p1);
                    intents.putExtra("taste", taste1);
                }
                else if(i==1)
                {
                    String taste2 = "평점:4.0";
                    intents.putExtra("taste", taste2);
                }
                else if(i==2)
                {
                    String taste3 = "평점:4.5";
                    intents.putExtra("taste", taste3);
                }
                else
                {
                    String taste4 = "평점:3.5";
                    intents.putExtra("taste", taste4);
                }

                startActivity(intents);
            }
        });




        TextView main = (TextView)findViewById(R.id.mainTextView);
        main.setText(R.string.haksic);

        TextView add1 = (TextView)findViewById(R.id.addTextView1);
        add1.setText(R.string.text1);
        add1.setPadding(10,0,0,0);
        add1.setTextSize(18);

        TextView add2 = (TextView)findViewById(R.id.addTextView2);
        add2.setText(R.string.text2);
        add2.setPadding(10,0,0,0);
        add2.setTextSize(17);
        add2.setTextColor(Color.MAGENTA);

        TextView add3 = (TextView)findViewById(R.id.addTextView3);
        add3.setTextSize(19);
        add3.setText(R.string.text3);
        add3.setPadding(10,0,0,0);

        TextView menutextView = (TextView)findViewById(R.id.MenuTextView3);
        menutextView.setTextSize(15);
        menutextView.setText(R.string.menu);

        ImageButton Phone = (ImageButton)findViewById(R.id.Phonebutton);

    }

    public void Phoneaction(View v) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:02-760-4499"));
        startActivity(intent);
    }
}
