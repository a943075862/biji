package com.qf.dubbo.pojo;

import java.io.Serializable;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/12  16:34
 */

public class Site implements Serializable {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Site{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
