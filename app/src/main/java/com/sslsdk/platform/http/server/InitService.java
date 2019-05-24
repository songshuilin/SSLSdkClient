package com.sslsdk.platform.http.server;

import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @program
 * @Desc
 * @Author 游戏人日常
 * @CreateTime 2019/04/04--15:47
 */
public interface InitService {


    @GET("init")
    Call <JsonObject>init(@QueryMap Map<String ,String> map);

}
