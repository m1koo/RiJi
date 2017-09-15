package org.miko.entity;

/**
 * Created by Miko on 2017/3/6.
 */
public class UserLoginMsgBean {
    private String password;
    private long userId;

    @Override
    public String toString() {
        return "UserLoginMsg{" +
                ", password='" + password + '\'' +
                ", id=" + userId +
                '}';
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
