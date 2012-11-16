package com.shendu.userbook.adapter;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shendu.userbook.FuntionInfo;
import com.shendu.userbook.R;
import com.shendu.userbook.SummaryActivity;

public class MobileFuntionAdapter extends BaseAdapter {

	private Context mContext;
	private List<FuntionInfo> mFunctionInfos;
	private int mModCount = 0;
	public MobileFuntionAdapter(Context context, List<FuntionInfo> f) {
		mContext = context;
		mFunctionInfos = f;
		mModCount = mFunctionInfos.size() % 3 == 0 ? 0  : 3 - mFunctionInfos.size() % 3;
	}
	public View.OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(mContext, SummaryActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.putExtra("summary_id", (int)mFunctionInfos.get((Integer)v.getTag()).id);
			intent.putExtra("summary_title", mFunctionInfos.get((Integer)v.getTag()).name);
			intent.putExtra("summary_icon", (int)mFunctionInfos.get((Integer)v.getTag()).iconId);
			mContext.startActivity(intent);
		}
	};
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
			viewHold.appIcon = (ImageView)convertView
					.findViewById(R.id.app_icon);
			viewHold.layout = (LinearLayout)convertView
					.findViewById(R.id.layout);
			convertView.setTag(viewHold);
		} else {
			viewHold = (ViewHold) convertView.getTag();
		}
		if (position >= mFunctionInfos.size()) {
			viewHold.funcName.setVisibility(View.GONE);
			viewHold.appIcon.setVisibility(View.GONE);
//			viewHold.layout.setVisibility(View.GONE);
			viewHold.layout.setBackgroundResource(R.drawable.func_item_bg_null);
			viewHold.layout.setClickable(true);
		} else {
			String funcName = mFunctionInfos.get(position).name;
			viewHold.funcName.setVisibility(View.VISIBLE);
			viewHold.funcName.setText(funcName);
			viewHold.appIcon.setVisibility(View.VISIBLE);
			viewHold.layout.setVisibility(View.VISIBLE);
			viewHold.appIcon.setImageResource(mFunctionInfos.get(position).iconId);

			viewHold.layout.setBackgroundResource(R.drawable.func_item_bg_selector);
			viewHold.layout.setTag(position);
			viewHold.layout.setOnClickListener(listener);
			
		}
		return convertView;
	}

	class ViewHold {
		TextView funcName;
		ImageView appIcon;
		LinearLayout layout;
	}
}