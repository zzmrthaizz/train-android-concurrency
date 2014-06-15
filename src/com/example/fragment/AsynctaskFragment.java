package com.example.fragment;

import com.example.concurrency.MyAsynctask;
import com.example.train_android_concurrency.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class AsynctaskFragment extends Fragment {
	MyAsynctask asynctask;
	Button button;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.asynctaskfragment, container,
				false);
		button = (Button) rootView.findViewById(R.id.btn_startasync);
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				asynctask = new MyAsynctask(getActivity());
				asynctask.execute();
				
			}
		});
		return rootView;
	}
}
