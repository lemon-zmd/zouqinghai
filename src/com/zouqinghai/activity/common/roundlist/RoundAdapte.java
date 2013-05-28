/**
* ������ԭ���ߵ��Ͷ��ɹ�ת����ע����лл
*/
package com.zouqinghai.activity.common.roundlist;

import java.util.List;
import java.util.Map;

import android.content.Context;

public class RoundAdapte extends RoundListViewAdapter {


	public RoundAdapte(List<Map<String, Object>> data, Context context,
			List<String> headers) {
		super(data, context, headers);
	}
	/**
	 * ���appҪ�趨��list_group������ chellor12.26 15:45 qq250345493
	 */
	@Override
	public int numberOfRowsInSection() {
		return 7;
	}
	
	/**
	 * ���appҪ�趨���±��Ϊrow��list_group��list_item���� chellor12.26 15:45 qq250345493
	 * ����Ҫд����Ƶ���switchȥ�ж���
	 */
	@Override
	public int numberOfSectionsInRow(int row) {
		
		return 4;
	}
	//���������˻�����ܹ���list��Ŀ����chellor12.26 15:45 qq250345493
}
