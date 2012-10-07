package com.zaiqinghai.activity.common;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zaiqinghai.R;

public class ExpandedHeader {
    private final Activity activity;
    public ExpandedHeader(Activity acty){
        activity = acty;
    }
    public void initFunction(){
        final TextView tv = (TextView) activity.findViewById(R.id.cur_position);
        final LinearLayout ll = (LinearLayout) activity.findViewById(R.id.cascaded_content);
        
        // add expanded event handler.
        tv.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                ll.addView(createTextView());
                ll.setVisibility(View.VISIBLE);
            }
            
        });
        
        // add close button event.
        final Button closeBtn = (Button) activity.findViewById(R.id.close_header_btn);
        closeBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                ll.removeAllViews();
                if(ll.getChildCount()>1)
                    ll.removeViewAt(1);
                ll.setVisibility(View.GONE);
            }
        });
    }
    
    private TextView createTextView() {
        TextView tv = new TextView(activity);
        tv.setText("cs");
        return tv;
    }
}
