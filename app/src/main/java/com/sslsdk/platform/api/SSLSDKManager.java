package com.sslsdk.platform.api;

import android.content.Context;

import com.sslsdk.platform.listener.InitListener;
import com.sslsdk.platform.utils.HttpUtil;

/**
 * @program
 * @Desc
 * @Author 游戏人日常
 * @CreatrTime 2019/04/03--20:00
 */
public class SSLSDKManager {

    private Context mContext;

    private static SSLSDKManager manager;

    private SSLSDKManager() {
    }

    public static SSLSDKManager getInStance() {

        if (manager == null) {
            synchronized (SSLSDKManager.class) {
                if (manager == null) {
                    manager = new SSLSDKManager();

                }
            }
        }
        return manager;
    }


    /**
     *  初始化
     * @param mContext
     * @param gameId 游戏id 唯一
     * @param mSecretKey  加密key
     * @param initListener
     */
    public void init(Context mContext, String gameId, String mSecretKey,InitListener initListener) {

        this.mContext = mContext;






    }

}
