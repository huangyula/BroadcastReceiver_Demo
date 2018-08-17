package com.hy.broadcastreceiver_demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 自定义广播接收者BroadcastReceiver
 */

public class MyBrocastReceiver extends BroadcastReceiver{
    private String TAG="MyBrocastReceiver";

    //接收到广播后的操作
    @Override
    public void onReceive(Context context, Intent intent) {
         Log.i(TAG,"onReceive"+"接收到广播啦:"+intent.getStringExtra("msg"));
    }




}
