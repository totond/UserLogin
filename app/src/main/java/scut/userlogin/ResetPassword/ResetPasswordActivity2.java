package scut.userlogin.ResetPassword;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

import scut.userlogin.CustomView.ButtonCheckBlank;
import scut.userlogin.CustomView.ButtonWithCountDown;
import scut.userlogin.R;

public class ResetPasswordActivity2 extends AppCompatActivity implements View.OnClickListener{

    private EditText et_VerificationCodeInput;
    private ButtonWithCountDown btn_ReGetVerificationCode;
    private ButtonCheckBlank btn_NextStep;
    private ViewGroup layout_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password2);
        getSupportActionBar().hide();//隐藏掉整个ActionBar
        init();
        initButton();
        HandleCountDown();
    }

    private void init() {
        et_VerificationCodeInput = (EditText) findViewById(R.id.EditText_VerificationCodeInput);
        btn_ReGetVerificationCode = (ButtonWithCountDown) findViewById(R.id.btn_ReGetVerificationCode);
        btn_NextStep = (ButtonCheckBlank) findViewById(R.id.btn_NextStep2);
        layout_back = (ViewGroup) findViewById(R.id.layout_back);

        btn_ReGetVerificationCode.setOnClickListener(this);
        btn_NextStep.setOnClickListener(this);
        layout_back.setOnClickListener(this);
    }

    //处理倒计时
    private void HandleCountDown(){
        btn_ReGetVerificationCode.StartCountDown(10,"重发","s后重新发送");
    }

    //初始化自定义按钮
    private  void initButton(){
        ArrayList<EditText> editTexts = new ArrayList<EditText>();
        editTexts.add(et_VerificationCodeInput);
        btn_NextStep.AddListeningEditTexts(editTexts);
    }

    //定义按钮功能
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_NextStep2:
                StartRegister3();
                break;
            case R.id.btn_ReGetVerificationCode:
                HandleCountDown();
                break;
            case R.id.layout_back:
                finish();
                overridePendingTransition(R.anim.fade_in, R.anim.out_from_right);
                break;
        }

    }

    private void sendVerificationCodeMessage(){

    }

    //打开注册页面3
    private void StartRegister3(){
        startActivity(new Intent(this,ResetPasswordActivity3.class));
        overridePendingTransition(R.anim.in_from_right, R.anim.fade_out);
    }


}
