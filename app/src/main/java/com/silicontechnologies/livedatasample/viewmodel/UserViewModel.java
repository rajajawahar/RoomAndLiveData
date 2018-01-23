package com.silicontechnologies.livedatasample.viewmodel;

import android.arch.lifecycle.ViewModel;
import com.silicontechnologies.livedatasample.entities.User;

/**
 * Created by rajajawahar on 23/01/18.
 */

public class UserViewModel extends ViewModel {

  private String userId;
  private User user;

  public void init(String userId) {
    this.userId = userId;
  }

  public User getUser() {
    return user;
  }


}
