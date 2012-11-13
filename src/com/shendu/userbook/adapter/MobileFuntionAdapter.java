package com.shendu.userbook.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shendu.userbook.FuntionInfo;
import com.shendu.userbook.R;

public class MobileFuntionAdapter extends BaseAdapter {

	private Context mContext;
	private List<FuntionInfo> mFunctionInfos;
	private int mModCount = 0;
	public MobileFuntionAdapter(Context context, List<FuntionInfo> f) {
		mContext = context;
		mFunctionInfos = f;
		mModCount = 3 - mFunctionInfos.size() % 3;
	}

	public int getCount() {
		return mFunctionInfos != null ? mFunctionInfos.size() + mModCount: 0;
	}

	public Object getItem(int position) {
		return mFunctionInfos.get(position);
	}

	public long getItemId(int position) {
		return mFunctionInfos.get(position).id;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHold viewHold;
		if (convertView == null) {
			viewHold = new ViewHold();
			convertView = (LinearLayout) LayoutInflater.from(mContext).inflate(
					R.layout.funciton_info, null);
			viewHold.funcName = (TextView) convertView
					.findViewById(R.id.func_name);
			convertView.setTag(viewHold);
		} else {
			viewHold = (ViewHold) convertView.getTag();
		}
		if (position >= mFunctionInfos.size()) {
			viewHold.funcName.setVisibility(View.GONE);
		} else {
			String funcName = mFunctionInfos.get(position).name;
			viewHold.funcName.setVisibility(View.VISIBLE);
			viewHold.funcName.setText(funcName);
		}
		return convertView;
	}

	class ViewHold {
		TextView funcName;
	}
}