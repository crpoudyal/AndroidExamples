package com.androidexamples;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class NavActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navView;
    public DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);

//        finding View
        toolbar = findViewById(R.id.toolbar);
        navView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.drawer);

//        setting Toolbar
        setSupportActionBar(toolbar);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.close, R.string.open);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();


        getSupportFragmentManager().beginTransaction().replace(R.id.container, new WelcomeFrag(),
                "Welcome Fragment").commitAllowingStateLoss();

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.widgets:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new WidgetFrag(),
                                "Widget Fragment").commitAllowingStateLoss();
                        break;

                    case R.id.layouts:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new LayoutFrag(),
                                "Layout Fragment").commitAllowingStateLoss();
                        break;

                    case R.id.form:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new FormFrag(),
                                "Form Fragment").commitAllowingStateLoss();
                        break;

                    case R.id.intent:
                        Intent passingData = new Intent(NavActivity.this, UserFormActivity.class);
                        startActivity(passingData);
                        break;
                    case R.id.menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MenuListFrag(),
                                "Menu list Fragment").commitAllowingStateLoss();
                        break;
                    case R.id.dialog:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new DialogListFrag(),
                                "Dialog list Fragment").commitAllowingStateLoss();
                        break;
                    case R.id.frag:
                        Intent fragment = new Intent(NavActivity.this, FragmentExampleActivity.class);
                        startActivity(fragment);
                        break;
                    case R.id.listview:
                        Intent listview = new Intent(NavActivity.this, ListExampleActivity.class);
                        startActivity(listview);
                    case R.id.gridview:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,
                                new GridViewExampleFrag(), "Gridview Fragment").commitAllowingStateLoss();
                        break;
                    case R.id.recyclerview:
                        Intent recycler = new Intent(NavActivity.this, RecyclerActivity.class);
                        startActivity(recycler);
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });

    }
}
