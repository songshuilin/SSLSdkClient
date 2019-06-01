package com.sslsdk.platform.http.utils;


import com.sslsdk.platform.http.server.ApiService;
import com.sslsdk.platform.utils.Constants;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @program
 * @Desc
 * @Author 游戏人日常
 * @CreateTime 2019/05/13--17:49
 */
public class ApiUtil {

    private static final String BASE_URL=Constants.BASE_URL;
    private static final String API_KEY=Constants.API_KEY;
    private static final int CONNECT_TIMEOUT=30;

    private static OkHttpClient okHttpClient =null;
    private static Retrofit retrofit =null;


    private ApiUtil(){}


    public static ApiService getApiService(){

        return getRetrofit().create(ApiService.class);
    }




    public  static Retrofit getRetrofit(){
        if (retrofit==null){
            initRetrofit();
        }
        return retrofit;
    }

    private static void initRetrofit() {

        if (okHttpClient==null){
            initOkHttp();
        }

        retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();

    }

    private static void initOkHttp() {
        HttpLoggingInterceptor loggingInterceptor =new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        RequestInterceptor requestInterceptor = new RequestInterceptor();

        okHttpClient =new OkHttpClient.Builder()
                        .callTimeout(CONNECT_TIMEOUT,TimeUnit.SECONDS)
                        .addInterceptor(loggingInterceptor)
                        .addInterceptor(requestInterceptor)
                        .build();

    }


    private static class RequestInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request original = chain.request();
            HttpUrl orignalHttpUrl = original.url();

            HttpUrl url = orignalHttpUrl.newBuilder()
                            .addQueryParameter("api_key",API_KEY)
                            .build();

            Request request = original.newBuilder().url(url).build();

            return chain.proceed(request);
        }
    }
}
