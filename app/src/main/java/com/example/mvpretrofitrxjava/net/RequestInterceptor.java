package com.example.mvpretrofitrxjava.net;

import com.example.mvpretrofitrxjava.utils.Logout;
import java.io.IOException;
import java.net.URLDecoder;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 创建： PengJunShan On 2019-07-28  21:04
 *
 * 描述：拦截器
 */

public class RequestInterceptor implements Interceptor {

  @Override
  public Response intercept(Chain chain) throws IOException {

    /**
     * 这个chain里面包含了request和response，所以你要什么都可以从这里拿
     */
    Request request = chain.request();
    long startTime = System.currentTimeMillis();
    Logout.e("requestUrl=" + request.url());
    Logout.e("headers= " + request.headers());
    Logout.e("method= " + request.method());
    String method = request.method();

    if ("POST".equals(method)) {

      try {
        JSONObject jsonObject = new JSONObject();

        if (request.body() instanceof FormBody) {
          FormBody body = (FormBody) request.body();
          for (int i = 0; i < body.size(); i++) {
            jsonObject.put(body.encodedName(i), body.encodedValue(i));
          }
          Logout.e("入参JSON= " + URLDecoder.decode(jsonObject.toString(), "utf-8"));
        }

      } catch (JSONException e) {
        e.printStackTrace();
      }
    }

    Response response = chain.proceed(request);
    /**
     * 这里不能直接使用response.body().string()的方式输出日志
     * 因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一个新的response给应用层处理
     */
    ResponseBody responseBody = response.peekBody(1024 * 1024);
    Logout.e("出参JSON= " + responseBody.string());
    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime;
    Logout.e("----------" +  "End:" + duration + "毫秒----------");
    return response;
  }

}
