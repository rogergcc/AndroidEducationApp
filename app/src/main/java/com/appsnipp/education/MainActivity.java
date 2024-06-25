package com.appsnipp.education;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.appsnipp.education.databinding.ActivityMainBinding;
import com.appsnipp.education.ui.utils.AppLogger;
import com.appsnipp.education.ui.utils.helpers.BottomNavigationBehavior;
import com.appsnipp.education.ui.utils.helpers.DarkModePrefManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DarkModePrefManager darkModePrefManager;
    ActivityMainBinding binding;
    NavHostFragment navHostFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());

        View view = binding.getRoot();
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(view);
        setAppTheme();
        setSupportActionBar(binding.appBarMain.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.appBarMain.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.navView.setNavigationItemSelectedListener(this);


        setupNavigation();

    }

    private void setAppTheme() {
        darkModePrefManager = new DarkModePrefManager(this);
        boolean isDarkModeEnabled = darkModePrefManager.isNightMode();
        if (isDarkModeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

    }

    @Nullable
    @Override
    public View onCreateView(@Nullable View parent, @NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);

    }

    private void setupNavigation() {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) binding.appBarMain.bottomNavigationView.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());

        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        if (navHostFragment != null) {
            NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.getNavController());
        }
    }


    @Override
    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_dark_mode) {
            //code for setting dark mode
            //true for dark mode, false for day mode, currently toggling on each click

//            darkModePrefManager.setDarkMode(!darkModePrefManager.isNightMode());
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//            startActivity(new Intent(MainActivity.this, MainActivity.class));
//            finish();
//            overridePendingTransition(0, 0);

            toggleDarkMode();
        }

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        binding.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    // Método para cambiar el estado del modo oscuro
    private void toggleDarkMode() {
        AppLogger.d("toggleDarkMode init");
        boolean isDarkModeEnabled = darkModePrefManager.isNightMode();
        darkModePrefManager.setDarkMode(!isDarkModeEnabled);
//        recreate();

        startActivity(new Intent(MainActivity.this, MainActivity.class));
        finish();
        overridePendingTransition(0, 0);

    }
}
