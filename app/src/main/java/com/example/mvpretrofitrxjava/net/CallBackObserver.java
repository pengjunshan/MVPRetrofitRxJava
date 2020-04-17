package com.example.mvpretrofitrxjava.net;

import android.content.Context;
import com.example.mvpretrofitrxjava.base.BaseBean;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @author：PengJunShan.
 *
 * 描述：公共Observer
 */
public class CallBackObserver<T> implements Observer<T> {

  private IResponseListener<T> mListener;
  /**
   * 特殊Code
   */
  private static final int ERRORLOGIN = 999;
  /**
   * token失效
   */
  private static final int ERRORLOGINCODE = 403;

  public CallBackObserver(IResponseListener<T> listener, Context context) {
    this(listener, context, false);
  }
  public CallBackObserver(IResponseListener<T> listener, Context context,boolean cancelShowDialog) {
    this.mListener = listener;
  }
  @Override
  public void onSubscribe(Disposable d) {
   //显示加载圈
  }

  @Override
  public void onNext(T data) {
    if (mListener != null) {
      if(data instanceof Response) {
        mListener.onSuccess(data);
      }else if(data instanceof ResponseBody) {
        mListener.onSuccess(data);
      }else if(data instanceof BaseBean) {
        BaseBean baseBean = (BaseBean) data;
        if (baseBean.isSuccess()) {
          mListener.onSuccess(data);
        }else {
          if (baseBean.getCode() == ERRORLOGIN || baseBean.getCode() == ERRORLOGINCODE) {
            //处理操作
          } else {
            mListener.onFail(new OkHttpException(baseBean.getCode(), baseBean.getMessage()));
          }
        }
      }else {
          //自由处理后再返回
        mListener.onSuccess(data);
      }

    }

  }

  @Override
  public void onError(Throwable e) {
    onComplete();
    if (mListener != null) {
      OkHttpException okHttpException = ExceptionHandle.handleException(e);
      if(okHttpException !=null) {
        mListener.onFail(okHttpException);
      }
    }

  }

  @Override
  public void onComplete() {
    //关闭加载圈
  }

}
