package com.chapslife.shakeshackandroid;

import android.app.Activity;
;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.chapslife.shakeshackandroid.fragments.CustardCalendarFragment;
import com.chapslife.shakeshackandroid.fragments.LocationsMapFragment;
import com.chapslife.shakeshackandroid.fragments.MenusFragment;
import com.chapslife.shakeshackandroid.fragments.ShakeCameraFragment;
import com.chapslife.shakeshackandroid.utils.Constants;

public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, ActionBar.OnNavigationListener, DrawerLayout.DrawerListener {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    public DrawerLayout mDrawerLayout;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(this);

        SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.nav_list,
                android.R.layout.simple_spinner_dropdown_item);
        getActionBar().setListNavigationCallbacks(mSpinnerAdapter, this);
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        getActionBar().setDisplayShowTitleEnabled(false);
        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, MenusFragment.newInstance(ShakeShackAndroid.sShackLocations.get(position).menuUrl))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_shake_camera);
                break;
            case 2:
                mTitle = getString(R.string.title_menus);
                break;
            case 3:
                mTitle = getString(R.string.title_custards);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        FragmentManager fragmentManager = getFragmentManager();
        if(itemPosition == 0){
            fragmentManager.beginTransaction()
                    .replace(R.id.container, ShakeCameraFragment.newInstance())
                    .commit();
        }else if(itemPosition == 1){
            fragmentManager.beginTransaction()
                    .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_MSP))
                    .commit();
        }else if(itemPosition == 2){
            fragmentManager.beginTransaction()
                    .replace(R.id.container, CustardCalendarFragment.newInstance())
                    .commit();
        }else if(itemPosition == 3){
            fragmentManager.beginTransaction()
                    .replace(R.id.container, LocationsMapFragment.newInstance())
                    .commit();
        }
        // update the main content by replacing fragments

        return false;
    }

    @Override
    public void onDrawerSlide(View view, float v) {

    }

    @Override
    public void onDrawerOpened(View view) {
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        getActionBar().setDisplayShowTitleEnabled(true);
        getActionBar().setTitle(R.string.app_name);
    }

    @Override
    public void onDrawerClosed(View view) {
        getActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        getActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public void onDrawerStateChanged(int i) {

    }
}
