package com.sslsdk.platform.utils;

import android.text.TextUtils;
import android.util.Log;
import com.sslsdk.platform.constant.Constants;
import com.sslsdk.platform.http.server.InitService;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @program
 * @Desc   网络请求工具类
 * @Author 游戏人日常
 * @CreatrTime 2019/04/04--14:47
 */
public class HttpUtil {

    private  Retrofit retrofit;


    public  void get(String url , Map<String,String> map){

        if (TextUtils.isEmpty(url)){
            return;
        }

        //创建Retrofit对象
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(initClient())
                .build();

        InitService initService=retrofit.create(InitService.class);

        Call<String> data=initService.init();

        data.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e("sslsdk",response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable throwable) {
                Log.e("sslsdk",throwable.getLocalizedMessage());
            }
        });

    }

    /**
     * 获取 client
     * @return
     */
    private OkHttpClient initClient() {

        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.retryOnConnectionFailure(true);
        //设置链接时间一分钟
        builder.connectTimeout(1, TimeUnit.MINUTES);
        String proxyHost=System.getProperty("http.proxyHost");
        String proxyPort=System.getProperty("http.proxyPort");

        if(TextUtils.isEmpty(proxyHost)&&TextUtils.isEmpty(proxyPort)){
            // 设置代理
            Proxy proxy=new Proxy(Proxy.Type.HTTP,new InetSocketAddress(proxyHost,Integer.parseInt(proxyPort)));
            builder.proxy(proxy);
        }

      return builder.build();

    }

}
