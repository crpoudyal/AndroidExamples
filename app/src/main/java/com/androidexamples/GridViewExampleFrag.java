package com.androidexamples;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class GridViewExampleFrag extends Fragment {
    private GridView gridView;

    private  ListExampleAdapter mAdapter;
    public ArrayList<ListData> listItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.grid_example_layout, container, false);

        gridView = view.findViewById(R.id.grid_view);

        listItems = new ArrayList<>();
        listItems.add(new ListData("Android1","description"));
        listItems.add(new ListData("Android2","description"));
        listItems.add(new ListData("Android3","description"));
        listItems.add(new ListData("Android4","description"));
        listItems.add(new ListData("Android5","description"));
        listItems.add(new ListData("Android6","description"));


        mAdapter = new ListExampleAdapter(getActivity(),listItems);
        gridView.setAdapter(mAdapter);
        return view;
    }
}
