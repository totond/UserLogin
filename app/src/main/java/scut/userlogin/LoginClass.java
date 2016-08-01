package scut.userlogin;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by yany on 2016/7/21.
 */
public class LoginClass {
    private String username;
    private String password;

    public static boolean isMobileNO(String mobiles) {
    /*
    移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、180、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String telRegex = "[1][358]\\d{9}";//"[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) return false;
        else return mobiles.matches(telRegex);
    }

    public  boolean CheckIsPhoneNumber(EditText editText){
        editText.addTextChangedListener(new CheckPhoneNumberListener(editText));
        return false;
    }

    public class CheckPhoneNumberListener implements TextWatcher{

        private EditText meditText;
        public CheckPhoneNumberListener(EditText meditText){
            this.meditText = meditText;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            //EditText里面内容变化之后执行的操作
            if(isMobileNO(meditText.getText().toString())){

            }
        }
    }
}
