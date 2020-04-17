package com.example.mvpretrofitrxjava.activity.banner;

import android.content.Context;
import com.example.mvpretrofitrxjava.activity.bean.BannerBean;
import com.example.mvpretrofitrxjava.base.BasePresenter;
import com.example.mvpretrofitrxjava.net.IResponseListener;
import com.example.mvpretrofitrxjava.net.OkHttpException;
import com.example.mvpretrofitrxjava.net.RetrofitClient;
import com.example.mvpretrofitrxjava.utils.Logout;

/**
 * 版权：杭州柯林电气股份有限公司
 *
 * @author PengJunShan
 * @time 2020-04-08  18:48
 *
 * 描述：
 */
public class BannerPresenter extends BasePresenter<BannerConcacts.IView> implements
    BannerConcacts.IPresenter {

  @Override
  public void requestData(Context context) {

    RetrofitClient.request(context, RetrofitClient.createApi().getJson(),
        new IResponseListener<BannerBean>() {
          @Override
          public void onSuccess(BannerBean data) {
            Logout.e("Tag", "data= " + data.toString());
            getView().onReslutData(data.toString());
          }

          @Override
          public void onFail(OkHttpException failuer) {
            getView().onReslutData("失败= " + failuer.getEmsg());
          }
        });
  }
}
