package com.androidexamples;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerListDataAdapter mAdapter;
    public ArrayList<ListData> listItems;
    private RecyclerListDataAdapter adapter;
    RecyclerView rvListData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_layout);

        rvListData = findViewById(R.id.rv_list_data);

        listItems = new ArrayList<>();
        listItems.add(new ListData("Android1","This is description for title"));
        listItems.add(new ListData("Android2","This is description for title"));
        listItems.add(new ListData("Android3","This is description for title"));
        listItems.add(new ListData("Android4","This is description for title"));
        listItems.add(new ListData("Android5","This is description for title"));
        listItems.add(new ListData("Android6","This is description for title"));


        mAdapter = new RecyclerListDataAdapter(this,listItems);
        rvListData.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false));
        rvListData.setAdapter(mAdapter);
    }
}
