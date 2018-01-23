package com.silicontechnologies.livedatasample.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.silicontechnologies.livedatasample.dao.UserDao;
import com.silicontechnologies.livedatasample.entities.User;

/**
 * Created by rajajawahar on 23/01/18.
 */

@Database(entities = { User.class }, version = 1) public abstract class AppDatabase
    extends RoomDatabase {

  abstract UserDao userDao();
}
