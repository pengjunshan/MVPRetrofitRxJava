package com.example.mvpretrofitrxjava.net;

import android.content.Context;
import com.example.mvpretrofitrxjava.MyApplication;
import com.example.mvpretrofitrxjava.utils.Config;
import com.example.mvpretrofitrxjava.utils.NetUtils;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 创建： PengJunShan On 2019-07-30  14:29
 * <p>
 * 描述：Retrofit实例类
 */
public class RetrofitClient {

    public static Retrofit mRetrofit;

    static {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Config.baseUrl)
                .client(MyApplication.getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 获取IApiService接口类
     *
     * @return
     */
    public static IApiService createApi() {
        return mRetrofit.create(IApiService.class);
    }

    /**
     * 获取T接口类
     */
    public static <T> T createApi(Class<T> service) {
        return mRetrofit.create(service);
    }

    public static <T> void request(Context context, Observable<T> observable,
                                   final IResponseListener<T> listener) {
        if (!NetUtils.isConnected(MyApplication.getMyContext())) {
            if (listener != null) {
                listener.onFail(new OkHttpException(-1, "网络不可用,请检查网络"));
            }
            return;
        }
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CallBackObserver<T>(listener, context));
    }

    public static <T> void request(Context context, Observable<T> observable,
                                   final IResponseListener<T> listener,boolean cancelShowDialog) {
        if (!NetUtils.isConnected(MyApplication.getMyContext())) {
            if (listener != null) {
                listener.onFail(new OkHttpException(-1, "网络不可用,请检查网络"));
            }
            return;
        }
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CallBackObserver<T>(listener,context,cancelShowDialog));
    }

}
