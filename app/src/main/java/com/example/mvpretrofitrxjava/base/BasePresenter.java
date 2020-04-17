package com.example.mvpretrofitrxjava.base;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 版权：杭州柯林电气股份有限公司
 *
 * @author PengJunShan
 * @time 2020-03-21  18:54
 *
 * 描述：
 */
public abstract class BasePresenter<V extends BaseView> {

  private V view;
  private V proxyView;

  public V getView() {
    return proxyView;
  }

  /**
   * 绑定view
   */
  public void attachView(V view) {
    this.view = view;
    //参数一：类加载器
    ClassLoader classLoader = view.getClass().getClassLoader();
    //参数二：代理接口
    Class<?>[] interfaces = view.getClass().getInterfaces();
    //参数三：方法回调
    BaseViewInvocationHandler handler = new BaseViewInvocationHandler(view);
    proxyView = (V) Proxy.newProxyInstance(classLoader, interfaces, handler);
  }

  /**
   * 解绑view
   */
  public void detachView() {
    this.view = null;
  }

  private class BaseViewInvocationHandler implements InvocationHandler {

    private BaseView view;

    BaseViewInvocationHandler(BaseView view) {
      this.view = view;
    }

    //统一判断->控制对象访问权限
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
      //检查是不是为null
      if (isViewNull()) {
        //不用回调
        return null;
      }
      //执行回调
      return method.invoke(view, objects);
    }
  }

  private boolean isViewNull() {
    if (view == null) {
      return true;
    }
    return false;
  }

}
