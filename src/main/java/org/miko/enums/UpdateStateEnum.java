package org.miko.enums;

/**
 * 使用枚举字典表示常量数据字典
 * Created by Miko on 2017/2/27.
 */
public enum UpdateStateEnum {
    SUCCESS(1,"更新成功"),
    INNER_ERROR(-1,"系统异常");
    private int state;
    private String stateInfo;

    public static UpdateStateEnum stateOf(int index){
        for(UpdateStateEnum state:values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }

    UpdateStateEnum(int state, String stateInfo) {
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
