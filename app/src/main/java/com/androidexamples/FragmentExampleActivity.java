package com.androidexamples;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FragmentExampleActivity extends AppCompatActivity {
    private FragmentOne fragmentOne;
    private  FragmentSecond fragmentTwo;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_example);

        fragmentOne  = new FragmentOne();
        fragmentTwo  = new FragmentSecond();


        getSupportFragmentManager().beginTransaction().add(R.id.fragment_one,fragmentOne,"ONE")
                .commitNowAllowingStateLoss();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_second,fragmentTwo,"TWO")
                .commitNowAllowingStateLoss();

    }
}
