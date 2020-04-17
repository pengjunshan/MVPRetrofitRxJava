package com.example.mvpretrofitrxjava.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mvpretrofitrxjava.R;
import com.example.mvpretrofitrxjava.activity.banner.BannerActivity;
import com.example.mvpretrofitrxjava.activity.ease.EaseActivity;
import com.example.mvpretrofitrxjava.activity.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    findViewById(R.id.toEaseActivity)
        .setOnClickListener((view) -> startActivity(new Intent(this, EaseActivity.class)));

    findViewById(R.id.toActivity)
        .setOnClickListener((view) -> startActivity(new Intent(this, LoginActivity.class)));

    findViewById(R.id.toFragment)
        .setOnClickListener((view) -> startActivity(new Intent(this, BannerActivity.class)));
  }
}
