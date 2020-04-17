package com.example.mvpretrofitrxjava.activity.login;

import android.os.Bundle;
import android.widget.Toast;
import com.example.mvpretrofitrxjava.R;
import com.example.mvpretrofitrxjava.base.BaseActivity;

public class LoginActivity extends
    BaseActivity<LoginConcacts.IView, LoginPresenter> implements LoginConcacts.IView {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    findViewById(R.id.getJSON)
        .setOnClickListener((view) -> getPresenter().checkData("账号", "密码"));
  }

  @Override
  public LoginPresenter createPresenter() {
    return new LoginPresenter(this);
  }

  @Override
  public void showToast(String msg) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onResultData(String data) {
    Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
  }
}
