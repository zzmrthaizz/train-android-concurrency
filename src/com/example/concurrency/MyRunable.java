package com.example.concurrency;

import com.example.train_android_concurrency.R;

import android.R.string;
import android.app.Activity;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyRunable implements Runnable {

	int c;
	Activity activity;
	Handler handler;
	ProgressBar progressBar;
	TextView textView;
	int pg;
	int tv;

	public MyRunable(Activity activity, int pg, int tv) {
		this.activity = activity;
		this.pg = pg;
		this.tv = tv;
	};

	@Override
	public void run() {
		progressBar = (ProgressBar) activity.findViewById(pg);
		textView = (TextView) activity.findViewById(tv);
		for (int i = 0; i < 100; i++) {
			c = i;
			try {
				Thread.sleep(500);
				activity.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						progressBar.setProgress(c);
						textView.setText(c + "%");
					}
				});

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
