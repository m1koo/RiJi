package org.miko.enums;

/**
 * 使用枚举字典表示常量数据字典
 * Created by Miko on 2017/2/27.
 */
public enum LoginStateEnum {
    SUCCESS(1,"登录成功"),
    ERROR_PASSWORD(0,"密码错误"),
    NO_USER(-1,"用户不存在"),
    INNER_ERROR(-2,"系统异常");
    private int state;
    private String stateInfo;

    public static LoginStateEnum stateOf(int index){
        for(LoginStateEnum state:values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }

    LoginStateEnum(int state, String stateInfo) {
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
