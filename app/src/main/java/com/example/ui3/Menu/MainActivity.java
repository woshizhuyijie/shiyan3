package com.example.ui3.Menu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ui3.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        TextView textView = findViewById(R.id.text_view);
        int id = item.getItemId();
        if (id == R.id.item_pt) {
            Toast.makeText(this, "点击了普通菜单项", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.colour_blue) {
            textView.setTextColor(Color.BLUE);
        }
        if (id == R.id.colour_green) {
            textView.setTextColor(Color.GREEN);
        }
        if (id == R.id.colour_red) {
            textView.setTextColor(Color.RED);
        }
        if (id == R.id.colour_yellow) {
            textView.setTextColor(Color.YELLOW);
        }
        if(id==R.id.font_size_10sp){
            textView.setTextSize(10);
        }
        if(id==R.id.font_size_16sp){
            textView.setTextSize(16);
        }
        if(id==R.id.font_size_20sp){
            textView.setTextSize(20);
        }
        if(id==R.id.colour_bl){
            textView.setTextColor(Color.BLACK);
        }
        return super.onOptionsItemSelected(item);
    }
}