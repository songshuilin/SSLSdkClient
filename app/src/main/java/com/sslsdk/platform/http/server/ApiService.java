package com.sslsdk.platform.http.server;

import com.google.gson.JsonObject;
import com.sslsdk.platform.domain.User;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.internal.operators.observable.ObservableError;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @program
 * @Desc
 * @Author 游戏人日常
 * @CreateTime 2019/04/04--15:47
 */
public interface ApiService {

    @GET("/init")
    Observable<JsonObject> init(@QueryMap Map<String ,String> map);


    @POST("/login")
    Observable<User> login(@Field("username") String username , @Field("password") String password);



}
