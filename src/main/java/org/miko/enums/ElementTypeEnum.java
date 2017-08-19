package org.miko.enums;

/**
 * 使用枚举字典表示常量数据字典
 * Created by Miko on 2017/2/27.
 */
public enum ElementTypeEnum {
    TEXT(-1, "文字"),
    GIF(1, "动图"),
    IMAGE(0, "图片"),
    VIDEO(2, "视频");
    private int state;
    private String stateInfo;

    public static ElementTypeEnum stateOf(int index) {
        for (ElementTypeEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

    ElementTypeEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
}
