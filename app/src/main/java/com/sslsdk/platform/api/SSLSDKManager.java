package com.sslsdk.platform.api;

import android.content.Context;
import android.content.Intent;
import com.sslsdk.platform.mvp.login.LoginActivity;
import com.sslsdk.platform.listener.InitListener;
import com.sslsdk.platform.listener.LoginListener;
import com.sslsdk.platform.http.utils.HttpUtil;
import com.sslsdk.platform.utils.LogUtil;
import java.util.Map;

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
     * 初始化
     * @param mContext
     * @param map    String gameId, String mSecretKey
     * @param initListener
     */
    public void init(Context mContext, Map<String,String> map, InitListener initListener) {

        this.mContext = mContext;
        //todo  这里可以统计下数据

        //true 打开日志  false 相反
        LogUtil.logEnable=map.get("debug").equals("true")?true : false;
        HttpUtil.getInstance().get(map,initListener);
    }


    /**
     * 登录
     * @param loginListener
     */
    public void  login(LoginListener loginListener){

        Intent intent=new Intent(mContext, LoginActivity.class);
        mContext.startActivity(intent);

    }

}
