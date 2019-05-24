package com.sslsdk.platform.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.sslsdk.platform.R;
import com.sslsdk.platform.utils.ResouceUtil;

public class LoginActivity extends BaseActivity {

    private Button login_commit;
    private EditText et_login_username,et_login_password;
    private CheckBox auto_login_checkbox;
    private TextView login_forgetpwd,login_accountreg_btn,login_mobilereg_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ResouceUtil.getLayoutId(this,"activity_login"));
        initView();
    }


    @Override
    public void initView() {
        login_commit=findViewById(R.id.login_commit);
        et_login_password=findViewById(R.id.et_login_password);
        et_login_username=findViewById(R.id.et_login_username);
        auto_login_checkbox=findViewById(R.id.auto_login_checkbox);
        login_forgetpwd=findViewById(R.id.login_forgetpwd);
        login_accountreg_btn=findViewById(R.id.login_accountreg_btn);
        login_mobilereg_btn=findViewById(R.id.login_mobilereg_btn);
    }

}
