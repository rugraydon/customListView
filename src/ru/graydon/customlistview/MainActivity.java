package ru.graydon.customlistview;

import ru.graydon.customlistview.common.ImageAndTextListAdapter;
import android.app.ListActivity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

public class MainActivity extends ListActivity {
	
	private final String TAG = getClass().toString();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Context ctx = getApplicationContext();
        Resources res = ctx.getResources();
        
        String[] _products = res.getStringArray(R.array.products);
        TypedArray _icons = res.obtainTypedArray(R.array.icons);
        setListAdapter(new ImageAndTextListAdapter(ctx, R.layout.custom_listview_row, _products, _icons));

	}
}
