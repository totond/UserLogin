package scut.userlogin.CustomView;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by yany on 2016/7/26.
 */
public class ButtonCheckPhonenumber extends Button  {
    private ArrayList<EditText> et_list;

    public ButtonCheckPhonenumber(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ButtonCheckPhonenumber(Context context) {
        super(context);
    }

    public ButtonCheckPhonenumber(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    //在这里传入editTexts数组并为它们绑定自定义TextWatcher监听内容里面的改变
    public void AddListeningEditTexts(ArrayList<EditText> editTexts){
        CheckBlank_TextWatcher mCheckBlank_TextWatcher = new CheckBlank_TextWatcher(this);
        setEnabled(false);
        et_list = editTexts;
        for (int i = 0; i < et_list.size(); i++){
            //将传入的EditText设置为只能输入数字并长度限定为11
            et_list.get(i).setFilters(new InputFilter[]{new InputFilter.LengthFilter(11)});
            et_list.get(i).setKeyListener(new DigitsKeyListener(false,true));
            et_list.get(i).addTextChangedListener(mCheckBlank_TextWatcher);
        }
    }

    //重写TextWatcher，监听操作写在里面
    private class CheckBlank_TextWatcher implements TextWatcher {
        private ButtonCheckPhonenumber mButtonCheckBlank;

        public  CheckBlank_TextWatcher(ButtonCheckPhonenumber buttonCheckBlank){
            mButtonCheckBlank = buttonCheckBlank;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            for (int i = 0; i < et_list.size(); i++){
                //判断列表里面的EditText是否长度11，是空就return，当所有都不是空的时候button就可以按下
                if (et_list.get(i).length() != 11){
                    mButtonCheckBlank.setEnabled(false);
                    return;
                }
            }
            mButtonCheckBlank.setEnabled(true);
        }
    }
}


