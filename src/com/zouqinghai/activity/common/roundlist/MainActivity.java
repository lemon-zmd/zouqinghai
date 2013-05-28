package com.zouqinghai.activity.common.roundlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zouqinghai.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    RoundAdapte adapter;
    ListView mListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        mListView = (ListView) findViewById(R.id.roundList);
        String[] adapterData = new String[] { "Afghanistan", "Albania", "Algeria", "American Samoa", "Andorra",
                "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba",
                "Australia", "Austria", "Azerbaijan", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium",
                "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana",
                "Bouvet Island" };

        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();
        for (String str : adapterData) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put(RoundListViewAdapter.ROUND_TEXT_1, str);
            listMap.add(map);
        }

        List<String> listHeader = new ArrayList<String>();
        for (int i = 0; i < 30; i++) {
            listHeader.add("��" + i + "��");
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
