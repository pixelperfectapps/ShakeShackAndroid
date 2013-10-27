package com.chapslife.shakeshackandroid.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chapslife.shakeshackandroid.MainActivity;
import com.chapslife.shakeshackandroid.R;

/**
 * Created by lkchapman on 10/27/13.
 */
public class CustardCalendarFragment extends Fragment{

    /**
     * Returns a new instance of this fragment
     */
    public static CustardCalendarFragment newInstance() {
        CustardCalendarFragment fragment = new CustardCalendarFragment();
        return fragment;
    }

    public CustardCalendarFragment() {
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(2);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Indicate that this fragment would like to influence the set of actions in the action bar.
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custard_calendar, container, false);
        return view;
    }
}
