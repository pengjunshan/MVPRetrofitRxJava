package com.example.mvpretrofitrxjava.net;

import android.net.ParseException;
import com.example.mvpretrofitrxjava.base.BaseBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import java.io.IOException;
import java.net.ConnectException;
import okhttp3.ResponseBody;
import org.json.JSONException;
import retrofit2.HttpException;

/**
 * @author：PengJunShan.
 * 描述：错误解析类
 */
public class ExceptionHandle {

  private static final int TIMEOUT_ERROR = -1;
  private static final int JSON_ERROR = -2;
  private static final int NETWORK_ERROR = -3;
  private static final int OTHER_ERROR = -4;

  private static final String TIMEOUTMSG = "请求超时";
  private static final String JSONMSG = "解析错误";
  private static final String NETWORKMSG = "连接失败";
  private static final String OTHERMSG = "未知错误";

  private static final int ERRORLOGIN = 999;
  private static final int ERRORLOGINCODE = 403;

  public static OkHttpException handleException(Throwable e) {
    OkHttpException ex = null;
    if (e instanceof HttpException) {
      ResponseBody body = ((HttpException) e).response().errorBody();
      try {
        Gson gson = new GsonBuilder().serializeNulls().create();
        String jsonStr = body.string();
        BaseBean baseBean = gson.fromJson(jsonStr, BaseBean.class);
        if (baseBean.getCode() == ERRORLOGIN || baseBean.getCode() == ERRORLOGINCODE) {
          //处理操作
        } else {
          ex = new OkHttpException(baseBean.getCode(), baseBean.getMessage());
        }
      } catch (IOException e1) {
        e1.printStackTrace();
      }
      return ex;
    } else if (e instanceof java.net.SocketTimeoutException) {
      ex = new OkHttpException(TIMEOUT_ERROR, TIMEOUTMSG);
      return ex;
    } else if (e instanceof JsonParseException
        || e instanceof JSONException
        || e instanceof ParseException) {
      ex = new OkHttpException(JSON_ERROR, JSONMSG);
      return ex;
    } else if (e instanceof ConnectException) {
      ex = new OkHttpException(NETWORK_ERROR, NETWORKMSG);
      return ex;
    } else {
      ex = new OkHttpException(OTHER_ERROR, OTHERMSG);
      return ex;
    }
  }

}

