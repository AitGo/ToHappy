package com.liu.tohappy.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @创建者 liuyang
 * @创建时间 2018/12/12 16:28
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */
@Entity(nameInDb = "sum_info",indexes = {
        @Index(value = "id DESC",unique = true)
})
public class SumEntity {
    @Id(autoincrement = true)//设置自增长
    private Long id;
    @Property(nameInDb = "content") @NotNull
    private String content;


    @Generated(hash = 661703270)
    public SumEntity(Long id, @NotNull String content) {
        this.id = id;
        this.content = content;
    }

    @Generated(hash = 1051038294)
    public SumEntity() {
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
