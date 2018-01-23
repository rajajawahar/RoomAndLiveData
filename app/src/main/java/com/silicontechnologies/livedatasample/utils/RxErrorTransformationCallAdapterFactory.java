package com.silicontechnologies.livedatasample.utils;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * Created by admin on 22-Jul-17.
 */
public class RxErrorTransformationCallAdapterFactory extends CallAdapter.Factory {

  @Override
  public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
    Class<?> rawType = getRawType(returnType);
    boolean isSingle = Single.class == rawType;
    boolean isCompletable = Completable.class == rawType;

    if (rawType != Observable.class && !isSingle && !isCompletable) {
      // Return type not a Rx type.
      return null;
    }

    CallAdapter delegate = retrofit.nextCallAdapter(this, returnType, annotations);
    return new CallAdapter<Object, Object>() {
      @Override public Type responseType() {
        return delegate.responseType();
      }

      @Override public Object adapt(Call<Object> call) {
        Object object = delegate.adapt(call);
        if (isSingle) {
          return ((Single<?>) object).compose(RxJavaUtils.applySingleErrorTransformer());
        } else if (isCompletable) {
          return ((Completable) object).compose(RxJavaUtils.applyCompletableErrorTransformer());
        } else {
          return ((Observable<?>) object).compose(RxJavaUtils.applyErrorTransformer());
        }
      }
    };
  }
}