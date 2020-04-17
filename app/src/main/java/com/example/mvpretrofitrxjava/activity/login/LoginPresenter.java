package com.example.mvpretrofitrxjava.activity.login;

import android.content.Context;
import android.text.TextUtils;
import com.example.mvpretrofitrxjava.activity.bean.LoginBean;
import com.example.mvpretrofitrxjava.base.BasePresenter;
import com.example.mvpretrofitrxjava.net.IResponseListener;
import com.example.mvpretrofitrxjava.net.OkHttpException;
import com.example.mvpretrofitrxjava.net.RetrofitClient;
import com.example.mvpretrofitrxjava.utils.Logout;
import java.util.HashMap;
import java.util.Map;

/**
 * 版权：杭州柯林电气股份有限公司
 *
 * @author PengJunShan
 * @time 2020-04-15  14:28
 *
 * 描述：
 */
public class LoginPresenter extends BasePresenter<LoginConcacts.IView> implements
    LoginConcacts.IPresenter {

  private Context context;
  private LoginModel modle;

  public LoginPresenter(Context context) {
    this.context = context;
    this.modle = new LoginModel();
  }

  @Override
  public void checkData(String userName, String userPwd) {
    if (TextUtils.isEmpty(userName)) {
      getView().showToast("请输入账号！");
    } else if (TextUtils.isEmpty(userPwd)) {
      getView().showToast("请输入密码！");
    } else {
      requestData(userName, userPwd);
    }
  }

  @Override
  public void requestData(String userName, String userPwd) {

    /**
     * 方式一：调用Modle进行调用接口
     */
//    modle.getData(context,userName,userPwd, test -> getView().onResultData(test));

    /**
     * 方式二：把Modle弱引用掉，这里RetrofitClient网络请求就是Modle，可以省略一个Modle文件
     */
    Map<String, String> map = new HashMap<>();
    map.put("username", userName);
    map.put("password", userPwd);

    RetrofitClient.request(context, RetrofitClient.createApi().postLogin(map),
        new IResponseListener<LoginBean>() {
          @Override
          public void onSuccess(LoginBean data) {
            Logout.e("data= " + data.toString());
            getView().onResultData(data.toString());
          }

          @Override
          public void onFail(OkHttpException failuer) {
            getView().onResultData("失败= " + failuer.getEmsg());
          }
        });
  }
}
