package scut.userlogin;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import scut.userlogin.CustomView.ButtonCheckBlank;
import scut.userlogin.CustomView.EditText_PassWordDisplay;
import scut.userlogin.Register.RegisterActivity1;
import scut.userlogin.ResetPassword.ResetPasswordActivity1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_Register,tv_ForgetPassword;
    private EditText et_UserName;
    private EditText_PassWordDisplay et_Password;
    private ButtonCheckBlank btn_Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();//隐藏掉整个ActionBar
        init();
        initButton();
    }

    public void init(){
        tv_Register = (TextView) findViewById(R.id.TextView_Register);
        tv_ForgetPassword = (TextView) findViewById(R.id.TextView_ForgetPassword);
        et_UserName = (EditText) findViewById(R.id.EditText_UserName);
        et_Password = (EditText_PassWordDisplay) findViewById(R.id.EditText_Password);
        btn_Login = (ButtonCheckBlank) findViewById(R.id.btn_Login);

        tv_ForgetPassword.setOnClickListener(this);
        tv_Register.setOnClickListener(this);
        btn_Login.setOnClickListener(this);
    }

    private void initButton(){
        ArrayList<EditText> editTexts = new ArrayList<EditText>();
        editTexts.add(et_UserName);
        editTexts.add(et_Password);

        btn_Login.AddListeningEditTexts(editTexts);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.TextView_Register:
                startActivity(new Intent(this,RegisterActivity1.class));
                break;
            case R.id.TextView_ForgetPassword:
                startActivity(new Intent(this,ResetPasswordActivity1.class));
                break;
            case R.id.btn_Login:
                startActivity(new Intent(this,LoginSuccessfullyActivity.class));
                break;
        }

    }

}
