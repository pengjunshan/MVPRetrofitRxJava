package com.example.mvpretrofitrxjava.activity.ease;

import android.content.Context;

/**
 * 版权：杭州柯林电气股份有限公司
 *
 * @author PengJunShan
 * @time 2020-04-16  09:25
 *
 * 描述：契约类 将Model、View、Presenter 进行约束管理，方便后期类的查找、维护。
 */
public class EaseConcacts {

  interface IView {

    /**
     * View层获取数据回调方法
     */
    void onResultData(String data);
  }

  interface IPresenter {

    /**
     * View层向Presenter发送请求方法
     */
    void requestData(Context context);
  }

  interface IModel {

    /**
     * Persenter层向Model发送请求方法
     */
    void getData(Context context, ModelListener modelListener);

    interface ModelListener {

      /**
       * Model层请求接口完成后回调Persenter层方法
       */
      void onReslutJson(String test);
    }
  }
}
