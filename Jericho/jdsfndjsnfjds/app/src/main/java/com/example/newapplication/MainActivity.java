package com.example.newapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bt;
    ListView lv;
    ArrayAdapter<String> arrayAdapter;
    String[] searchList = {"Aloha","Hello","Carola","Arola","Rola"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.list_customtext,searchList);
        lv.setAdapter(arrayAdapter);

        bt = findViewById(R.id.bottomNavigation);
        bt.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();

                if(itemId == R.id.home){
                    Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                    replaceFragment(new HomeFragment());
                }else if(itemId == R.id.person){
                    Toast.makeText(getApplicationContext(), "User", Toast.LENGTH_SHORT).show();
                    replaceFragment(new PersonFragment());
                }else if(itemId == R.id.add){
                    Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_SHORT).show();
                    replaceFragment(new SettingsFragment());
                }else if(itemId == R.id.notifications){
                    Toast.makeText(getApplicationContext(), "Notifications", Toast.LENGTH_SHORT).show();
                    replaceFragment(new NotificationsFragment());
                }else if(itemId == R.id.objectives){
                    replaceFragment(new AssignmentsFragment());
                    Toast.makeText(getApplicationContext(), "Objectives", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }

    public void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame, fragment, null).commit();
    }
    @Override
    public  boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.actionbar_menu,menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search here");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}