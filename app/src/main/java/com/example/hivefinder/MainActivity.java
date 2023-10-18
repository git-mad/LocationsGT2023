package com.example.hivefinder;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.core.view.WindowCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.hivefinder.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    // Declare them here but don't initialize yet
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        // Initialize them here
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);

        Set<Integer> topLevelDestinations = new HashSet<>();
        topLevelDestinations.add(R.id.FirstFragment);
        topLevelDestinations.add(R.id.SecondFragment);
        topLevelDestinations.add(R.id.Culc3Fragment);
        topLevelDestinations.add(R.id.Culc4Fragment);
        topLevelDestinations.add(R.id.Culc5Fragment);
        // Set up the AppBarConfiguration
        appBarConfiguration = new AppBarConfiguration.Builder(topLevelDestinations)
                .setDrawerLayout(drawerLayout)
                .build();

        // Connect everything together
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
            /*switch (itemId) {
                case R.id.culc1:
                    navController.navigate(R.id.FirstFragment);
                    break;
                case R.id.culc2:
                    navController.navigate(R.id.SecondFragment);
                    break;
            }*/
            if(itemId == R.id.culc2) {
                navController.navigate(R.id.SecondFragment);
            } else if (itemId == R.id.culc1){
                navController.navigate(R.id.FirstFragment);
            } else if (itemId == R.id.culc3){
                navController.navigate(R.id.Culc3Fragment);
            } else if (itemId == R.id.culc4) {
                navController.navigate(R.id.Culc4Fragment);
            } else if (itemId == R.id.culc5) {
                navController.navigate(R.id.Culc5Fragment);
            }

            // Close the drawer after selecting an item
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}