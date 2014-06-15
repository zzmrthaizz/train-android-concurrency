package com.example.fragment;

import com.example.concurrency.MyRunable;
import com.example.train_android_concurrency.R;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class RunableFragment extends Fragment {
	Button startButton;
	ImageView imageView;
	ProgressBar progressBar;
	MyRunable runable;
	int percent;
	TextView textView;
	Handler handler = new Handler();
	int pb = R.id.pb_loadrunalbe;
	int tv = R.id.tv_runable;
	private Runnable updateUI = new Runnable() {
		
		@Override
		public void run() {
			progressBar.setProgress(percent);
			textView.setText(percent+"%");
			
		}
	};

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.runablefragment, container,
				false);
		startButton = (Button) rootView.findViewById(R.id.btn_startrunable);
		imageView = (ImageView) rootView.findViewById(R.id.img_runable);
		progressBar = (ProgressBar) rootView.findViewById(R.id.pb_loadrunalbe);
		textView = (TextView) rootView.findViewById(R.id.tv_runable);

		startButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				runable = new MyRunable(getActivity(),pb,tv);
				Thread thread = new Thread(runable);
				thread.start();
			}
		});
		return rootView;
	}
	
}
