package com.zouqinghai.activity.menudrawer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.zouqinghai.R;
import com.zouqinghai.activity.common.ActionUtil;

public class ContentSample extends BaseListSample {

    private static final String STATE_CONTENT_TEXT = "net.simonvt.menudrawer.samples.ContentSample.contentText";

    private String mContentText;
    private TextView mContentTextView;

    @Override
    protected void onCreate(Bundle inState) {
        super.onCreate(inState);

        if (inState != null) {
            mContentText = inState.getString(STATE_CONTENT_TEXT);
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

        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setAdapter(initListData());

        // add action bar.
        ActionUtil.initActionBar(this, "我的行程");
    }

    @Override
    protected void onMenuItemClicked(int position, Item item) {
        mContentTextView.setText(item.mTitle);
        mMenuDrawer.closeMenu();
    }

    @Override
    protected int getDragMode() {
        return MenuDrawer.MENU_DRAG_CONTENT;
    }

    @Override
    protected Position getDrawerPosition() {
        return Position.LEFT;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_CONTENT_TEXT, mContentText);
    }

    @Override
    public void onBackPressed() {
        final int drawerState = mMenuDrawer.getDrawerState();
        if (drawerState == MenuDrawer.STATE_OPEN || drawerState == MenuDrawer.STATE_OPENING) {
            mMenuDrawer.closeMenu();
            return;
        }

        super.onBackPressed();
    }

    /**
     * init the adapter.
     * 
     * @return
     */
    private SimpleAdapter initListData() {
        final String PIC_URL = "pic_url";
        final String VIEW_INTRO = "view_intro";
        final int[] pic_arrays = { R.drawable.view_1, R.drawable.view_2, R.drawable.view_3, R.drawable.view_4,
                R.drawable.view_5 };
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> data = new HashMap<String, Object>();
            data.put(PIC_URL, pic_arrays[i % 5]);
            data.put(VIEW_INTRO, "xining_" + i);
            listItems.add(data);
        }
        SimpleAdapter sa = new SimpleAdapter(this, listItems, R.layout.view_item, new String[] { PIC_URL, VIEW_INTRO },
                new int[] { R.id.view_pic, R.id.view_intro });
        return sa;
    }
}
