package com.example.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.RotateAnimation;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.concurrency.MyAsynctask;
import com.example.concurrency.MyThread;
import com.example.train_android_concurrency.R;

public class ThreadFragment extends Fragment {
	MyThread myThread;
	ImageView imageView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.threadfragment, container,
				false);
		Button startThread = (Button) rootView
				.findViewById(R.id.btn_startthread);
		TextView percent = (TextView) rootView.findViewById(R.id.tv_thread);
		imageView = (ImageView) rootView.findViewById(R.id.img_thread);
		startThread.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				myThread = new MyThread(getActivity());
				myThread.start();

			}
		});
		return rootView;
	}
}
