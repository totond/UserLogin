package scut.userlogin.ResetPassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import scut.userlogin.CustomView.ButtonCheckBlank;
import scut.userlogin.CustomView.EditText_PassWordDisplay;
import scut.userlogin.R;

public class ResetPasswordActivity3 extends AppCompatActivity implements View.OnClickListener{

    private EditText_PassWordDisplay et_PasswordResetInput;
    private ButtonCheckBlank btn_NextStep3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password3);
        getSupportActionBar().hide();//隐藏掉整个ActionBar
        init();
        initButton();
    }

    private void init(){
        et_PasswordResetInput = (EditText_PassWordDisplay) findViewById(R.id.EditText_PasswordResetInput);
        btn_NextStep3 = (ButtonCheckBlank) findViewById(R.id.btn_NextStep3);

        et_PasswordResetInput.setOnClickListener(this);
        btn_NextStep3.setOnClickListener(this);
    }

    private void initButton(){
        ArrayList<EditText> editTexts = new ArrayList<EditText>();
        editTexts.add(et_PasswordResetInput);
        btn_NextStep3.AddListeningEditTexts(editTexts);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_NextStep3:
                StartLoginSucess();
                break;
        }
    }

    private void StartLoginSucess(){

    }
}
