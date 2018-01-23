package com.silicontechnologies.livedatasample.app;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.silicontechnologies.livedatasample.db.AppDatabase;
import com.silicontechnologies.livedatasample.repo.UserApi;
import com.silicontechnologies.livedatasample.repo.UserRepo;
import com.silicontechnologies.livedatasample.utils.RxErrorTransformationCallAdapterFactory;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rajajawahar on 23/01/18.
 */

public class AppController extends Application {

  private AppDatabase appDatabase;
  private static AppController instance;
  private UserRepo userRepo;
  private Gson gson;
  private HttpLoggingInterceptor logging;

  @Override public void onCreate() {
    super.onCreate();
    instance = this;
    gson = new GsonBuilder().create();
  }

  public AppDatabase getAppDatabase() {
    if (appDatabase == null) {
      appDatabase =
          Room.databaseBuilder(instance.getApplicationContext(), AppDatabase.class, "user").build();
    }
    return appDatabase;
  }

  public UserRepo createUserRepo() {
    OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(logging)
        .connectTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100, TimeUnit.SECONDS)
        .build();
    Retrofit retrofit = new Retrofit.Builder().client(httpClient)
        .baseUrl(ApiConstants.BASE_URL)
        .addCallAdapterFactory(new RxErrorTransformationCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
    return new UserRepo(retrofit.create(UserApi.class), appDatabase);
  }
}
