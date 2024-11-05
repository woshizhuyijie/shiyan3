package com.example.ui3.MenuContext;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ui3.R;
import com.example.ui3.listView.Item;

import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(@NonNull Context context, int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Item item=getItem(position);
        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list,parent,false);
            ImageView imageView=convertView.findViewById(R.id.Item_image);
            TextView textView=convertView.findViewById(R.id.Item_name);
            imageView.setImageResource(item.getImageId());
            textView.setText(item.getName());
        }else {

        }

        int lightBlue = Color.parseColor("#33B5E5");
        int white=Color.parseColor("#FFFFFF");

        //如果被选中，那么改变选中颜色
        if(item.isBo() == true){
            parent.setBackgroundColor(lightBlue);
        } else {
            parent.setBackgroundColor(white);
        }
        return convertView;
    }

}
