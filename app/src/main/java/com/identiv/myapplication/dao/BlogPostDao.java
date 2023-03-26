package com.identiv.myapplication.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.identiv.myapplication.entity.BlogPost;

import java.util.List;

/**
 * Created by lukegjpotter on 25/11/2017.
 */
@Dao
public interface BlogPostDao {

    @Query("SELECT * FROM blogpost")
    LiveData<List<BlogPost>> getAllBlogPosts();

    @Query("SELECT * FROM blogpost WHERE id = :id LIMIT 1")
    LiveData<List<BlogPost>> findBlogPostById(long id);

    @Query("SELECT * FROM blogpost WHERE title LIKE :title LIMIT 1")
    LiveData<List<BlogPost>> findBlodPostByTitle(String title);

    @Query("SELECT COUNT(*) FROM blogpost")
    int rowCount();

    @Insert
    void insertBlogPosts(BlogPost... blogPosts);

    @Update
    void updateBlogPosts(BlogPost... blogPosts);

    @Delete
    void deleteBlogPosts(BlogPost... blogPosts);
}
