package scut.userlogin.Register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import scut.userlogin.CustomView.ButtonCheckPhonenumber;
import scut.userlogin.R;

public class RegisterActivity1 extends AppCompatActivity implements View.OnClickListener {

    private EditText et_PhoneNumberInput;
    private ButtonCheckPhonenumber btn_GetVerificationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register1);
        getSupportActionBar().hide();//隐藏掉整个ActionBar
        init();
        initButton();
    }

    private void init(){
        et_PhoneNumberInput = (EditText) findViewById(R.id.EditText_PhoneNumberInput);
        btn_GetVerificationCode = (ButtonCheckPhonenumber) findViewById(R.id.btn_GetVerificationCode);

        btn_GetVerificationCode.setOnClickListener(this);
    }

    private void initButton(){
        ArrayList<EditText> editTexts = new ArrayList<>();
        editTexts.add(et_PhoneNumberInput);
        btn_GetVerificationCode.AddListeningEditTexts(editTexts);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_GetVerificationCode:
                sendMessageRequest();
                StartRegister2();
                break;
        }
    }

    private void StartRegister2(){
        Intent intent = new Intent(this,RegisterActivity2.class);
        intent.putExtra("RegisterPhoneNumber",et_PhoneNumberInput.getText().toString());
        startActivity(intent);
    }

    private void sendMessageRequest(){

    }
}
