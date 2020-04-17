package com.example.mvpretrofitrxjava.activity.banner;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mvpretrofitrxjava.R;

public class BannerActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_banner);

    getSupportFragmentManager()
        .beginTransaction()
        .add(R.id.frameLoayout,new BannerFragment())
        .commit();
  }
}
