package org.miko.dto;

/**
 * Created by Miko on 2017/3/6.
 */
public class LoginExcution {

    String id;
    int state;

    public LoginExcution(String id, int state) {
        this.id = id;
        this.state = state;
    }

    @Override
    public String toString() {
        return "LoginExcution{" +
                "id='" + id + '\'' +
                ", state=" + state +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
