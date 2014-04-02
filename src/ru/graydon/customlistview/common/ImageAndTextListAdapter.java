package ru.graydon.customlistview.common;

import ru.graydon.customlistview.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAndTextListAdapter extends ArrayAdapter<String> {

    private LayoutInflater mInflater;
    
    private String[] mStrings;
    private TypedArray mIcons;
    
    //private int mViewResourceId;
        
    public ImageAndTextListAdapter(Context ctx, int viewResourceId,
            String[] strings, TypedArray icons) {
        super(ctx, viewResourceId, strings);
        
        mInflater = (LayoutInflater)ctx.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        
        mStrings = strings;
        mIcons = icons;
        
        //mViewResourceId = viewResourceId;        
    }

    @Override
    public int getCount() {
        return mStrings.length;
    }

    @Override
    public String getItem(int position) {
        return mStrings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
    	View rowView = mInflater.inflate(R.layout.custom_listview_row, parent, false);
        
    	ImageView iv = (ImageView) rowView.findViewById(R.id.group_icon);
        iv.setImageDrawable(mIcons.getDrawable(position));

        TextView tv = (TextView) rowView.findViewById(R.id.group_name);
        tv.setText(mStrings[position].toUpperCase());
                
        return rowView;
    }
}
