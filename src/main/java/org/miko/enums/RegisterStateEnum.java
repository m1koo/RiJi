package org.miko.enums;

/**
 * 使用枚举字典表示常量数据字典
 * Created by Miko on 2017/2/27.
 */
public enum RegisterStateEnum {
    SUCCESS(1,"注册成功"),
    REPEAT_REGINSTER(-1,"用户名重复注册"),
    INNER_ERROR(-2,"系统异常");
    private int state;
    private String stateInfo;

    public static RegisterStateEnum stateOf(int index){
        for(RegisterStateEnum state:values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }

    RegisterStateEnum(int state, String stateInfo) {
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
