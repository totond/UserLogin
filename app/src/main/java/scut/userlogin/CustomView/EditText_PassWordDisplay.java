package scut.userlogin.CustomView;

import android.content.Context;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by yany on 2016/7/23.
 */
public class EditText_PassWordDisplay extends EditText implements View.OnTouchListener {
    private boolean PassWord_Hide = false;

    //需要实现下面的几个构造函数，不然有可能加载不了这个EditText控件
    public EditText_PassWordDisplay(Context context) {
        super(context);
        init();
    }

    public EditText_PassWordDisplay(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public EditText_PassWordDisplay(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    //初始化控件，绑定监听器
    public void init(){
        setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //如果不是按下操作，就不做处理，如果是按下操作但是没有图片，也不做处理
        if (event.getAction() == MotionEvent.ACTION_UP && this.getCompoundDrawables()[2] != null) {
            //检测点击区域的X坐标是否在图片范围内
            if (event.getX() > this.getWidth()
                    - this.getPaddingRight()
                    - this.getCompoundDrawables()[2].getIntrinsicWidth()) {

                //在此做图片的点击处理
                if(PassWord_Hide){
                    //隐藏密码
                    setTransformationMethod(PasswordTransformationMethod.getInstance());
                    System.out.println("Hide ?"+PassWord_Hide);
                    PassWord_Hide = false;
                }else{
                    //显示密码
                    setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    System.out.println("Hide ?"+PassWord_Hide);
                    PassWord_Hide = true;
                }

            }
            return false;
        }
        return false;
    }
}
