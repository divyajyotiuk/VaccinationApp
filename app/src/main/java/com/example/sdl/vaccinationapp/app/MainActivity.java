package com.example.sdl.vaccinationapp.app;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import com.example.sdl.vaccinationapp.Fragments.FragmentDone;
import com.example.sdl.vaccinationapp.Fragments.FragmentNearBy;
import com.example.sdl.vaccinationapp.Fragments.FragmentPending;
import com.example.sdl.vaccinationapp.R;
import com.example.sdl.vaccinationapp.adapter.recyclerAdapter;
import com.example.sdl.vaccinationapp.model.VaccineTimeTable;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();
        setUpBackdropMenu();
        setUpBottomNavigation();
        //    setUpRecyclerView();

    }


    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Vaccine Log");


    }


    private void setUpBottomNavigation() {
        BottomNavigationView bottomNavigation = (BottomNavigationView) findViewById(R.id.nav_container);

        bottomNavigation.setActivated(true);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.doneAll:
                        selectedFragment = FragmentDone.newInstance();
                        break;
                    case R.id.pending:
                        selectedFragment = FragmentPending.newInstance();
                        break;
                    case R.id.hospitals:
                        selectedFragment = FragmentNearBy.newInstance();
                        break;
                }
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.container, selectedFragment);
                transaction.commit();
                return true;
            }
        });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, FragmentPending.newInstance());
        transaction.commit();

    }

    private void setUpBackdropMenu() {
        BackdropMenuFragment drawerFragment = (BackdropMenuFragment) getSupportFragmentManager().findFragmentById(R.id.backdrop_menu_fragment);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragment.setUpBackdropMenu(R.id.backdrop_menu_fragment, drawerLayout, toolbar);
    }
}
 /*   private void setUpRecyclerView()
    {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerAdapter adapter = new recyclerAdapter(this, VaccineTimeTable.getdata());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}*/
