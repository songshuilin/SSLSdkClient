package com.sslsdk.platform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sslsdk.platform.api.SSLSDKManager;
import com.sslsdk.platform.listener.InitListener;

public class MainActivity extends AppCompatActivity {

    private Button btn_init, btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        btn_init.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SSLSDKManager.getInStance().init(MainActivity.this, "123", "123", new InitListener() {
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

            }
        });

    }

    private void initView() {
        btn_init=findViewById(R.id.btn_init);
        btn_login=findViewById(R.id.btn_login);
    }
}
