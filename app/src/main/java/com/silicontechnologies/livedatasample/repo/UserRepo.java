package com.silicontechnologies.livedatasample.repo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.silicontechnologies.livedatasample.entities.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rajajawahar on 23/01/18.
 */

public class UserRepo {

  private UserApi userApi;

  public UserRepo(UserApi userApi) {
    this.userApi = userApi;
  }

  public LiveData<User> getUser(String userId) {
    final MutableLiveData<User> data = new MutableLiveData<>();
    userApi.getUser(userId).enqueue(new Callback<User>() {
      @Override public void onResponse(Call<User> call, Response<User> response) {
        data.setValue(response.body());
      }

      @Override public void onFailure(Call<User> call, Throwable t) {

      }
    });
    return data;
  }
}
