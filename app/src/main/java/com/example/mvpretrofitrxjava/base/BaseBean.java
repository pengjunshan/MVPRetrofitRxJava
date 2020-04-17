package com.example.mvpretrofitrxjava.base;

import java.io.Serializable;

/**
 * 创建： PengJunShan
 *
 * 描述：bean基类
 */

public class BaseBean<T> implements Serializable {

  private static int SUCCESS_CODE = 200;//接口访问成功的code
  private int code;
  private String message;
  private T data;
  /**
   * 是否成功获取到数据
   */
  public boolean isSuccess() {
    return getCode() == SUCCESS_CODE;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BaseBean{" +
        "code=" + code +
        ", message='" + message + '\'' +
        ", data=" + data +
        '}';
  }
}
