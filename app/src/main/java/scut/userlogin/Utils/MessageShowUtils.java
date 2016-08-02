package scut.userlogin.Utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by yany on 2016/7/23.
 */
public class MessageShowUtils {

    public static void ShowToast(Context context, String msg) {
        if (context != null && msg != null && !msg.equals("")) {
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
