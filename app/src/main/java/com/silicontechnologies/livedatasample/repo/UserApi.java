package com.silicontechnologies.livedatasample.repo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rajajawahar on 23/01/18.
 */

public interface UserApi {

  @GET("/users/{user}") Call<User> getUser(@Path("user") String userId);
}
