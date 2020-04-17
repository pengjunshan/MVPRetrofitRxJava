package com.example.mvpretrofitrxjava.activity.login;

import android.content.Context;
import com.example.mvpretrofitrxjava.base.BaseView;

/**
 * 版权：杭州柯林电气股份有限公司
 *
 * @author PengJunShan
 * @time 2020-04-15  13:08
 *
 * 描述：
 */
public class LoginConcacts {

  interface IView extends BaseView {

    /**
     * 校验账号密码错误的提示信息
     */
    void showToast(String msg);

    /**
     * View中获取接口信息的回调
     */
    void onResultData(String data);
  }

  interface IPresenter {

    /**
     * 校验账号密码
     */
    void checkData(String userName, String userPwd);

    /**
     * 请求数据
     */
    void requestData(String userName, String userPwd);
  }

  /**
   * Model可以弱化掉，节省代码量
   */
  interface IModel {

    void getData(Context context, String userName, String userPwd, ModelListener modelListener);

    interface ModelListener {

      void onReslutJson(String test);
    }
  }

}
