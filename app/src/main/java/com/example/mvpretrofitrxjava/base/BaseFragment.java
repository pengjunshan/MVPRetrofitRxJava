package com.example.mvpretrofitrxjava.base;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 版权：杭州柯林电气股份有限公司
 *
 * @author PengJunShan
 * @time 2020-03-22  13:41
 *
 * 描述：
 */
public abstract class BaseFragment<V extends BaseView, P extends BasePresenter<V>> extends
    Fragment implements BaseView {

  private P presenter;

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    if (presenter == null) {
      presenter = createPresenter();
    }
    if (presenter != null) {
      presenter.attachView((V) this);
    }
  }

  public P getPresenter() {
    return presenter;
  }

  public abstract P createPresenter();

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    if (presenter != null) {
      presenter.detachView();
    }
  }

}
