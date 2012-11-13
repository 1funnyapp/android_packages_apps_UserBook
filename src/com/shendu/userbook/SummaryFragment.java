package com.shendu.userbook;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SummaryFragment extends Fragment {
	private SummaryInfo mSummaryInfo;
	public SummaryFragment(SummaryInfo s){
		mSummaryInfo = s;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.summary_fragment, container, false);
		TextView tv = (TextView)view.findViewById(R.id.title);
		tv.setText(mSummaryInfo.contents1);
		tv = (TextView)view.findViewById(R.id.content_one);
		tv.setText(mSummaryInfo.contents2);
		tv = (TextView)view.findViewById(R.id.content_two);
		tv.setText(mSummaryInfo.contents3);
		ImageView image = (ImageView)view.findViewById(R.id.summary_image);
		image.setImageResource(mSummaryInfo.imgId);
		return view;
	}
	
}
