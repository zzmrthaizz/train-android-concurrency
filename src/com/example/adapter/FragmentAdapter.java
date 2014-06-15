package com.example.adapter;

import com.example.fragment.AsynctaskFragment;
import com.example.fragment.IntentServiceFragment;
import com.example.fragment.RunableFragment;
import com.example.fragment.ServiceFragment;
import com.example.fragment.ThreadFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

	public FragmentAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int arg0) {
		switch (arg0) {
		case 1:
			return new ThreadFragment();
		case 3:
			return new ServiceFragment();
		case 4:
			return new IntentServiceFragment();
		case 0:
			return new RunableFragment();
		case 2:
			return new AsynctaskFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 5;
	}

}
