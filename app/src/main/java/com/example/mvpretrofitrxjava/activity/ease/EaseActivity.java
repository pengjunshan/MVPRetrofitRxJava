package com.example.mvpretrofitrxjava.activity.ease;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.mvpretrofitrxjava.R;
import com.example.mvpretrofitrxjava.activity.ease.EaseConcacts.IView;

public class EaseActivity extends AppCompatActivity implements IView {

  private EasePresenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ease);

    presenter = new EasePresenter(this);
    findViewById(R.id.getJSON).setOnClickListener((view) -> presenter.requestData(this));
  }

  @Override
  public void onResultData(String data) {
    Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
  }

}
