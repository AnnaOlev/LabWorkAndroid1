package com.example.androidlab1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;


import java.util.ArrayList;
import java.util.List;

public class ElementsList extends AppCompatActivity {

    private List<Item> mItemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_elements_list);

        for (int i = 1; i <= 1000000; i++)
            mItemList.add(new Item(i));
        ListView listView = findViewById(R.id.listview);
        ItemAdapter adapter = new ItemAdapter(this, mItemList);
        listView.setAdapter(adapter);
    }
    
    @Override
    public void onBackPressed(){
        finish();
    }
}
