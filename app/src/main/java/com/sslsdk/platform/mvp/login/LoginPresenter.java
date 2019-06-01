package com.sslsdk.platform.mvp.login;

/**
 * @program
 * @Desc
 * @Author 游戏人日常
 * @CreateTime 2019/05/31--16:25
 */
public interface LoginPresenter {

    void setView(LoginView view);

    void destory();

    void login(String username, String password);

}
