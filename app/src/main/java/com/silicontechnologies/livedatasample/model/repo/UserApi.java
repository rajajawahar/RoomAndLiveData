package com.silicontechnologies.livedatasample.model.repo;

import com.silicontechnologies.livedatasample.model.entities.User;

/**
 * Created by rajajawahar on 23/01/18.
 */

public interface UserApi {

  @GET("/users/{user}")
  Call<User> getUser(@Path("user") String userId);
}
