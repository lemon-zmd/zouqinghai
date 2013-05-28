package com.zouqinghai.activity.common;

import android.app.Activity;
import android.content.Intent;

import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.IntentAction;
import com.zouqinghai.R;
import com.zouqinghai.activity.ViewActivity;
import com.zouqinghai.activity.common.roundlist.MainActivity;

public final class ActionUtil {
    private ActionUtil(){}

    public final static void initActionBar(Activity curActivity, String curTitle){
        final ActionBar actionBar = (ActionBar) curActivity.findViewById(R.id.actionbar);
        //actionBar.setHomeAction(new IntentAction(this, createIntent(this), R.drawable.ic_title_home_demo));
        actionBar.setTitle(curTitle);
        actionBar.setHomeAction(new IntentAction(curActivity, ViewActivity.createIntent(curActivity), R.drawable.ic_title_home_default));
        actionBar.setDisplayHomeAsUpEnabled(false);

        final Action shareAction = new IntentAction(curActivity, createShareIntent(), R.drawable.ic_title_share_default);
        actionBar.addAction(shareAction);
        final Action otherAction = new IntentAction(curActivity, new Intent(curActivity, MainActivity.class), R.drawable.ic_title_export_default);
        actionBar.addAction(otherAction);
    }
    
    private static Intent createShareIntent() {
        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "zouqinghai");
        return Intent.createChooser(intent, "Share");
    }
}
