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
 * @time 2020-04-16  09:32
 *
 * 描述：
 */
public class EasePresenter implements EaseConcacts.IPresenter {

  private EaseConcacts.IView iView;
  private EaseModel iModle;

  public EasePresenter(EaseConcacts.IView view) {
    this.iView = view;
    this.iModle = new EaseModel();
  }

  @Override
  public void requestData(Context context) {

    /**
     * 方式一：调用Modle进行调用接口
     */
    iModle.getData(context, test -> iView.onResultData(test));

    /**
     * 方式二：弱化了Model的作用，这里RetrofitClient网络请求就是Modle，可以省略一个Modle文件
     */
    RetrofitClient.request(context, RetrofitClient.createApi().getJson(),
        new IResponseListener<BannerBean>() {
          @Override
          public void onSuccess(BannerBean data) {
            Logout.e("data= " + data.toString());
            iView.onResultData(data.toString());
          }

          @Override
          public void onFail(OkHttpException failuer) {
            iView.onResultData("失败= " + failuer.getEmsg());
          }
        });
  }

}
