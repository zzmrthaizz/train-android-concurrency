package com.example.concurrency;


import com.example.train_android_concurrency.R;

import android.app.Activity;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyThread extends Thread {

	int c;
	Activity activity;
	Handler handler;
	ProgressBar progressBar;
	TextView textView;
	
	public MyThread(Activity activity) {
		this.activity = activity;
	};

	@Override
	public void run() {
		progressBar = (ProgressBar) activity.findViewById(R.id.pb_loadthread);
		textView = (TextView) activity.findViewById(R.id.tv_thread);
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