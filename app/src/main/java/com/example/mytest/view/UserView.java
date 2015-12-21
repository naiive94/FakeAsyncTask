package com.example.mytest.view;

import com.example.mytest.bean.User;

/**
 * Created by wangzhe on 15/12/17.
 */
public interface UserView {

    void updateView(User user);

    void showProgressDialog();

    void hideProgressDialog();

    void showError(String msg);


}
