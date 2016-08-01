package scut.userlogin.Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import scut.userlogin.CustomView.ButtonCheckBlank;
import scut.userlogin.CustomView.EditText_PassWordDisplay;
import scut.userlogin.R;

public class RegisterActivity3 extends AppCompatActivity implements View.OnClickListener{

    private EditText_PassWordDisplay et_PasswordRegisterInput;
    private ButtonCheckBlank btn_NextStep3;
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

        et_PasswordRegisterInput.setOnClickListener(this);
        btn_NextStep3.setOnClickListener(this);
    }

    private void initButton(){
        ArrayList<EditText> editTexts = new ArrayList<EditText>();
        editTexts.add(et_PasswordRegisterInput);
        btn_NextStep3.AddListeningEditTexts(editTexts);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_NextStep3:
            StartRegister4();
        }
    }

    private void StartRegister4(){
        Intent intent = new Intent(this,RegisterAcitvity4.class);
        intent.putExtra("PassWordInput",et_PasswordRegisterInput.getText().toString());
        startActivity(intent);
    }
}
