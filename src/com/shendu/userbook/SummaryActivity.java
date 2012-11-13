package com.shendu.userbook;

import java.util.ArrayList;
import java.util.List;

import com.shendu.userbook.json.CreateJsonUtill;
import com.shendu.userbook.json.JsonUtill;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MenuItem;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SummaryActivity extends Activity {

	public class ViewPagerAdapter extends FragmentPagerAdapter {

		public ViewPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			return mSummaryFragment.get(position);
		}

		@Override
		public int getCount() {
			return mSummaryFragment.size();
		}

	}

	private class PageChangeListener implements OnPageChangeListener {
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
			initPageCursor(position);
		}

	}

	private ViewPager mViewPager;
	private PageChangeListener mPageChangeListener = new PageChangeListener();
	// summary information data
	private List<SummaryInfo> mSummaryInfos;
	// display summary information
	private List<SummaryFragment> mSummaryFragment = new ArrayList<SummaryFragment>();
	// dot what display current page
	private LinearLayout mCursorPage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.summary_activity);
		mCursorPage = (LinearLayout) findViewById(R.id.page_cursor);
		Intent intent = getIntent();
		int id = intent.getIntExtra("summary_id", -1);
		createFragment(id);
		initPageCursor(0);
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(new ViewPagerAdapter(getFragmentManager()));
		mViewPager.setCurrentItem(0, true);
		mViewPager.setOnPageChangeListener(mPageChangeListener);
	}

	// create fragments accord to data
	private void createFragment(int id) {
		CreateJsonUtill cju = new CreateJsonUtill(this.getApplicationContext());
		mSummaryInfos = JsonUtill.getSummaryInfo(cju.getSummaryInfo(id));
		for (SummaryInfo s : mSummaryInfos) {
			mSummaryFragment.add(new SummaryFragment(s));
		}
	}

	// initial cursor page,this function must be after createFragment
	void initPageCursor(int id) {
		mCursorPage.removeAllViews();
		int size = mSummaryInfos.size();
		TextView imageCursor;
		for (int i = 0; i < size; i++) {
			imageCursor = new TextView(this);
			imageCursor.setWidth(10);
			imageCursor.setHeight(10);
			// imageCursor.setBackgroundResource(R.drawable.ic_viewpager_off);
			imageCursor.setBackgroundColor(Color.BLACK);
			LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
					LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			param.setMargins(5, 0, 5, 0);
			imageCursor.setLayoutParams(param);
			imageCursor.setId(i);
			if (imageCursor.getId() == id) {
				// imageCursor.setBackgroundResource(R.drawable.ic_viewpager_on);
				imageCursor.setBackgroundColor(Color.BLUE);
			}
			mCursorPage.addView(imageCursor);
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		actionbarAbleUp();
	}

	// actionbar home as up
	void actionbarAbleUp() {
		ActionBar actionbar = getActionBar();
		actionbar.setDisplayOptions(ActionBar.DISPLAY_HOME_AS_UP
				| ActionBar.DISPLAY_SHOW_HOME);
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// when home is clicked
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}

	}
}
