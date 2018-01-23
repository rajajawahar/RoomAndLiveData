package com.silicontechnologies.livedatasample.model.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rajajawahar on 23/01/18.
 */

@Entity public class User {

  @PrimaryKey @SerializedName("id") public int id;
  @SerializedName("login") public String login;
  @SerializedName("avatar_url") public String avatar_url;
  @SerializedName("gravatar_id") public String gravatar_id;
  @SerializedName("url") public String url;
  @SerializedName("html_url") public String html_url;
  @SerializedName("followers_url") public String followers_url;
  @SerializedName("following_url") public String following_url;
  @SerializedName("gists_url") public String gists_url;
  @SerializedName("starred_url") public String starred_url;
  @SerializedName("subscriptions_url") public String subscriptions_url;
  @SerializedName("organizations_url") public String organizations_url;
  @SerializedName("repos_url") public String repos_url;
  @SerializedName("events_url") public String events_url;
  @SerializedName("received_events_url") public String received_events_url;
  @SerializedName("type") public String type;
  @SerializedName("site_admin") public boolean site_admin;
  @SerializedName("name") public String name;
  @SerializedName("company") public String company;
  @SerializedName("blog") public String blog;
  @SerializedName("location") public String location;
  @SerializedName("email") public String email;
  @SerializedName("hireable") public boolean hireable;
  @SerializedName("bio") public String bio;
  @SerializedName("public_repos") public int public_repos;
  @SerializedName("public_gists") public int public_gists;
  @SerializedName("followers") public int followers;
  @SerializedName("following") public int following;
  @SerializedName("created_at") public String created_at;
  @SerializedName("updated_at") public String updated_at;
}
