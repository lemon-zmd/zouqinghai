package com.zouqinghai.activity.common;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.ProgressDialog;

public class Utils {
    private Utils() {
    }
    public static ProgressDialog loadProgressDialog(Activity context) {
        ProgressDialog dialog = ProgressDialog.show(context, "...", 
                "Loading. Please wait...", true);
        return dialog;
    }
    public static void dismissDialogWithDelay(final ProgressDialog dialog, long delay, final DialogListener listener) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                dialog.dismiss();
                listener.action();
            }
            
        }, delay);
    }

    public interface DialogListener {
        void action();
    }
}
