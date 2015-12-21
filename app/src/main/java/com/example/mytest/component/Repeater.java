package com.example.mytest.component;


import com.example.mytest.bean.User;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by wangzhe on 15/12/19.
 */
public abstract class Repeater<T> {

    Observable<T> observable;

    public Repeater() {
        observable = Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(final Subscriber<? super T> subscriber) {
                onNewThread(new NewThreadCallBack<T>() {
                    @Override
                    public void onSuccess(T t) {
                        if (t == null) {
                            subscriber.onError(new Exception("Object is null"));
                            return;
                        }
                        subscriber.onNext(t);
                        subscriber.onCompleted();
                    }

                    @Override
                    public void onFail(String error) {
                        subscriber.onError(new Exception(error));
                    }

                    @Override
                    public void onFinish() {
                        subscriber.onCompleted();
                    }
                });
            }
        }).subscribeOn(Schedulers.newThread());
    }

    public void onMainThread(final CallBack<T> callBack) {
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<T>() {
                    @Override
                    public void onCompleted() {
                        if (callBack != null)
                            callBack.onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (callBack != null)
                            callBack.onError(e.getMessage());
                    }

                    @Override
                    public void onNext(T t) {
                        if (callBack != null) {
                            callBack.onNext(t);
                        }

                    }


                });
    }

    public abstract void onNewThread(NewThreadCallBack<T> callBack);


    public interface CallBack<T> {
        void onNext(T t);

        void onError(String exception);

        void onCompleted();
    }

    public interface NewThreadCallBack<T> {
        void onSuccess(T t);

        void onFail(String error);

        void onFinish();
    }

}
