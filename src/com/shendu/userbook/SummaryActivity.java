package com.shendu.userbook;

import java.util.ArrayList;
import java.util.List;

import com.shendu.userbook.json.CreateJsonUtill;
import com.shendu.userbook.json.JsonUtill;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

public class SummaryActivity extends Activity {

	public class ViewPagerAdapter extends FragmentPagerAdapter {

		public ViewPagerAdapter(FragmentManager fm) {
			super(fm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public Fragment getItem(int position) {
			return mSummaryFragment.get(position);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mSummaryFragment.size();
		}

	}

	private class PageChangeListener implements OnPageChangeListener {
		public PageChangeListener(){
			
		}
		@Override
		public void onPageScrollStateChanged(int state) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrolled(int position, float positionOffset,
				int positionOffsetPixels) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int position) {
			// TODO Auto-generated method stub

		}

	}

	private ViewPager mViewPager;
	//private PageChangeListener mPageChangeListener = new PageChangeListener();
	private List<SummaryInfo> mSummaryInfos;
	private List<SummaryFragment> mSummaryFragment = new ArrayList<SummaryFragment>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.summary_activity);
		Intent intent = getIntent();
		int id = intent.getIntExtra("summary_id", -1);
		createFragment(id);
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(new ViewPagerAdapter(getFragmentManager()));
		mViewPager.setCurrentItem(0, true);
		// mViewPager.setOnPageChangeListener(mPageChangeListener);
	}
	
	private void createFragment(int id){
		CreateJsonUtill cju = new CreateJsonUtill(this.getApplicationContext());
		mSummaryInfos = JsonUtill.getSummaryInfo(cju.getSummaryInfo(id));
		for (SummaryInfo s:mSummaryInfos) {
			mSummaryFragment.add(new SummaryFragment(s));
		}		
	}

}
