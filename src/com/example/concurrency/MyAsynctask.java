package com.example.concurrency;

import com.example.train_android_concurrency.R;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MyAsynctask extends AsyncTask<Void, Integer, Integer> {
	Activity activity;
	int c;
	ProgressBar progressBar;
	TextView textView;

	public MyAsynctask(Activity activity) {
		this.activity = activity;
	}

	@Override
	protected void onPostExecute(Integer result) {
		Toast.makeText(activity, "done", Toast.LENGTH_SHORT).show();
		super.onPostExecute(result);
	}

	@Override
	protected Integer doInBackground(Void... params) {
		for (int i = 0; i < 101; i++) {
			SystemClock.sleep(500);
			c = i;
			publishProgress(c);
		}

		return null;
	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		progressBar = (ProgressBar) activity.findViewById(R.id.pb_loadasync);
		textView = (TextView) activity.findViewById(R.id.tv_async);
		progressBar.setProgress(values[0]);
		textView.setText(values[0]+"%");
		super.onProgressUpdate(values);
	}

}
