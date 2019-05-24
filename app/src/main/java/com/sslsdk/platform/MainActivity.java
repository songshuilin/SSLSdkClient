package com.sslsdk.platform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.sslsdk.platform.api.SSLSDKManager;
import com.sslsdk.platform.domain.User;
import com.sslsdk.platform.listener.InitListener;
import com.sslsdk.platform.listener.LoginListener;
import com.sslsdk.platform.utils.ResouceUtil;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private Button btn_init, btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ResouceUtil.getLayoutId(this,"activity_main"));
        initView();
        final Map <String,String> map=new HashMap<>();
        map.put("gid","122");
        map.put("debug","true");// true 开启调试模式  false  关闭

        btn_init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SSLSDKManager.getInStance().init(MainActivity.this, map, new InitListener() {
                    @Override
                    public void onInitSuccess() {
                        Toast.makeText(MainActivity.this,"onInitSuccess",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onInitFailed() {
                        Toast.makeText(MainActivity.this,"onInitFailed",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SSLSDKManager.getInStance().login(new LoginListener() {

                    @Override
                    public void onLoginSuccess(User user) {
                        //todo 登录成功
                    }

                    @Override
                    public void onLoginFailed(String msg) {
                        //todo 登录失败
                    }
                });
            }
        });

    }

    private void initView() {
        btn_init=findViewById(R.id.btn_init);
        btn_login=findViewById(R.id.btn_login);
    }
}
