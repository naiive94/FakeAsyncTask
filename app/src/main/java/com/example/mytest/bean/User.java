package com.example.mytest.bean;

import com.example.mytest.component.BaseBean;

/**
 * Created by wangzhe on 15/12/17.
 */
public class User extends BaseBean{

    String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
