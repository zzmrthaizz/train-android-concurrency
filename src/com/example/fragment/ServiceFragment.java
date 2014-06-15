package com.example.fragment;

import java.util.concurrent.Executor;

import com.example.concurrency.MyExecutor;
import com.example.concurrency.MyRunable;
import com.example.train_android_concurrency.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class ServiceFragment extends Fragment {
	Button button;
	MyExecutor myExecutor;
	MyRunable myRunable;
	int pb = R.id.pb_loadService;
	int tv = R.id.tv_service;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.servicefragment, container,
				false);
		
		button = (Button) rootView.findViewById(R.id.btn_startservice);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				myExecutor = new MyExecutor();
				myRunable = new MyRunable(getActivity(),pb,tv);
				myExecutor.execute(myRunable);
			}
		});
		return rootView;
	}
}
