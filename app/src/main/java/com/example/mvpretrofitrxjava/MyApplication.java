package com.example.mvpretrofitrxjava;

import android.content.Context;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import com.example.mvpretrofitrxjava.net.HeaderInterceptor;
import com.example.mvpretrofitrxjava.net.HttpsUtils;
import com.example.mvpretrofitrxjava.net.RequestInterceptor;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/**
 * 创建： PengJunShan
 *
 * 描述：初始化
 */

public class MyApplication extends MultiDexApplication {

  private static Context mContext;
  private static OkHttpClient mOkHttpClient;

  public static Context getMyContext() {
    return mContext;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    mContext = getApplicationContext();
    MultiDex.install(mContext);
    initOkHttp();
  }

  private void initOkHttp() {
    //获取缓存路径
    File cacheDir = getExternalCacheDir();
    //设置缓存的大小
    int cacheSize = 10 * 1024 * 1024;
    mOkHttpClient = new OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)//连接超时(单位:秒)
        .writeTimeout(30, TimeUnit.SECONDS)//写入超时(单位:秒)
        .readTimeout(30, TimeUnit.SECONDS)//读取超时(单位:秒)
        .pingInterval(20, TimeUnit.SECONDS) //websocket轮训间隔(单位:秒)
        .cache(new Cache(cacheDir.getAbsoluteFile(), cacheSize))//设置缓存
        .addInterceptor(new HeaderInterceptor())//头部拦截器
        .addInterceptor(new RequestInterceptor())//日志拦截器
        //添加https支持
        .hostnameVerifier((hostname, session) -> true)
        .sslSocketFactory(HttpsUtils.initSSLSocketFactory(), HttpsUtils.initTrustManager())
        .build();
  }

  public static OkHttpClient getOkHttpClient() {
    return mOkHttpClient;
  }

}
