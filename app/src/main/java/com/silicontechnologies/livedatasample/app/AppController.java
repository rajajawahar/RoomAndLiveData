package com.silicontechnologies.livedatasample.app;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import com.silicontechnologies.livedatasample.db.AppDatabase;

/**
 * Created by rajajawahar on 23/01/18.
 */

public class AppController extends Application {

  private static AppDatabase appDatabase;
  private static AppController instance;

  @Override public void onCreate() {
    super.onCreate();
    instance = this;
  }

  public static AppDatabase getAppDatabase() {
    if (appDatabase == null) {
      appDatabase =
          Room.databaseBuilder(instance.getApplicationContext(), AppDatabase.class, "user").build();
    }
    return appDatabase;
  }


}
