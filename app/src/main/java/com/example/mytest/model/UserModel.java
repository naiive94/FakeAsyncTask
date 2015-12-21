package com.example.mytest.model;

import com.example.mytest.bean.User;
import com.example.mytest.component.Repeater;

import rx.Observable;


/**
 * Created by wangzhe on 15/12/17.
 */
public interface UserModel {

    Observable<User> getUser();

    Repeater<User> getUser2();
}
