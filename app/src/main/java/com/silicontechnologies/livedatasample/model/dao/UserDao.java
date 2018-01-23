package com.silicontechnologies.livedatasample.model.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import com.silicontechnologies.livedatasample.model.entities.User;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by rajajawahar on 23/01/18.
 */

@Dao public interface UserDao {

  @Insert(onConflict = REPLACE) void save(User user);

  @Query("SELECT * from user WHERE id = :userId") LiveData<User> load(String userId);
}
