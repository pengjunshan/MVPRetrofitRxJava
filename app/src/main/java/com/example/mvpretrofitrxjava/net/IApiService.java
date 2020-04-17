package com.example.mvpretrofitrxjava.net;

import com.example.mvpretrofitrxjava.activity.bean.BannerBean;
import com.example.mvpretrofitrxjava.activity.bean.LoginBean;
import io.reactivex.Observable;
import java.util.Map;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * 创建： PengJunShan On 2019-07-30  14:28
 *
 * 描述：接口
 */
public interface IApiService {

  @GET("http://www.wanandroid.com/banner/json")
  Observable<BannerBean> getJson();

  @POST("https://www.wanandroid.com/user/login")
  @FormUrlEncoded
  Observable<LoginBean> postLogin(@FieldMap Map<String,String> map);

}
