package com.example.mvpretrofitrxjava.activity.banner;

import android.content.Context;
import com.example.mvpretrofitrxjava.base.BaseView;

/**
 * 版权：杭州柯林电气股份有限公司
 *
 * @author PengJunShan
 * @time 2020-04-08  18:44
 *
 * 描述：契约类 将Model、View、Presenter 进行约束管理，方便后期类的查找、维护。
 */
public class BannerConcacts {

  interface IView extends BaseView {

    /**
     * 获取接口数据回调方法
     */
    void onReslutData(String data);
  }

  interface IPresenter {

    /**
     * 进行网络业务处理
     */
    void requestData(Context context);
  }

  interface IModel {

    void getBannerJSON(String params, ModelListener modelListener);

    interface ModelListener {

      void onReslutJson(String test);
    }
  }

}
