package com.example.mvpretrofitrxjava.net;

/**
 * 创建： PengJunShan
 * 描述：
 */

public interface IResponseListener<T> {

  void onSuccess(T data);

  void onFail(OkHttpException failuer);

}
