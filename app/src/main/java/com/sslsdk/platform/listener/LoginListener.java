package com.sslsdk.platform.listener;

import com.sslsdk.platform.domain.User;

/**
 * @program
 * @Desc
 * @Author 游戏人日常
 * @CreatrTime 2019/04/04--11:44
 */
public interface LoginListener {

    /** 登录成功  */
    public void onLoginSuccess(User user);
    /** 登录失败*/
    public void onLoginFailed(String msg);
}
