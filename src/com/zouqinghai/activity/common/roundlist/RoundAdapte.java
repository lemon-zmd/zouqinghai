/**
 */
package com.zouqinghai.activity.common.roundlist;

import java.util.List;
import java.util.Map;

import android.content.Context;

public class RoundAdapte extends RoundListViewAdapter {

    public RoundAdapte(List<Map<String, Object>> data, Context context, List<String> headers) {
        super(data, context, headers);
    }

    /**
     */
    @Override
    public int numberOfRowsInSection() {
        return 1;
    }

    /**
     */
    @Override
    public int numberOfSectionsInRow(int row) {

        return 5;
    }
}
