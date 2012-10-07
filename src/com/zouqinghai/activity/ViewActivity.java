package com.zouqinghai.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
import com.zouqinghai.R;

public class ViewActivity extends ListActivity {
    private final String PIC_URL="pic_url";
    private final String VIEW_INTRO="view_intro";

    /**
     * create the view.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);
        setListAdapter(initListData());
    }
    
    /**
     * init the adapter.
     * @return
     */
    private SimpleAdapter initListData() {
        final int [] pic_arrays = {R.drawable.view_1, R.drawable.view_2, R.drawable.view_3, R.drawable.view_4, R.drawable.view_5};
        List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
        for(int i=0; i<10; i++){
            Map<String, Object> data = new HashMap<String, Object>();
            data.put(PIC_URL, pic_arrays[i%5]);
            data.put(VIEW_INTRO, "xining_" + i);
            listItems.add(data);
        }
        SimpleAdapter sa = new SimpleAdapter(this, listItems, R.layout.view_item, new String[] {PIC_URL, VIEW_INTRO}, new int[] {R.id.view_pic, R.id.view_intro});
        return sa;
    }
}
