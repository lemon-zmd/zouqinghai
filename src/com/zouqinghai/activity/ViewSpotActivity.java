package com.zouqinghai.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Gallery;

import com.markupartist.android.widget.ActionBar;
import com.markupartist.android.widget.ActionBar.Action;
import com.markupartist.android.widget.ActionBar.IntentAction;
import com.zouqinghai.R;
import com.zouqinghai.ZouqinghaiActivity;
import com.zouqinghai.activity.common.SpotImageAdapter;

public class ViewSpotActivity extends Activity{
    
    /**
     * create the view.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_spot);
        initActionBar();
        initSpotPics();
    }

    private void initActionBar() {

        final ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        //actionBar.setHomeAction(new IntentAction(this, createIntent(this), R.drawable.ic_title_home_demo));
        actionBar.setTitle("景点");
        
        actionBar.setHomeAction(new IntentAction(this, ViewActivity.createIntent(this), R.drawable.ic_title_home_default));
        actionBar.setDisplayHomeAsUpEnabled(true);

        final Action otherAction = new IntentAction(this, new Intent(this, ZouqinghaiActivity.class), R.drawable.ic_title_export_default);
        actionBar.addAction(otherAction);
    
    }

    private void initSpotPics() {
        final Gallery g = (Gallery) findViewById(R.id.spot_gallery);
        try {
            g.setAdapter(new SpotImageAdapter(this));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
