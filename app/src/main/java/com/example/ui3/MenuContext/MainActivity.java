package com.example.ui3.MenuContext;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
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
        //textView=(TextView) findViewById(R.id.text_select);
        List<Item> itemList = new ArrayList<>();
        Item itemLion = new Item(R.drawable.an, "One");
        Item itemTiger = new Item(R.drawable.an, "Two");
        Item itemMonkey = new Item(R.drawable.an, "Three");
        Item itemDog = new Item(R.drawable.an, "Four");
        Item itemCat = new Item(R.drawable.an, "Five");
        itemList.add(itemLion);
        itemList.add(itemTiger);
        itemList.add(itemMonkey);
        itemList.add(itemDog);
        itemList.add(itemCat);
        com.example.ui3.listView.ItemAdapter itemAdapter = new ItemAdapter(com.example.ui3.MenuContext.MainActivity.this, R.layout.item, itemList);
        listView.setAdapter(itemAdapter);
        // listView设置多选模式
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            int num = 0;

            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
                if (b == true) {
                    itemList.get(i).setBo(true);

                    //实时刷新
                    itemAdapter.notifyDataSetChanged();
                    num++;
                } else {
                    itemList.get(i).setBo(false);
                    //实时刷新
                    itemAdapter.notifyDataSetChanged();
                    num--;
                }
                actionMode.setTitle("  " + num + " Selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                MenuInflater inflater = actionMode.getMenuInflater();
                inflater.inflate(R.menu.menu_actionmode, menu);
                num = 0;
                itemAdapter.notifyDataSetChanged();
                return true;
            }

            public void refresh() {
                for (int i = 0; i < 5; i++) {
                    itemList.get(i).setBo(false);
                }
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                itemAdapter.notifyDataSetChanged();

                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

                    if(item.getItemId()==R.id.menu_all){
                        //全选
                        num = 0;
                        refresh();
                        itemAdapter.notifyDataSetChanged();
                        mode.finish(); // 偷了个懒，每个菜单按钮都设置返回，结束多选模式
                        return true;
                    }else if(item.getItemId()==R.id.menu_delete){
                    itemAdapter.notifyDataSetChanged();
                    num = 0;
                    refresh();
                    mode.finish();// 偷了个懒，每个菜单按钮都设置返回，结束多选模式
                    return true;
                }else {
                        //删除
                        refresh();
                        itemAdapter.notifyDataSetChanged();
                        num = 0;
                        return false;
                    }

            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
                itemAdapter.notifyDataSetChanged();

            }
        });
       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item item=itemList.get(i);
                Toast.makeText(com.example.ui3.MenuContext.MainActivity.this,item.getName(),Toast.LENGTH_LONG).show();
                *//*listView.setBackgroundColor(Color.GREEN);*//*
                //textView.setText(item.getName());
                //textView.setTextSize(35);
            }
        });
        registerForContextMenu(listView);
    }*/

   /* @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.menu_main,menu);
        menu.setHeaderIcon(R.drawable.gz);
        super.onCreateContextMenu(menu, v, menuInfo);
    }*/
    }
}
