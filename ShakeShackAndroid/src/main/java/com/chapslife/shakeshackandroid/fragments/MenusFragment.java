package com.chapslife.shakeshackandroid.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.chapslife.shakeshackandroid.MainActivity;
import com.chapslife.shakeshackandroid.R;
import com.chapslife.shakeshackandroid.utils.Constants;

/**
 * Created by lkchapman on 10/27/13.
 */
public class MenusFragment extends Fragment{

    private WebView mWebView;
    private static final String MENU_URL = "menu_url";
    /**
     * Returns a new instance of this fragment
     */
    public static MenusFragment newInstance(String url) {
        MenusFragment fragment = new MenusFragment();
        Bundle args = new Bundle();
        args.putString(MENU_URL, url);
        fragment.setArguments(args);
        return fragment;
    }

    public MenusFragment() {
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
        mWebView = (WebView) view.findViewById(R.id.custardWebView);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.loadUrl(getArguments().getString(MENU_URL));
        return view;
    }
}
