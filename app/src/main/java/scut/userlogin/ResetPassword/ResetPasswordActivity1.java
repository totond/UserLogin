package scut.userlogin.ResetPassword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import scut.userlogin.CustomView.ButtonCheckPhonenumber;
import scut.userlogin.R;

public class ResetPasswordActivity1 extends AppCompatActivity implements View.OnClickListener {

    private EditText et_PhoneNumberInput;
    private ButtonCheckPhonenumber btn_GetVerificationCode;
    private ViewGroup layout_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password1);
        getSupportActionBar().hide();//隐藏掉整个ActionBar
        init();
        initButton();
    }

    private void init(){
        et_PhoneNumberInput = (EditText) findViewById(R.id.EditText_PhoneNumberInput);
        btn_GetVerificationCode = (ButtonCheckPhonenumber) findViewById(R.id.btn_GetVerificationCode);
        layout_back = (ViewGroup) findViewById(R.id.layout_back);

        btn_GetVerificationCode.setOnClickListener(this);
        layout_back.setOnClickListener(this);
    }

    //初始化自定义按钮
    private void initButton(){
        ArrayList<EditText> editTexts = new ArrayList<>();
        editTexts.add(et_PhoneNumberInput);
        btn_GetVerificationCode.AddListeningEditTexts(editTexts);
    }

    //定义按钮功能
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_GetVerificationCode:
                StartReset2();
                break;
            case R.id.layout_back:
                finish();
                overridePendingTransition(R.anim.fade_in, R.anim.out_from_right);
                break;
        }
    }

    //打开重置密码页面2
    private void StartReset2(){
        Intent intent = new Intent(this,ResetPasswordActivity2.class);
        intent.putExtra("ResetPhoneNumber",et_PhoneNumberInput.getText().toString());
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.fade_out);
    }

    private void sendMessageRequest(){

    }
}
