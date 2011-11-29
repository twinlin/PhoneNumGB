package com.twinslin.pnum;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import com.twinslin.pnum.R;
import android.view.Window;

public class PhoneNumGBActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.top);
		final Intent it = new Intent(this, PhoneNumGBActivity1.class); // 你要轉向的Activity

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				startActivity(it);// 執行
				finish();//結束PhoneNumGBActivity
			}
		};
		timer.schedule(task, 300);// .3秒後
	}
}
