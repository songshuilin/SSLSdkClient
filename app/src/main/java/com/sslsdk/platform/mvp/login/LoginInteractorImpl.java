package com.sslsdk.platform.mvp.login;

import com.sslsdk.platform.domain.User;
import com.sslsdk.platform.http.server.ApiService;
import com.sslsdk.platform.http.utils.ApiUtil;

import io.reactivex.Observable;

/**
 * @program
 * @Desc
 * @Author 游戏人日常
 * @CreateTime 2019/05/31--17:01
 */
public class LoginInteractorImpl implements  LoginInteractor {

    private ApiService apiService;

    public  LoginInteractorImpl(){
        apiService= ApiUtil.getApiService();
    }

    @Override
    public Observable<User> login(String username, String password) {

        return apiService.login(username,password).map(User::getUser);
    }
}
