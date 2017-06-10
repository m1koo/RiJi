package org.miko.dto;

/**
 * Created by Miko on 2017/3/6.
 */
public class UploadExcution {
    int state;
    String info;

    public UploadExcution(int state, String info) {
        this.state = state;
        this.info = info;
    }


    @Override
    public String toString() {
        return "LoginExcution{" +
                "state=" + state +
                ", info='" + info + '\'' +
                '}';
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
