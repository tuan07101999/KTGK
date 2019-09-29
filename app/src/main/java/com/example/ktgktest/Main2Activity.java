package com.example.ktgktest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    Spinner spin;
    EditText ND22;
    Button Mo;
    Button Back;
    EditText ok;

    ArrayList<String> arrayList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        spin = (Spinner) findViewById(R.id.spinnerLuu);
        ND22 = (EditText) findViewById(R.id.editTextND2);
        ok = (EditText) findViewById(R.id.editTextOK);
        Mo = (Button) findViewById(R.id.buttonMo);
        Back = (Button) findViewById(R.id.buttonBack);
        arrayList = (ArrayList<String>) getIntent().getSerializableExtra("Nhap");

        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,arrayList);
        spin.setAdapter(adapter);


        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    ok.setText(arrayList.get(i).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        Mo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a = ok.getText().toString();

                SharedPreferences SP = getApplicationContext().getSharedPreferences(a,0);
                ND22.setText(SP.getString("ND",null));

            }
        });
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
