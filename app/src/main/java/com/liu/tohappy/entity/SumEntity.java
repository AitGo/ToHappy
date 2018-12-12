package com.liu.tohappy.entity;

import java.io.Serializable;

/**
 * @创建者 liuyang
 * @创建时间 2018/12/12 16:28
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class SumEntity implements Serializable{
    private int number;
    private String content;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
