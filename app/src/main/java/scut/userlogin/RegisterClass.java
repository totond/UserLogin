package scut.userlogin;

import android.os.Handler;
import android.widget.Button;

import java.util.TimerTask;

/**
 * 用于处理注册功能的类：目前有按钮计时器功能函数TimerVerificationButton
 */
public class RegisterClass {

    private int counter;            //倒计时计数

    public void TimerVerificationButton(final Button button, final Handler handler,int count){
        button.setEnabled(false);
        counter = count;
        Runnable runnable = new Runnable() {

            public void run ( ) {

                    button.setText(String.valueOf(--counter));
                    System.out.println("couter:"+counter);
                if (counter != 0) {
                    handler.postDelayed(this, 1000);     //postDelayed(this,1000)方法安排一个Runnable对象到主线程队列中
                }else {
                    button.setText("重新发送");
                    button.setEnabled(true);
                }
            }

        };
        button.setText(String.valueOf(counter));
        handler.postDelayed(runnable,1000);
        System.out.println(counter);

    }


}
