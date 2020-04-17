package com.example.mvpretrofitrxjava.activity.banner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.mvpretrofitrxjava.R;
import com.example.mvpretrofitrxjava.base.BaseFragment;

/**
 * 版权：杭州柯林电气股份有限公司
 *
 * @author PengJunShan
 * @time 2020-03-22  13:55
 *
 * 描述：
 */
public class BannerFragment extends BaseFragment<BannerConcacts.IView, BannerPresenter> implements
    BannerConcacts.IView {

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.banner, null);
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    view.findViewById(R.id.getJSON)
        .setOnClickListener((v) -> getPresenter().requestData(getContext()));
  }

  @Override
  public BannerPresenter createPresenter() {
    return new BannerPresenter();
  }

  @Override
  public void onReslutData(String data) {
    Toast.makeText(getContext(), data, Toast.LENGTH_SHORT).show();
  }

}
