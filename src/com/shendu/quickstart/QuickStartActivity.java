package com.shendu.quickstart;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class QuickStartActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_start);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_quick_start, menu);
        return true;
    }
    
}
