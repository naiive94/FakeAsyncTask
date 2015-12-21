package com.example.mytest.model;

import com.example.mytest.bean.User;
import com.example.mytest.component.Repeater;

import rx.Observable;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by wangzhe on 15/12/17.
 */
public class UserModelImpl implements UserModel {
    @Override
    public Observable<User> getUser() {



        return Observable.create(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> subscriber) {

                try {
                    Thread.sleep(2000);
                } catch (Exception e) {

                }

                User user = new User("123");
                if (user == null) {
                    subscriber.onError(new Exception("User == null"));
                } else {
                    subscriber.onNext(user);
                    subscriber.onCompleted();
                }
            }
        }).subscribeOn(Schedulers.newThread());
    }

    @Override
    public Repeater<User> getUser2() {
        return new Repeater<User>() {
            @Override
            public void onNewThread(NewThreadCallBack<User> callBack) {
                callBack.onSuccess(new User(""));
                callBack.onFail("error");
            }
        };
    }
}
