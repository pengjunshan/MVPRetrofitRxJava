package com.example.mvpretrofitrxjava.activity.ease;

import android.content.Context;
import com.example.mvpretrofitrxjava.activity.bean.BannerBean;
import com.example.mvpretrofitrxjava.net.IResponseListener;
import com.example.mvpretrofitrxjava.net.OkHttpException;
import com.example.mvpretrofitrxjava.net.RetrofitClient;
import com.example.mvpretrofitrxjava.utils.Logout;

/**
 * 版权：杭州柯林电气股份有限公司
 *
 * @author PengJunShan
 * @time 2020-04-16  09:33
 *
 * 描述：
 */
public class EaseModel implements EaseConcacts.IModel {

  @Override
  public void getData(Context context, ModelListener modelListener) {
    RetrofitClient.request(context, RetrofitClient.createApi().getJson(),
        new IResponseListener<BannerBean>() {
          @Override
          public void onSuccess(BannerBean data) {
            /**
             * 在此可以处理数据 增删改查、本地存储等等
             */
            Logout.e("data= "+data.toString());
            modelListener.onReslutJson(data.toString());
          }

          @Override
          public void onFail(OkHttpException failuer) {
            modelListener.onReslutJson("失败= "+failuer.getEmsg());
          }
        });
  }

}
