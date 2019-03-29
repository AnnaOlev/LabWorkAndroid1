package com.example.androidlab1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class ElementsList extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_elements_list);

        ListView listView = findViewById(R.id.listview);
        ItemAdapter adapter = new ItemAdapter(this);
        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed(){
        finish();
    }
}