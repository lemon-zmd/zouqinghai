package com.zouqinghai.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ext.SatelliteMenu;
import android.view.ext.SatelliteMenuItem;
import android.view.ext.SatelliteMenu.SateliteClickedListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.IntentAction;
import com.zouqinghai.R;
import com.zouqinghai.activity.common.Utils;
import com.zouqinghai.activity.menudrawer.ContentSample;

/**
 * 景点页.
 * 
 * @author lemon
 * 
 */
public class ViewActivity extends ListActivity {
    private final String PIC_URL = "pic_url";
    private final String VIEW_INTRO = "view_intro";

    /**
     * create the view.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        initActionBar();

        initEventListen();
        initSatelliteMenu();
        // add adapter to list view.
        ListView lv = (ListView) findViewById(android.R.id.list);
        lv.setAdapter(initListData());
    }

    private void initEventListen() {
        final ListView lv = this.getListView();
        lv.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Utils.dismissDialogWithDelay(Utils.loadProgressDialog(ViewActivity.this), 1000l,
                        new Utils.DialogListener() {
                            @Override
                            public void action() {
                                Intent toSpot = new Intent(ViewActivity.this, ViewSpotActivity.class);
                                startActivity(toSpot);
                            }
                        });                // go to spot view.

            }
        });
    }

    /**
     * init the adapter.
     * 
     * @return
     */
    private SimpleAdapter initListData() {
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

    private void initActionBar() {
        final ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        // actionBar.setHomeAction(new IntentAction(this, createIntent(this),
        // R.drawable.ic_title_home_demo));
        actionBar.setTitle("景点");

        actionBar.setHomeAction(new IntentAction(this, ViewActivity.createIntent(this),
                R.drawable.ic_title_home_default));
        actionBar.setDisplayHomeAsUpEnabled(false);

        final Action shareAction = new IntentAction(this, createShareIntent(), R.drawable.ic_title_share_default);
        actionBar.addAction(shareAction);
        // final Action otherAction = new IntentAction(this, new Intent(this,
        // MainActivity.class), R.drawable.ic_title_export_default);
        final Action otherAction = new IntentAction(this, new Intent(this, ContentSample.class),
                R.drawable.ic_title_export_default);
        actionBar.addAction(otherAction);
    }

    public static Intent createIntent(Context context) {
        Intent i = new Intent(context, ViewActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return i;
    }

    private Intent createShareIntent() {
        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "zouqinghai");
        return Intent.createChooser(intent, "Share");
    }

    /**
     * initialize the satellite menu.
     */
    private void initSatelliteMenu() {
        SatelliteMenu menu = (SatelliteMenu) findViewById(R.id.menu);
        // set some props for the menu.
        menu.setSatelliteDistance(170);
        menu.setTotalSpacingDegree(90);
        menu.setCloseItemsOnClick(true);
        menu.setExpandDuration(500);

        List<SatelliteMenuItem> items = new ArrayList<SatelliteMenuItem>();
        items.add(new SatelliteMenuItem(1, R.drawable.ic_1));
        items.add(new SatelliteMenuItem(2, R.drawable.ic_3));
        items.add(new SatelliteMenuItem(3, R.drawable.ic_4));
        // items.add(new SatelliteMenuItem(3, R.drawable.ic_5));
        // items.add(new SatelliteMenuItem(2, R.drawable.ic_6));
        // items.add(new SatelliteMenuItem(1, R.drawable.ic_2));
        menu.addItems(items);
        menu.setOnItemClickedListener(new SateliteClickedListener() {
            public void eventOccured(int id) {
                switch (id) {
                case 1:
                    Utils.dismissDialogWithDelay(Utils.loadProgressDialog(ViewActivity.this), 1000l,
                            new Utils.DialogListener() {
                                @Override
                                public void action() {
                                    Intent toSelf = new Intent(ViewActivity.this, ContentSample.class);
                                    startActivity(toSelf);
                                }

                            });
                    // go to spot view.
                    // wait for the animation done.
                    /*
                     * Intent toSelf = new Intent(ViewActivity.this,
                     * ContentSample.class); startActivity(toSelf);
                     */
                    break;
                case 2:
                case 3:
                }
            }
        });
    }
}
