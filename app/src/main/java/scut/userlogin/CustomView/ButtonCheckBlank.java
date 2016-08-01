package scut.userlogin.CustomView;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by yany on 2016/7/24.
 */
public class ButtonCheckBlank extends Button {
    private ArrayList<EditText> et_list;

    //需要实现下面的几个构造函数，不然有可能加载不了这个控件
    public ButtonCheckBlank(Context context) {
        super(context);
    }

    public ButtonCheckBlank(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ButtonCheckBlank(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //在这里传入editTexts数组并为它们绑定自定义TextWatcher监听内容里面的改变
    public void AddListeningEditTexts(ArrayList<EditText> editTexts){
        CheckBlank_TextWatcher mCheckBlank_TextWatcher = new CheckBlank_TextWatcher(this);
        et_list = editTexts;
        setEnabled(false);
        for (int i = 0; i < et_list.size(); i++){
            et_list.get(i).addTextChangedListener(mCheckBlank_TextWatcher);
        }
    }

    //重写TextWatcher，监听操作写在里面
    private class CheckBlank_TextWatcher implements TextWatcher{
        private ButtonCheckBlank mButtonCheckBlank;

        public  CheckBlank_TextWatcher(ButtonCheckBlank buttonCheckBlank){
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
                //判断列表里面的EditText是否为空，是空就return，当所有都不是空的时候button就可以按下
                if (TextUtils.isEmpty(et_list.get(i).getText())){
                    mButtonCheckBlank.setEnabled(false);
                    return;
                }
            }
            mButtonCheckBlank.setEnabled(true);
        }
    }
}
