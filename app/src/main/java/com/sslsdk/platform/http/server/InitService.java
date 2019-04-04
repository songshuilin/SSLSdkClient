package com.sslsdk.platform.http.server;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @program
 * @Desc
 * @Author 游戏人日常
 * @CreateTime 2019/04/04--15:47
 */
public interface InitService {

    @GET("init")
    Call <String>init();

}
