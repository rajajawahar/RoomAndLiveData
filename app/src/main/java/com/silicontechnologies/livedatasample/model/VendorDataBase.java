package com.silicontechnologies.livedatasample.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.silicontechnologies.livedatasample.model.dao.UserDao;
import com.silicontechnologies.livedatasample.model.entities.User;

/**
 * Created by rajajawahar on 23/01/18.
 */

@Database(entities = { User.class }, version = 1) public abstract class VendorDataBase
    extends RoomDatabase {

  abstract UserDao userDao();
}
