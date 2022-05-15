package com.androidexamples;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class LayoutFrag extends Fragment {

    Button linear, relative, constraint;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_list, container, false);

        linear = view.findViewById(R.id.linear);
        relative = view.findViewById(R.id.relative);
        constraint = view.findViewById(R.id.constraint);

        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutFrag frag = new LayoutFrag();
                FragmentTransaction ft = getFragmentManager().beginTransaction()
                        .replace(R.id.container, new LinerLayoutFrag());
                ft.commit();
            }
        });

        relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutFrag frag = new LayoutFrag();
                FragmentTransaction ft = getFragmentManager().beginTransaction()
                        .replace(R.id.container, new RelativeLayoutFrag());
                ft.commit();
            }
        });

        constraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutFrag frag = new LayoutFrag();
                FragmentTransaction ft = getFragmentManager().beginTransaction()
                        .replace(R.id.container, new ConstraintLayoutFrag());
                ft.commit();
            }
        });
        return view;
    }
}





