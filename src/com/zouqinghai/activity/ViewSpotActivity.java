package com.zouqinghai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TextView;

import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.IntentAction;
import com.zouqinghai.R;
import com.zouqinghai.activity.common.SpotImageAdapter;
import com.zouqinghai.activity.waterfall.WaterFallUtil;

public class ViewSpotActivity extends Activity{
    
    /**
     * create the view.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_spot);
        initActionBar();
        initSpotOthers();
    }

    private void initSpotOthers() {
        String TAB1 = "主题";
        String TAB2 = "intro";
        String TAB3 = "壁纸";
        TabHost mTabHost = (TabHost) findViewById(android.R.id.tabhost);  
        mTabHost.setup();
          
        mTabHost.addTab(mTabHost.newTabSpec("tab1").setIndicator(getMenuItem(android.R.color.white, TAB1)).setContent(R.id.view_spot_pic_waterfall_scroll));
        initPics();
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator(getMenuItem(android.R.color.white,TAB2)).setContent(R.id.view_spot_introduction));
//        initSpotPics();
        mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator(getMenuItem(android.R.color.black,TAB3)).setContent(R.id.view_spot_others));
        
        
        // add background change function to the tab host.
//        mTabHost.getTabWidget().getChildAt(0).setBackgroundResource(R.drawable.view_spot_activate_tab_bg);
        
    }

    private void initPics() {
        new WaterFallUtil(this).create(R.id.view_spot_pic_waterfall_scroll, R.id.view_spot_pic_waterfall_container);
    }

    public View getMenuItem(int imgID, String textID){  
        LinearLayout ll = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.tab_item, null);  
        ImageView imgView = (ImageView)ll.findViewById(R.id.icon);  
        imgView.setBackgroundResource(imgID);  
        TextView textView = (TextView)ll.findViewById(R.id.name);  
        textView.setText(textID);  
        return ll;  
    }
    
    private void initActionBar() {

        final ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        //actionBar.setHomeAction(new IntentAction(this, createIntent(this), R.drawable.ic_title_home_demo));
        actionBar.setTitle("景点");
        
        actionBar.setHomeAction(new IntentAction(this, ViewActivity.createIntent(this), R.drawable.ic_title_home_default));
        actionBar.setDisplayHomeAsUpEnabled(true);

//        final Action otherAction = new IntentAction(this, new Intent(this, ZouqinghaiActivity.class), R.drawable.ic_title_export_default);
//        actionBar.addAction(otherAction);
    
    }

    private void initSpotPics() {
        final Gallery g = (Gallery) findViewById(R.id.spot_gallery);
        try {
            g.setAdapter(new SpotImageAdapter(this));
            // make the first one aligned correctly.
            g.setSelection(2);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
