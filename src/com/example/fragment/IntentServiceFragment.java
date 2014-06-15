package com.example.fragment;

import com.example.concurrency.MyExecutorService;
import com.example.concurrency.MyRunable;
import com.example.train_android_concurrency.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class IntentServiceFragment extends Fragment {
	MyExecutorService myExecutorService;
	MyRunable myRunable;
	int pb = R.id.pb_loadIntentService;
	int tv = R.id.tv_intentservice;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.intentservicefragment,
				container, false);
		Button startIntentService = (Button) rootView.findViewById(R.id.btn_startintentservice);
		
		startIntentService.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				myExecutorService = new MyExecutorService();
				myRunable = new MyRunable(getActivity(), pb,tv);
				myExecutorService.execute(myRunable);
				
			}
		});
		return rootView;
	}
}
