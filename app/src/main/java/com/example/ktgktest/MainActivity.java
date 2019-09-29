package com.example.ktgktest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText Nhap;
    EditText ND;
    Button reset;
    Button Luu;
    Button Xem;
    Button Thoat;


    SharedPreferences sharedPreferences;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Nhap = (EditText) findViewById(R.id.editTextNhap);
        ND = (EditText) findViewById(R.id.editTextND);
        reset = (Button) findViewById(R.id.buttonNhapMoi);
        Luu = (Button) findViewById(R.id.buttonLuu);
        Xem = (Button) findViewById(R.id.buttonXem);
        Thoat = (Button) findViewById(R.id.buttonThoat);
        arrayList = new ArrayList<String>();





        Xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("Nhap",arrayList);
                startActivity(intent);
                finish();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Nhap.setText("");
                ND.setText("");
            }
        });
        Luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                arrayList.add(Nhap.getText().toString());

                sharedPreferences = getApplicationContext().getSharedPreferences(Nhap.getText().toString(),0);

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString("ND",ND.getText().toString());

                editor.commit();

                Toast.makeText(MainActivity.this, "Lưu Thành Công", Toast.LENGTH_SHORT).show();


            }
        });



        final AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Thông Báo");
        dialog.setMessage("Bạn muốn Thoát không");
        dialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();

            }
        });
        dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog a = dialog.create();
                a.show();
            }
        });
    }
}
