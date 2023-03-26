package com.identiv.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.identiv.myapplication.database.BlogPostDatabase;
import com.identiv.myapplication.R;
import com.identiv.myapplication.database.util.DatabaseInitializer;
import com.identiv.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Populate the Database.
        DatabaseInitializer.populateAsync(BlogPostDatabase.getInstance(getApplicationContext()));

        // Set the layout.
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);

        // When the Floating Action Button is clicked start the Add Blog Post Activity.
        binding.fab.setOnClickListener((view) ->
                startActivity(new Intent(MainActivity.this, AddBlogPostActivity.class)));
    }
}
