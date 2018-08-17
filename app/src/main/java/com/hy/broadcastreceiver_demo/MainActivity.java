package com.hy.broadcastreceiver_demo;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    MyBrocastReceiver receiver;
    LocalBroadcastManager mLocalBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocalBroadcastManager=LocalBroadcastManager.getInstance(this);
        /**
         * 动态注册广播
         */
//        receiver = new MyBrocastReceiver();
//        IntentFilter intentFilter=new IntentFilter();
//        intentFilter.addAction("com.hy.broadcastreceiver_demo.eat");
//        registerReceiver(receiver,intentFilter);

        /**
         * 注册应用内广播
         */
        receiver=new MyBrocastReceiver();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.hy.broadcastreceiver_demo.eat");
        mLocalBroadcastManager.registerReceiver(receiver,intentFilter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        unregisterReceiver(receiver);
        mLocalBroadcastManager.unregisterReceiver(receiver);
    }

    public void send(View view){
        Intent intent=new Intent();
        intent.setAction("com.hy.broadcastreceiver_demo.eat");
        sendBroadcast(intent);
    }

    public void sendOrder(View view){
        Intent intent=new Intent();
        intent.setAction("com.hy.broadcastreceiver_demo.eat");
        Bundle bundle=new Bundle();
        bundle.putString("msg","这是正确的广播信息");
        intent.putExtras(bundle);
        sendOrderedBroadcast(intent,null);
    }

    public void  sendLocal(View view){
        /**
         * 发送应用内广播
         */
        Intent intent=new Intent();
        intent.setAction("com.hy.broadcastreceiver_demo.eat");
        mLocalBroadcastManager.sendBroadcast(intent);
    }

}
