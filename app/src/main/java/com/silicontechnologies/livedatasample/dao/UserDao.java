package com.silicontechnologies.livedatasample.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by rajajawahar on 23/01/18.
 */

@Dao public interface UserDao {

  @Insert(onConflict = REPLACE) void save(User user);

  @Query("SELECT * from user WHERE id = :userId") LiveData<User> load(String userId);

  @Delete void delete(User user);
}
