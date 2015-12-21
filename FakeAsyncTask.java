package com.example.mytest;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by myth on 15/12/21.
 */
public abstract class FakeAsyncTask<P, G, R> extends Thread {

    Handler handler;
    Handler foreHandler;
    Runnable runnable;
    Runnable foreRunnable;

    R s;

    public FakeAsyncTask() {
        runnable = new Runnable() {
            @Override
            public void run() {
                s = doInBackground(null);
                foreHandler.post(foreRunnable);
            }
        };
        foreRunnable = new Runnable() {
            @Override
            public void run() {
                onPostExecute(s);
            }
        };
    }

    @Override
    public void run() {
        super.run();

        Looper.prepare();

        handler = new Handler();
        foreHandler = new Handler(Looper.getMainLooper());

        handler.post(runnable);

        Looper.loop();
    }

    protected abstract R doInBackground(P params);

    protected void onPostExecute(R s) {
    }

    public void execute() {
        this.start();
    }
}
