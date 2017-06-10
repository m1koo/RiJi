package org.miko.enums;

/**
 * 使用枚举字典表示常量数据字典
 * Created by Miko on 2017/2/27.
 */
public enum UploadStateEnum {
    SUCCESS(1,"上传成功"),
    REPEAT_UPLOAD(0,"重复上传"),
    INNER_ERROR(-1,"系统异常");
    private int state;
    private String stateInfo;

    public static UploadStateEnum stateOf(int index){
        for(UploadStateEnum state:values()){
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }

    UploadStateEnum(int state, String stateInfo) {
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
