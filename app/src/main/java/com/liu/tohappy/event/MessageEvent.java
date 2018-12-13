package com.liu.tohappy.event;

/**
 * @创建者 liuyang
 * @创建时间 2018/12/13 15:05
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class MessageEvent{

    public static String MSG_ADD_SUCCESS = "1";
    public static String MSG_UPDATE = "2";

    private String message;
    public  MessageEvent(String message){
        this.message=message;
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
