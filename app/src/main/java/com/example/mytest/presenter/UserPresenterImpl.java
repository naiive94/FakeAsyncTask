package com.example.mytest.presenter;

import com.example.mytest.bean.User;
import com.example.mytest.component.Repeater;
import com.example.mytest.model.UserModel;
import com.example.mytest.model.UserModelImpl;
import com.example.mytest.view.UserView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by wangzhe on 15/12/17.
 */
public class UserPresenterImpl implements UserPresenter {

    UserModel mUserModel;
    UserView mUserView;

    public UserPresenterImpl(UserView mUserView) {
        this.mUserView = mUserView;
        mUserModel = new UserModelImpl();
    }

    @Override
    public void getUser() {

        mUserView.showProgressDialog();
        mUserModel.getUser().observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<User>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        mUserView.hideProgressDialog();
                        mUserView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(User user) {
                        mUserView.hideProgressDialog();
                        mUserView.updateView(user);
                    }
                });
    }

    @Override
    public void getUser2() {
        mUserView.showProgressDialog();
        mUserModel.getUser2().onMainThread(new Repeater.CallBack<User>() {
            @Override
            public void onNext(User user) {

            }

            @Override
            public void onError(String exception) {

            }

            @Override
            public void onCompleted() {

            }
        });
    }
}
