package com.example.mvpretrofitrxjava.activity.bean;

import java.util.List;

/**
 * 版权：杭州柯林电气股份有限公司
 *
 * @author PengJunShan
 * @time 2020-04-16  17:49
 *
 * 描述：
 */
public class LoginBean {

  /**
   * data : {"admin":false,"chapterTops":[],"collectIds":[],"email":"","icon":"","id":12662,
   * "nickname":"15294792877","password":"","publicName":"15294792877","token":"","type":0,
   * "username":"15294792877"}
   * errorCode : 0
   * errorMsg :
   */

  private DataBean data;
  private int errorCode;
  private String errorMsg;

  @Override
  public String toString() {
    return "LoginBean{" +
        "data=" + data +
        ", errorCode=" + errorCode +
        ", errorMsg='" + errorMsg + '\'' +
        '}';
  }

  public DataBean getData() {
    return data;
  }

  public void setData(DataBean data) {
    this.data = data;
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

  public static class DataBean {

    /**
     * admin : false
     * chapterTops : []
     * collectIds : []
     * email :
     * icon :
     * id : 12662
     * nickname : 15294792877
     * password :
     * publicName : 15294792877
     * token :
     * type : 0
     * username : 15294792877
     */

    private boolean admin;
    private String email;
    private String icon;
    private int id;
    private String nickname;
    private String password;
    private String publicName;
    private String token;
    private int type;
    private String username;
    private List<?> chapterTops;
    private List<?> collectIds;

    @Override
    public String toString() {
      return "DataBean{" +
          "admin=" + admin +
          ", email='" + email + '\'' +
          ", icon='" + icon + '\'' +
          ", id=" + id +
          ", nickname='" + nickname + '\'' +
          ", password='" + password + '\'' +
          ", publicName='" + publicName + '\'' +
          ", token='" + token + '\'' +
          ", type=" + type +
          ", username='" + username + '\'' +
          ", chapterTops=" + chapterTops +
          ", collectIds=" + collectIds +
          '}';
    }

    public boolean isAdmin() {
      return admin;
    }

    public void setAdmin(boolean admin) {
      this.admin = admin;
    }

    public String getEmail() {
      return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getIcon() {
      return icon;
    }

    public void setIcon(String icon) {
      this.icon = icon;
    }

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getNickname() {
      return nickname;
    }

    public void setNickname(String nickname) {
      this.nickname = nickname;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }

    public String getPublicName() {
      return publicName;
    }

    public void setPublicName(String publicName) {
      this.publicName = publicName;
    }

    public String getToken() {
      return token;
    }

    public void setToken(String token) {
      this.token = token;
    }

    public int getType() {
      return type;
    }

    public void setType(int type) {
      this.type = type;
    }

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public List<?> getChapterTops() {
      return chapterTops;
    }

    public void setChapterTops(List<?> chapterTops) {
      this.chapterTops = chapterTops;
    }

    public List<?> getCollectIds() {
      return collectIds;
    }

    public void setCollectIds(List<?> collectIds) {
      this.collectIds = collectIds;
    }
  }
}
