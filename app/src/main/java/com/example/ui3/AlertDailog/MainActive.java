package com.example.ui3.AlertDailog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ui3.R;

public class MainActive extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dailog_main);
       /*showDailog();*/
        init();
    }
     private void init(){
        findViewById(R.id.dialog_btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               showDailog();
                Toast.makeText(MainActive.this,"点击了登录",Toast.LENGTH_LONG);

            }
        });
     }
     private void showDailog(){
         AlertDialog.Builder builder = new AlertDialog.Builder(this);
         builder.setTitle("登录页面");
         LayoutInflater inflater = LayoutInflater.from(this);
         View view = inflater.inflate(R.layout.login, null);
         builder.setView(view);
         builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                 dialogInterface.dismiss();
             }
         });
         builder.setNegativeButton("Sign in", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialogInterface, int i) {
                 dialogInterface.dismiss();
                 Toast.makeText(MainActive.this,"succeed",Toast.LENGTH_LONG);
             }
         });
         AlertDialog alertDialog=builder.create();
         alertDialog.show();
     }
}
