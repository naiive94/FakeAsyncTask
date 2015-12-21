package com.example.mytest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by wangzhe on 15/12/21.
 */
public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.text);

        new FakeAsyncTask<String, String, String>() {

            @Override
            protected String doInBackground(String params) {
                try {
                    Thread.sleep(6000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Log.i("tr","do in background");

                return "yes";
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                Log.i("tr","on post excute");
                textView.setText(s);
            }
        }.execute();
    }

    class myTask extends AsyncTask<String, Integer, String> {


        @Override
        protected String doInBackground(String... params) {
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

        }
    }


}
