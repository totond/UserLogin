package scut.userlogin.ResetPassword;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import scut.userlogin.CustomView.ButtonCheckBlank;
import scut.userlogin.CustomView.ButtonCheckPhonenumber;
import scut.userlogin.R;
import scut.userlogin.RegisterClass;

public class ResetPasswordActivity2 extends AppCompatActivity implements View.OnClickListener{

    private EditText et_VerificationCodeInput;
    private Button btn_ReGetVerificationCode;
    private ButtonCheckBlank btn_NextStep;
    private Handler handler;

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
        btn_ReGetVerificationCode = (Button) findViewById(R.id.btn_ReGetVerificationCode);
        btn_NextStep = (ButtonCheckBlank) findViewById(R.id.btn_NextStep2);

        btn_ReGetVerificationCode.setOnClickListener(this);
        btn_NextStep.setOnClickListener(this);
    }

    private void HandleCountDown(){
        RegisterClass registerClass = new RegisterClass();
        handler = new Handler();
        //使用注册功能类里面的按钮计时器
        registerClass.TimerVerificationButton(btn_ReGetVerificationCode,handler,10);
    }

    private  void initButton(){
        ArrayList<EditText> editTexts = new ArrayList<EditText>();
        editTexts.add(et_VerificationCodeInput);
        btn_NextStep.AddListeningEditTexts(editTexts);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_NextStep2:
                StartRegister3();
                break;
            case R.id.btn_ReGetVerificationCode:
                HandleCountDown();
                break;
        }

    }

    private void sendVerificationCodeMessage(){

    }

    private void StartRegister3(){
        startActivity(new Intent(this,ResetPasswordActivity3.class));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!(handler == null)){
            handler.removeCallbacksAndMessages(null);
            System.out.println("handler close!");
        }
    }
}
