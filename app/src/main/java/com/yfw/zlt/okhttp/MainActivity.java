package com.yfw.zlt.okhttp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yfw.zlt.okhttp.okhttputil.LogUtils;
import com.yfw.zlt.okhttp.okhttputil.OkHttpUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button get,post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get= (Button) findViewById(R.id.get);
        post= (Button) findViewById(R.id.post);
        get.setOnClickListener(this);
        post.setOnClickListener(this);

    }
    private void getGet(){
        String url="http://service.test.xgo.com.cn:8080/app/v1/demo/1";
        OkHttpUtils.ResultCallback<String> resultCallback = new OkHttpUtils.ResultCallback<String>() {

            @Override
            public void onSuccess(String response) {
                LogUtils.i("ii","111111111:"+response);
            }

            @Override
            public void onFailure(Exception e) {
                LogUtils.i("ii","222222222:"+e);
            }
        };
        OkHttpUtils.get(url,resultCallback);

    }
    private void getPost(){
        String url="http://service.test.xgo.com.cn:8080/app/v1/demo/";
        HashMap params=new HashMap();
        params.put("name", "Zeus");
        OkHttpUtils.ResultCallback<String> resultCallback = new OkHttpUtils.ResultCallback<String>() {

            @Override
            public void onSuccess(String response) {
                LogUtils.i("ii","2:111111111:"+response);
            }

            @Override
            public void onFailure(Exception e) {
                LogUtils.i("ii","2:222222222:"+e);
            }
        };
        OkHttpUtils.post(url,resultCallback,params);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.get){
            getGet();
        }else if(v.getId()==R.id.post){
            getPost();
        }
    }
}
