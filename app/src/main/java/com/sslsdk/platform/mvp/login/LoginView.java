package com.sslsdk.platform.mvp.login;


import android.service.autofill.UserData;

import com.sslsdk.platform.domain.User;

/**
 * @program
 * @Desc
 * @Author 游戏人日常
 * @CreateTime 2019/05/31--16:21
 */
public interface LoginView {

    void loginSuccess(User user);

    void loginFail(String error);

    void showLoading();

    void hideLoading();
}
