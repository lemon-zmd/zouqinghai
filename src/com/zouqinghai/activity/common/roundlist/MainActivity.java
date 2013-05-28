package com.zouqinghai.activity.common.roundlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.zouqinghai.R;
import com.zouqinghai.activity.common.ActionUtil;

public class MainActivity extends Activity {

    RoundAdapte adapter;
    ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ActionUtil.initActionBar(this, "我的旅行计划");
    }

    private void init() {

        mListView = (ListView) findViewById(R.id.roundList);
        String[] adapterData = new String[] { "景点：门源油菜花...", "住宿: 门源-门源宾馆", "交通：租车...", "记账: 早餐12...", "备注：..."};
//        String[] adapterData = new String[] { "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
//                "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba",
//                "Australia", "Austria", "Azerbaijan", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
//                "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana",
//                "Bouvet Island" };

        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        for (String str : adapterData) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(RoundListViewAdapter.ROUND_TEXT_1, str);
            listMap.add(map);
        }

        List<String> listHeader = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            listHeader.add("DAY - " + i );
        }
        adapter = new RoundAdapte(listMap, this, listHeader);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(position + "++++");
            }
        });
    }
}
