package com.example.recyclerviewsample;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewsample.recyclerview.ViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    ViewAdapter viewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Person> allPerson = new ArrayList<>();
        allPerson.add(new Person("Jolou", "The above solution uses media store and stores the image in the users main image folder making it viewable through the gallery/photo viewer.", R.drawable.ic_launcher_foreground));
        allPerson.add(new Person("Jericho", "I am jericho ahhaha", R.drawable.ic_launcher_background));
        allPerson.add(new Person("Jolou", "The above solution uses media store and stores the image in the users main image folder making it viewable through the gallery/photo viewer.", R.drawable.ic_launcher_foreground));
        allPerson.add(new Person("Jericho", "I am jericho ahhaha", R.drawable.ic_launcher_background));
        allPerson.add(new Person("Jolou", "The above solution uses media store and stores the image in the users main image folder making it viewable through the gallery/photo viewer.", R.drawable.ic_launcher_foreground));
        allPerson.add(new Person("Jericho", "I am jericho ahhaha", R.drawable.ic_launcher_background));
        allPerson.add(new Person("Jolou", "The above solution uses media store and stores the image in the users main image folder making it viewable through the gallery/photo viewer.", R.drawable.ic_launcher_foreground));
        allPerson.add(new Person("Jericho", "I am jericho ahhaha", R.drawable.ic_launcher_background));
        allPerson.add(new Person("Jolou", "The above solution uses media store and stores the image in the users main image folder making it viewable through the gallery/photo viewer.", R.drawable.ic_launcher_foreground));
        allPerson.add(new Person("Jericho", "I am jericho ahhaha", R.drawable.ic_launcher_background));
        allPerson.add(new Person("Jolou", "The above solution uses media store and stores the image in the users main image folder making it viewable through the gallery/photo viewer.", R.drawable.ic_launcher_foreground));
        allPerson.add(new Person("Jericho", "I am jericho ahhaha", R.drawable.ic_launcher_background));
        allPerson.add(new Person("Jolou", "The above solution uses media store and stores the image in the users main image folder making it viewable through the gallery/photo viewer.", R.drawable.ic_launcher_foreground));
        allPerson.add(new Person("Jericho", "I am jericho ahhaha", R.drawable.ic_launcher_background));
        allPerson.add(new Person("Jolou", "The above solution uses media store and stores the image in the users main image folder making it viewable through the gallery/photo viewer.", R.drawable.ic_launcher_foreground));
        allPerson.add(new Person("Jericho", "I am jericho ahhaha", R.drawable.ic_launcher_background));
        allPerson.add(new Person("Jolou", "The above solution uses media store and stores the image in the users main image folder making it viewable through the gallery/photo viewer.", R.drawable.ic_launcher_foreground));
        allPerson.add(new Person("Jericho", "I am jericho ahhaha", R.drawable.ic_launcher_background));

        viewAdapter = new ViewAdapter();
        recyclerView = findViewById(R.id.recyclerview);
        viewAdapter.setPersonList(allPerson);
        recyclerView.setAdapter(viewAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}