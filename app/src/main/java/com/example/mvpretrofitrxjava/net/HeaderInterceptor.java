package com.example.mvpretrofitrxjava.net;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 创建： PengJunShan On 2019-07-30  15:40
 *
 * 描述：统一添加token
 */
public class HeaderInterceptor implements Interceptor {

  @Override
  public Response intercept(Chain chain) throws IOException {
    String token = "";
    String ID = "";
    Request request = chain.request()
        .newBuilder()
        .header("Authorization", token)
        .header("ID", ID)
        .build();
    return chain.proceed(request);
  }

}
