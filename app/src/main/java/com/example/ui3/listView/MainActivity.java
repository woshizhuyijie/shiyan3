package com.example.ui3.listView;

import android.os.Bundle;

import com.example.ui3.R;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        List<Item> itemList=new ArrayList<>();
        Item itemLion=new Item(R.drawable.lion,"Lion");
        Item itemTiger=new Item(R.drawable.tiger,"Tiger");
        Item itemMonkey=new Item(R.drawable.monkey,"Monkey");
        Item itemDog=new Item(R.drawable.dog,"Dog");
        Item itemCat=new Item(R.drawable.cat,"Cat");
        Item itemElephant=new Item(R.drawable.elephant,"Elephant");
        itemList.add(itemLion);
        itemList.add(itemTiger);
        itemList.add(itemMonkey);
        itemList.add(itemDog);
        itemList.add(itemCat);
        itemList.add(itemElephant);
        ItemAdapter itemAdapter=new ItemAdapter(MainActivity.this,R.layout.item,itemList);
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item=itemList.get(i);
                Toast.makeText(MainActivity.this,item.getName(),Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        /*getMenuInflater().inflate(R.menu.menu_main, menu);*/
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }
}