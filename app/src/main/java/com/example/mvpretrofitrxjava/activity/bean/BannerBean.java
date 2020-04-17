package com.example.mvpretrofitrxjava.activity.bean;

import java.util.List;

/**
 * 版权：杭州柯林电气股份有限公司
 *
 * @author PengJunShan
 * @time 2020-04-15  14:57
 *
 * 描述：
 */
public class BannerBean {

  /**
   * data : [{"desc":"享学~","id":29,"imagePath":"https://wanandroid
   * .com/blogimgs/6f9c0f25-e02d-48a5-bbfa-ed199416009a.png","isVisible":1,"order":0,
   * "title":"产品上线，突发bug&hellip;","type":0,"url":"https://mp.weixin.qq
   * .com/s/TcF4w0Bz-k5dZdPKq3HIGA"},{"desc":"","id":6,"imagePath":"https://www.wanandroid
   * .com/blogimgs/62c1bd68-b5f3-4a3c-a649-7ca8c7dfabe6.png","isVisible":1,"order":1,
   * "title":"我们新增了一个常用导航Tab~","type":1,"url":"https://www.wanandroid.com/navi"},{"desc
   * ":"一起来做个App吧","id":10,"imagePath":"https://www.wanandroid
   * .com/blogimgs/50c115c2-cf6c-4802-aa7b-a4334de444cd.png","isVisible":1,"order":1,
   * "title":"一起来做个App吧","type":1,"url":"https://www.wanandroid.com/blog/show/2"},{"desc":"",
   * "id":20,"imagePath":"https://www.wanandroid
   * .com/blogimgs/90c6cc12-742e-4c9f-b318-b912f163b8d0.png","isVisible":1,"order":2,
   * "title":"flutter 中文社区 ","type":1,"url":"https://flutter.cn/"}]
   * errorCode : 0
   * errorMsg :
   */

  private int errorCode;
  private String errorMsg;
  private List<DataBean> data;

  @Override
  public String toString() {
    return "BannerBean{" +
        "errorCode=" + errorCode +
        ", errorMsg='" + errorMsg + '\'' +
        ", data=" + data +
        '}';
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public List<DataBean> getData() {
    return data;
  }

  public void setData(List<DataBean> data) {
    this.data = data;
  }

  public static class DataBean {

    /**
     * desc : 享学~
     * id : 29
     * imagePath : https://wanandroid.com/blogimgs/6f9c0f25-e02d-48a5-bbfa-ed199416009a.png
     * isVisible : 1
     * order : 0
     * title : 产品上线，突发bug&hellip;
     * type : 0
     * url : https://mp.weixin.qq.com/s/TcF4w0Bz-k5dZdPKq3HIGA
     */

    private String desc;
    private int id;
    private String imagePath;
    private int isVisible;
    private int order;
    private String title;
    private int type;
    private String url;

    @Override
    public String toString() {
      return "DataBean{" +
          "desc='" + desc + '\'' +
          ", id=" + id +
          ", imagePath='" + imagePath + '\'' +
          ", isVisible=" + isVisible +
          ", order=" + order +
          ", title='" + title + '\'' +
          ", type=" + type +
          ", url='" + url + '\'' +
          '}';
    }

    public String getDesc() {
      return desc;
    }

    public void setDesc(String desc) {
      this.desc = desc;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getImagePath() {
      return imagePath;
    }

    public void setImagePath(String imagePath) {
      this.imagePath = imagePath;
    }

    public int getIsVisible() {
      return isVisible;
    }

    public void setIsVisible(int isVisible) {
      this.isVisible = isVisible;
    }

    public int getOrder() {
      return order;
    }

    public void setOrder(int order) {
      this.order = order;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public int getType() {
      return type;
    }

    public void setType(int type) {
      this.type = type;
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }
  }
}
