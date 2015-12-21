package com.example.mytest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.toolbox.StringRequest;
import com.example.mytest.bean.User;
import com.example.mytest.presenter.UserPresenter;
import com.example.mytest.presenter.UserPresenterImpl;
import com.example.mytest.view.UserView;

public class MainActivity extends AppCompatActivity implements UserView{
    private Context context = this;

    private UserPresenter mUserPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserPresenter = new UserPresenterImpl(this);

    }

    @Override
    public void updateView(User user) {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void showError(String msg) {

    }
}
