package com.sslsdk.platform.http.utils;

import android.text.TextUtils;
import com.sslsdk.platform.constant.Constants;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @program
 * @Desc
 * @Author 游戏人日常
 * @CreateTime 2019/05/13--17:49
 */
public class RetrofitUtil {

    private static Retrofit retrofit ;

    private RetrofitUtil(){}


    public  static Retrofit getRetrofit(){
        if (retrofit==null){
            synchronized (RetrofitUtil.class){
                if (retrofit==null){
                    retrofit=new Retrofit.Builder()
                            .baseUrl(Constants.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(initClient())
                            .build();
                }
            }
        }
        return retrofit;
    }

    /**
     * 获取 client
     * @return
     */
    private static OkHttpClient initClient() {

        OkHttpClient.Builder builder=new OkHttpClient.Builder();
        builder.retryOnConnectionFailure(true);
        //设置链接时间一分钟
        builder.connectTimeout(1, TimeUnit.MINUTES);
        String proxyHost=System.getProperty("http.proxyHost");
        String proxyPort=System.getProperty("http.proxyPort");

        if(!TextUtils.isEmpty(proxyHost)&&!TextUtils.isEmpty(proxyPort)){
            // 设置代理
            Proxy proxy=new Proxy(Proxy.Type.HTTP,new InetSocketAddress(proxyHost,Integer.parseInt(proxyPort)));
            builder.proxy(proxy);
        }

        return builder.build();

    }
}
