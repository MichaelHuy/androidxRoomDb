package com.identiv.myapplication.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.identiv.myapplication.R;
import com.identiv.myapplication.databinding.ActivityAddBlogPostBinding;

public class AddBlogPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityAddBlogPostBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_add_blog_post);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
