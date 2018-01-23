package com.silicontechnologies.livedatasample.utils;

import io.reactivex.Completable;
import io.reactivex.CompletableTransformer;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.Single;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import retrofit2.HttpException;
import retrofit2.Response;

/**
 * Created by admin on 13-Apr-17.
 */

public class RxJavaUtils {
  public static <T> ObservableTransformer<T, T> applyObserverSchedulers() {
    return observable -> observable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  public static CompletableTransformer applyCompletableSchedulers() {
    return completable -> completable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }

  public static <T> ObservableTransformer<T, T> applyErrorTransformer() {
    return observable -> observable.onErrorResumeNext(throwable -> {
      if (throwable instanceof IOException) {
        return Observable.error(new Throwable("No Internet Connection.."));
      }
      if (throwable instanceof HttpException) {
        Response response = ((HttpException) throwable).response();
      }
      return Observable.error(throwable);
    });
  }

  public static CompletableTransformer applyCompletableErrorTransformer() {
    return completable -> completable.onErrorResumeNext(throwable -> {
      return Completable.error(transformThrowable(throwable));
    });
  }

  public static <T> SingleTransformer<T, T> applySingleErrorTransformer() {
    return single -> single.onErrorResumeNext(throwable -> {
      return Single.error(transformThrowable(throwable));
    });
  }

  private static Throwable transformThrowable(Throwable throwable) {
    if (throwable instanceof HttpException) {
      Response response = ((HttpException) throwable).response();
      //if (ServerException.isServerError(response)) {
      //  try {
      //    return ServerException.create(response);
      //  } catch (IOException e) {
      //    e.printStackTrace();
      //  }
      //}
    }
    return throwable;
  }

  public static <T> ObservableTransformer<T, T> applyOnErrorCrasher() {
    return observable -> observable.doOnError(throwable -> {
      final Throwable checkpoint = new Throwable();
      StackTraceElement[] stackTrace = checkpoint.getStackTrace();
      StackTraceElement element = stackTrace[1]; // First element after `crashOnError()`
      String msg =
          String.format("onError() crash from subscribe() in %s.%s(%s:%s)", element.getClassName(),
              element.getMethodName(), element.getFileName(), element.getLineNumber());

      throw new OnErrorNotImplementedException(msg, throwable);
    });
  }
}
