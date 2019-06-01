package com.sslsdk.platform.mvp.login;

import com.sslsdk.platform.domain.User;

import io.reactivex.Observable;


/**
 * @program
 * @Desc
 * @Author 游戏人日常
 * @CreateTime 2019/05/31--16:56
 */
public interface LoginInteractor {

    Observable<User> login(String username, String password);
}
