package com.zouqinghai.activity.common;

import java.lang.reflect.Field;
import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

import com.zouqinghai.R;

public class SpotImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Integer> imgList = new ArrayList<Integer>();
    private ArrayList<Object> imgSizes = new ArrayList<Object>();

    public SpotImageAdapter(Context c) throws IllegalArgumentException, IllegalAccessException {
        mContext = c;

        // 用反射机制来获取资源中的图片ID和尺寸
        Field[] fields = R.drawable.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().startsWith("view_")) {
                // if (!"icon".equals(field.getName()))// 除了icon之外的图片
                int index = field.getInt(R.drawable.class);
                // 保存图片ID
                imgList.add(index);
                // 保存图片大小
                int size[] = new int[2];
                Bitmap bmImg = BitmapFactory.decodeResource(c.getResources(), index);
                size[0] = bmImg.getWidth();
                size[1] = bmImg.getHeight();
                imgSizes.add(size);
            }
        }
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub

        return imgList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub

        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ImageView i = new ImageView(mContext);
        // 从imgList取得图片ID
        i.setImageResource(imgList.get(position).intValue());
        i.setScaleType(ImageView.ScaleType.FIT_XY);
        // 从imgSizes取得图片大小
        int size[] = new int[2];
        size = (int[]) imgSizes.get(position);
        i.setLayoutParams(new Gallery.LayoutParams(size[0], size[1]));
        return i;
    }
}