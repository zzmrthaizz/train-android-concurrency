package com.example.concurrency;

import java.util.concurrent.Executor;

import com.example.train_android_concurrency.R;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyExecutor implements Executor {
	Activity activity;
	ProgressBar progressBar;
	TextView textView;
	int c;

	@Override
	public void execute(Runnable command) {
		new Thread(command).start();
	}

}
