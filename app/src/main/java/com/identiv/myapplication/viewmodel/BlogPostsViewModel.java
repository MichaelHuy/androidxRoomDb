package com.identiv.myapplication.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.identiv.myapplication.database.BlogPostDatabase;
import com.identiv.myapplication.entity.BlogPost;

import java.util.List;

public class BlogPostsViewModel extends AndroidViewModel {

    private final LiveData<List<BlogPost>> blogPosts;

    public BlogPostsViewModel(@NonNull Application application) {
        super(application);

        blogPosts = BlogPostDatabase.getInstance(getApplication()).blogPostDao().getAllBlogPosts();
    }

    public LiveData<List<BlogPost>> getBlogPosts() {
        return blogPosts;
    }
}
