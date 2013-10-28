package com.chapslife.shakeshackandroid.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    /**
     * Per the design guidelines, you should show the drawer on launch until the user manually
     * expands it. This shared preference tracks this.
     */
    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";
    private WebView mWebView;
    private static final String MENU_URL = "menu_url";
    private boolean mUserLearnedDrawer;
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
        // Read in the flag indicating whether or not the user has demonstrated awareness of the
        // drawer. See PREF_USER_LEARNED_DRAWER for details.
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        mUserLearnedDrawer = sp.getBoolean(PREF_USER_LEARNED_DRAWER, false);
        mWebView = (WebView) view.findViewById(R.id.custardWebView);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.loadUrl(getArguments().getString(MENU_URL));
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.locations, menu);
        if (!mUserLearnedDrawer) {
            // The user manually opened the drawer; store this flag to prevent auto-showing
            // the navigation drawer automatically in the future.
            mUserLearnedDrawer = true;
            SharedPreferences sp = PreferenceManager
                    .getDefaultSharedPreferences(getActivity());
            sp.edit().putBoolean(PREF_USER_LEARNED_DRAWER, true).apply();
        }
        // If the user hasn't 'learned' about the drawer, open it to introduce them to the drawer,
        // per the navigation drawer design guidelines.
        if (!mUserLearnedDrawer) {
            ((MainActivity) getActivity()).mDrawerLayout.openDrawer(Gravity.RIGHT);
        }

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.locations:
                if(((MainActivity) getActivity()).mDrawerLayout.isDrawerOpen(Gravity.RIGHT)){
                    ((MainActivity) getActivity()).mDrawerLayout.closeDrawer(Gravity.RIGHT);
                }else{
                    ((MainActivity) getActivity()).mDrawerLayout.openDrawer(Gravity.RIGHT);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
