package com.identiv.myapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.identiv.myapplication.dao.BlogPostDao;
import com.identiv.myapplication.entity.BlogPost;

@Database(entities = {BlogPost.class}, version = 1, exportSchema = false)
public abstract class BlogPostDatabase extends RoomDatabase {

    private static BlogPostDatabase INSTANCE;

    public static BlogPostDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    BlogPostDatabase.class,
                    "BlogPostsDatabase")
                    .build();
        }

        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    public abstract BlogPostDao blogPostDao();
}
