package com.example.ui3.MenuContext;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ui3.R;
import com.example.ui3.listView.Item;
import com.example.ui3.listView.ItemAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
   TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_select_main);
        listView = (ListView) findViewById(R.id.list_view);
        textView=(TextView) findViewById(R.id.text_select);
        List<Item> itemList=new ArrayList<>();
        Item itemLion=new Item(R.drawable.an,"One");
        Item itemTiger=new Item(R.drawable.an,"Two");
        Item itemMonkey=new Item(R.drawable.an,"Three");
        Item itemDog=new Item(R.drawable.an,"Four");
        Item itemCat=new Item(R.drawable.an,"Five");
        itemList.add(itemLion);
        itemList.add(itemTiger);
        itemList.add(itemMonkey);
        itemList.add(itemDog);
        itemList.add(itemCat);
        com.example.ui3.listView.ItemAdapter itemAdapter=new ItemAdapter(com.example.ui3.MenuContext.MainActivity.this,R.layout.item,itemList);
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item=itemList.get(i);
                Toast.makeText(com.example.ui3.MenuContext.MainActivity.this,item.getName(),Toast.LENGTH_LONG).show();
                /*listView.setBackgroundColor(Color.GREEN);*/
                textView.setText(item.getName());
                textView.setTextSize(35);
            }
        });
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        menu.setHeaderIcon(R.drawable.gz);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}
