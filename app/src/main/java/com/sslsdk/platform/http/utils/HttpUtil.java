package com.sslsdk.platform.http.utils;

import com.google.gson.JsonObject;
import com.sslsdk.platform.http.server.InitService;
import com.sslsdk.platform.listener.InitListener;
import com.sslsdk.platform.utils.LogUtil;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @program
 * @Desc   网络请求工具类
 * @Author 游戏人日常
 * @CreatrTime 2019/04/04--14:47
 */
public class HttpUtil {


    private  static HttpUtil httpUtil;

    private  HttpUtil(){}

    public  static  HttpUtil getInstance(){

        if (httpUtil==null){
            synchronized (HttpUtil.class){
                if (httpUtil==null){
                    httpUtil=new HttpUtil();
                }
            }
        }

        return httpUtil;
    }




    public  void get(Map<String,String> map, final InitListener initListener){

        if (map.isEmpty()){
            LogUtil.i("map 为 null");
            return;
        }

        InitService initService=RetrofitUtil.getRetrofit().create(InitService.class);

        Call<JsonObject> data=initService.init(map);

        data.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                LogUtil.i(response.body().toString());
                initListener.onInitSuccess();
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable throwable) {
                LogUtil.i(throwable.getLocalizedMessage());
                initListener.onInitFailed();
            }
        });

    }



}
