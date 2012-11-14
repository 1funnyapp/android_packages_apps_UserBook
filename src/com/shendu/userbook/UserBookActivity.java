package com.shendu.userbook;

import com.shendu.userbook.adapter.MobileFuntionAdapter;
import com.shendu.userbook.json.CreateJsonUtill;
import com.shendu.userbook.json.JsonUtill;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class UserBookActivity extends Activity implements OnItemClickListener {
	MobileFuntionAdapter mFuncAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_book);
		GridView gridview = (GridView) findViewById(R.id.user_book_gridview);
		CreateJsonUtill cju = new CreateJsonUtill(getApplicationContext());
		mFuncAdapter = new MobileFuntionAdapter(getApplicationContext(),
				JsonUtill.getFuntionInfo(cju.getFunctionInfo()));
		gridview.setAdapter(mFuncAdapter);
		gridview.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_quick_start, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int pos, long id) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(UserBookActivity.this, SummaryActivity.class);
		Log.i("mylog", "++++++" + mFuncAdapter.getItemId(pos));
		intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		intent.putExtra("summary_id", (int) mFuncAdapter.getItemId(pos));
		startActivity(intent);
	}
}
