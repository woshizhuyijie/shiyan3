package com.example.ui3.MenuContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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

        View view= LayoutInflater.from(getContext()).inflate(R.layout.list,parent,false);
        ImageView imageView=view.findViewById(R.id.Item_image);
        TextView textView=view.findViewById(R.id.Item_name);
        imageView.setImageResource(item.getImageId());
        textView.setText(item.getName());
        return view;
    }
}
