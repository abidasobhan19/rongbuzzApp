package com.forbitbd.task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.forbitbd.task.ui.home.HomeFragment;
import com.forbitbd.task.ui.kids.KidsFragment;
import com.forbitbd.task.ui.livetv.TvFragment;
import com.forbitbd.task.ui.sports.SportsFragment;
import com.forbitbd.task.ui.upcoming.UpcomingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        loadFragment(new HomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home){
                    loadFragment(new HomeFragment());
                    return true;
                }else if (id == R.id.upcoming){
                    loadFragment(new UpcomingFragment());
                    return true;
                }else if (id == R.id.livetv) {
                    loadFragment(new TvFragment());
                    return true;
                }else if (id == R.id.sports){
                    loadFragment(new SportsFragment());
                    return true;
                }else if (id == R.id.kids) {
                    loadFragment(new KidsFragment());
                    return true;
                }
                return false;
            }
        });

    }
    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
}