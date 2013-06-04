package com.zouqinghai.activity.menudrawer;

import com.zouqinghai.R;
import net.simonvt.menudrawer.MenuDrawer;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class LeftMenuActivity extends Activity {

    private MenuDrawer mMenuDrawer;
    private static final String STATE_CONTENT_TEXT = "net.simonvt.menudrawer.samples.ContentSample.contentText";

    private String mContentText;
    private TextView mContentTextView;
    
    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);

        if (state != null) {
            mContentText = state.getString(STATE_CONTENT_TEXT);
        }

        mMenuDrawer.setContentView(R.layout.activity_contentsample);
        mMenuDrawer.setTouchMode(MenuDrawer.TOUCH_MODE_FULLSCREEN);


        mContentTextView = (TextView) findViewById(R.id.contentText);
        mContentTextView.setText(mContentText);

        mMenuDrawer.setOnInterceptMoveEventListener(new MenuDrawer.OnInterceptMoveEventListener() {
            @Override
            public boolean isViewDraggable(View v, int dx, int x, int y) {
                return v instanceof SeekBar;
            }
        });
    }
}