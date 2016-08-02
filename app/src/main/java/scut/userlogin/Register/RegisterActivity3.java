package scut.userlogin.Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import scut.userlogin.CustomView.ButtonCheckBlank;
import scut.userlogin.CustomView.EditText_PassWordDisplay;
import scut.userlogin.R;

public class RegisterActivity3 extends AppCompatActivity implements View.OnClickListener{

    private EditText_PassWordDisplay et_PasswordRegisterInput;
    private ButtonCheckBlank btn_NextStep3;
    private ViewGroup layout_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);
        getSupportActionBar().hide();//隐藏掉整个ActionBar
        init();
        initButton();
    }

    private void init(){
        et_PasswordRegisterInput = (EditText_PassWordDisplay) findViewById(R.id.EditText_PasswordRegisterInput);
        btn_NextStep3 = (ButtonCheckBlank) findViewById(R.id.btn_NextStep3);
        layout_back = (ViewGroup) findViewById(R.id.layout_back);

        et_PasswordRegisterInput.setOnClickListener(this);
        btn_NextStep3.setOnClickListener(this);
        layout_back.setOnClickListener(this);
    }

    //初始化自定义按钮
    private void initButton(){
        ArrayList<EditText> editTexts = new ArrayList<EditText>();
        editTexts.add(et_PasswordRegisterInput);
        btn_NextStep3.AddListeningEditTexts(editTexts);
    }

    //定义按钮功能
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_NextStep3:
                StartRegister4();
                break;
            case R.id.layout_back:
                finish();
                overridePendingTransition(R.anim.fade_in, R.anim.out_from_right);
                break;
        }
    }

    //打开注册页面4
    private void StartRegister4(){
        Intent intent = new Intent(this,RegisterAcitvity4.class);
        intent.putExtra("PassWordInput",et_PasswordRegisterInput.getText().toString());
        startActivity(intent);
        overridePendingTransition(R.anim.in_from_right, R.anim.fade_out);
    }
}
