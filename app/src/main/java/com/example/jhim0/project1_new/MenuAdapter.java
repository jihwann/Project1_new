package com.example.jhim0.project1_new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jhim0.project1_new.R;

import java.util.ArrayList;

public class MenuAdapter extends BaseAdapter {

    private Context mContext;
    private int mResource;
    private ArrayList<MenuItem> mItems = new ArrayList<MenuItem>();

    public MenuAdapter(Context context, int resource, ArrayList<MenuItem> Menus) {
        mContext = context;
        mResource = resource;
        mItems = Menus;
    }


    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(mResource, parent, false);
        }

        ImageView Menuimages = (ImageView) view.findViewById(R.id.MenuImage);
        Menuimages.setImageResource(mItems.get(i).image);

        TextView Menuname = (TextView) view.findViewById(R.id.MenuName);
        Menuname.setText(mItems.get(i).Name);

        TextView Menucost = (TextView) view.findViewById(R.id.Menucost);
        Menucost.setText(mItems.get(i).cost);

        return view;

    }
}

class MenuItem{
    int image;
    String Name;
    String cost;

    MenuItem(int mimage, String mName, String mcost)
    {
        image = mimage;
        Name = mName ;
        cost = mcost;
    }

}
