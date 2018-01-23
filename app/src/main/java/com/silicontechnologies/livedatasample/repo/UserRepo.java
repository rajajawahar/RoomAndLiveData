package com.silicontechnologies.livedatasample.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.silicontechnologies.livedatasample.db.AppDatabase;
import com.silicontechnologies.livedatasample.entities.User;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rajajawahar on 23/01/18.
 */

public class UserRepo {

  private UserApi userApi;
  private AppDatabase appDatabase;

  public UserRepo(UserApi userApi, AppDatabase appDatabase) {
    this.userApi = userApi;
    this.appDatabase = appDatabase;
  }

  public Observable<User> getUser(String userId) {
    return userApi.getUser(userId);
  }
}
