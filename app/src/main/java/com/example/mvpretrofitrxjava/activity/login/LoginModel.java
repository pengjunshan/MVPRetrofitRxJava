package com.example.mvpretrofitrxjava.activity.login;

import android.content.Context;
import com.example.mvpretrofitrxjava.activity.bean.LoginBean;
import com.example.mvpretrofitrxjava.activity.login.LoginConcacts.IModel;
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
 * @time 2020-04-15  16:44
 *
 * 描述：
 */
public class LoginModel implements IModel {

  @Override
  public void getData(Context context, String userName, String userPwd,
      ModelListener modelListener) {
    Map<String, String> map = new HashMap<>();
    map.put("username", userName);
    map.put("password", userPwd);

    RetrofitClient.request(context, RetrofitClient.createApi().postLogin(map),
        new IResponseListener<LoginBean>() {
          @Override
          public void onSuccess(LoginBean data) {
            Logout.e("data= " + data.toString());
            modelListener.onReslutJson(data.toString());
          }

          @Override
          public void onFail(OkHttpException failuer) {
            modelListener.onReslutJson("失败= " + failuer.getEmsg());
          }
        });
  }

}
