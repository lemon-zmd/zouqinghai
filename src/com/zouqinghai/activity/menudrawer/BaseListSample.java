package com.zouqinghai.activity.menudrawer;

import net.simonvt.menudrawer.MenuDrawer;
import net.simonvt.menudrawer.Position;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.zouqinghai.R;

//public abstract class BaseListSample extends FragmentActivity implements MenuAdapter.MenuListener {
public abstract class BaseListSample extends Activity implements MenuAdapter.MenuListener {

    private static final String STATE_ACTIVE_POSITION = "net.simonvt.menudrawer.samples.ContentSample.activePosition";

    protected MenuDrawer mMenuDrawer;

    protected MenuAdapter mAdapter;
    protected ListView mList;

    private int mActivePosition = 0;

    @Override
    protected void onCreate(Bundle inState) {
        super.onCreate(inState);
        // remove title bar 
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        if (inState != null) {
            mActivePosition = inState.getInt(STATE_ACTIVE_POSITION);
        }

        mMenuDrawer = MenuDrawer.attach(this, getDragMode(), getDrawerPosition());

        List<Object> items = new ArrayList<Object>();
        items.add(new Item("Item 1", R.drawable.ic_action_refresh_dark));
        items.add(new Item("Item 2", R.drawable.ic_action_select_all_dark));
        items.add(new Category("Cat 1"));
        items.add(new Item("Item 3", R.drawable.ic_action_refresh_dark));
        items.add(new Item("Item 4", R.drawable.ic_action_select_all_dark));
        items.add(new Category("Cat 2"));
        items.add(new Item("Item 5", R.drawable.ic_action_refresh_dark));
        items.add(new Item("Item 6", R.drawable.ic_action_select_all_dark));
        items.add(new Category("Cat 3"));
        items.add(new Item("Item 7", R.drawable.ic_action_refresh_dark));
        items.add(new Item("Item 8", R.drawable.ic_action_select_all_dark));
        items.add(new Category("Cat 4"));
        items.add(new Item("Item 9", R.drawable.ic_action_refresh_dark));
        items.add(new Item("Item 10", R.drawable.ic_action_select_all_dark));

        mList = new ListView(this);

        mAdapter = new MenuAdapter(this, items);
        mAdapter.setListener(this);
        mAdapter.setActivePosition(mActivePosition);

        Button addBtn = new Button(this);
        addBtn.setText("加一条");
        mList.addHeaderView(addBtn);

        mList.setAdapter(mAdapter);
        mList.setOnItemClickListener(mItemClickListener);
        // 去除拖动背景色.
        mList.setCacheColorHint(0);
        mMenuDrawer.setMenuView(mList);
    }

    protected abstract void onMenuItemClicked(int position, Item item);

    protected abstract int getDragMode();

    protected abstract Position getDrawerPosition();

    private AdapterView.OnItemClickListener mItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            mActivePosition = position;
            mMenuDrawer.setActiveView(view, position);
            mAdapter.setActivePosition(position);
            onMenuItemClicked(position, (Item) mAdapter.getItem(position));
        }
    };

    // @Override
    // protected void onSaveInstanceState(Bundle outState) {
    // super.onSaveInstanceState(outState);
    // outState.putInt(STATE_ACTIVE_POSITION, mActivePosition);
    // }

    @Override
    public void onActiveViewChanged(View v) {
        mMenuDrawer.setActiveView(v, mActivePosition);
    }
}
