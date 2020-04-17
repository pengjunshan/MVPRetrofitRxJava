package com.example.mvpretrofitrxjava.base;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;

/**
 * 版权：杭州柯林电气股份有限公司
 *
 * @author PengJunShan
 * @time 2020-03-21  19:24
 *
 * 描述：
 */
public abstract class BaseActivity<V extends BaseView, P extends BasePresenter<V>> extends
    Activity implements BaseView {

  private P presenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (presenter == null) {
      presenter = createPresenter();
    }
    /**
     * 绑定view
     */
    if (presenter != null) {
      presenter.attachView((V) this);
    }

  }

  /**
   * 得到当前的Presenter类
   */
  public P getPresenter() {
    return presenter;
  }

  /**
   * 创建Presenter类
   */
  public abstract P createPresenter();

  @Override
  protected void onDestroy() {
    super.onDestroy();
    /**
     * 解绑view
     */
    if (presenter != null) {
      presenter.detachView();
    }
  }
}
