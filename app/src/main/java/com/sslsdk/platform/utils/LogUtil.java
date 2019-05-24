package com.sslsdk.platform.utils;

import android.util.Log;

import com.sslsdk.platform.constant.Constants;

/**
 * @program
 * @Desc
 * @Author 游戏人日常
 * @CreateTime 2019/05/10--17:26
 */
public class LogUtil  {

    public static  boolean logEnable=false;



    public  static  void e(String mes)
    {
        if (logEnable){
            Log.e(Constants.SDK_TAG,mes);
        }

    }

    public  static  void i(String mes)
    {
        if (logEnable){
            Log.i(Constants.SDK_TAG,mes);
        }

    }

    public  static  void w(String mes)
    {
        if (logEnable){
            Log.w(Constants.SDK_TAG,mes);
        }

    }

    public  static  void d(String mes)
    {
        if (logEnable){
            Log.d(Constants.SDK_TAG,mes);
        }

    }

    public  static  void v(String mes)
    {
        if (logEnable){
            Log.v(Constants.SDK_TAG,mes);
        }

    }

    public  static  void wtf(String mes)
    {
        if (logEnable){
            Log.wtf(Constants.SDK_TAG,mes);
        }

    }

}
