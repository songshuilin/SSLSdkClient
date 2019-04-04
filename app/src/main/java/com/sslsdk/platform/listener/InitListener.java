package com.sslsdk.platform.listener;

/**
 * @program
 * @Desc
 * @Author 游戏人日常
 * @CreatrTime 2019/04/04--11:44
 */
public interface InitListener {

    /** 初始化成功  */
    public void onInitSuccess();
    /** 初始化失败*/
    public void onInitFailed();
}
