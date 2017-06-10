package org.miko.dto;

/**
 * Created by Miko on 2017/3/6.
 */
public class LoginExcution {
    boolean isSuccess;
    int state;
    String info;
    String md5;

    public boolean isSuccess() {
        return isSuccess;
    }

    /**
     * 登录失败构造函数
     * @param state
     * @param info
     */
    public LoginExcution(int state, String info) {
        this.state = state;
        this.info = info;
        this.isSuccess = false;
    }

    /**
     * 登录成功的构造函数
     * @param state
     * @param info
     * @param md5
     */
    public LoginExcution(int state, String info, String md5) {
        this.state = state;
        this.info = info;
        this.md5 = md5;
        isSuccess = true;
    }

    @Override
    public String toString() {
        return "LoginExcution{" +
                "state=" + state +
                ", info='" + info + '\'' +
                ", md5='" + md5 + '\'' +
                '}';
    }

    public String getMd5() {
        return md5;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
