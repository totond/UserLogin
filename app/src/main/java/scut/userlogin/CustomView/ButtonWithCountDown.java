package scut.userlogin.CustomView;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * 一个实现倒计时功能的Button，类似于xx秒后重发短信的按钮，要等到倒计时结束才能按下
 */
public class ButtonWithCountDown extends Button{
    private int counter;
    //使用Handler的延时POST实现计时，这里先初始化
    private Handler mhandler = new Handler();

    //需要实现下面的几个构造函数，不然有可能加载出错
    public ButtonWithCountDown(Context context) {
        super(context);
    }

    public ButtonWithCountDown(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ButtonWithCountDown(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //调用此函数使倒计时开始
    public void StartCountDown(int countTime, final String endingString, final String runningString){
        setEnabled(false);
        counter = countTime;
        Runnable runnable = new Runnable() {
            public void run ( ) {
                setText(String.valueOf(--counter) + runningString);
                System.out.println("couter:"+counter);
                if (counter != 0) {
                    mhandler.postDelayed(this, 1000);     //postDelayed(this,1000)方法安排一个Runnable对象到主线程队列中
                }else {
                    setText(endingString);
                    setEnabled(true);
                }
            }
        };
        setText(counter + runningString);
        //这里才是开始执行计时
        mhandler.postDelayed(runnable,1000);
    }


    //在View销毁的时候释放Handler引用，防止内存泄漏
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (!(mhandler == null)){
            mhandler.removeCallbacksAndMessages(null);
            System.out.println("handler close!");
        }
    }
}
