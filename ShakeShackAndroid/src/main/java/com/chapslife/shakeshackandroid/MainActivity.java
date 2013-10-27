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
import com.chapslife.shakeshackandroid.fragments.MenusFragment;
import com.chapslife.shakeshackandroid.fragments.ShakeCameraFragment;
import com.chapslife.shakeshackandroid.utils.Constants;

public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, ActionBar.OnNavigationListener {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

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

        SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.action_list,
                android.R.layout.simple_spinner_dropdown_item);
        getActionBar().setListNavigationCallbacks(mSpinnerAdapter, this);
        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        ActionBar actionBar = getActionBar();
        if(position == 0){
            fragmentManager.beginTransaction()
                    .replace(R.id.container, ShakeCameraFragment.newInstance())
                    .commit();
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
            actionBar.setDisplayShowTitleEnabled(true);
        }else if(position == 1){
            fragmentManager.beginTransaction()
                    .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_MSP))
                    .commit();
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
            actionBar.setSelectedNavigationItem(5);
            actionBar.setDisplayShowTitleEnabled(false);
        }else{
            fragmentManager.beginTransaction()
                    .replace(R.id.container, CustardCalendarFragment.newInstance())
                    .commit();
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
            actionBar.setDisplayShowTitleEnabled(true);
        }

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
        if(mNavigationDrawerFragment.getCurrentSelectedNavItem() == 1){
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
            actionBar.setDisplayShowTitleEnabled(false);
        }else{
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
            actionBar.setDisplayShowTitleEnabled(true);
        }

        actionBar.setTitle(mTitle);
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
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        switch(itemPosition){
            case 0:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_NEW_HAVEN))
                        .commit();
                break;
            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_WESTPORT))
                        .commit();
                break;
            case 2:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_S_BEACH))
                        .commit();
                break;
            case 3:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_CORAL_GABLES))
                        .commit();
                break;
            case 4:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_BOCA))
                        .commit();
                break;
            case 5:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_MSP))
                        .commit();
                break;
            case 6:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_BPC))
                        .commit();
                break;
            case 7:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_TD))
                        .commit();
                break;
            case 8:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_UES))
                        .commit();
                break;
            case 9:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_UWS))
                        .commit();
                break;
            case 10:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_BKLYN))
                        .commit();
                break;
            case 11:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_GST))
                        .commit();
                break;
            case 12:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_JFK_T4))
                        .commit();
                break;
            case 13:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_WBY))
                        .commit();
                break;
            case 14:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_SSNY))
                        .commit();
                break;
            case 15:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_SHITI_FIELD))
                        .commit();
                break;
            case 16:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_CENTER_CITY))
                        .commit();
                break;
            case 17:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_U_CITY))
                        .commit();
                break;
            case 18:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_KOP))
                        .commit();
                break;
            case 19:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_DUPONT_CIRCLE))
                        .commit();
                break;
            case 20:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_NATS_PARK))
                        .commit();
                break;
            case 21:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_F_STREET))
                        .commit();
                break;
            case 22:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_CHESNUT_HILL))
                        .commit();
                break;
            default:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, MenusFragment.newInstance(Constants.MENU_MSP))
                        .commit();
                break;
        }
        return false;
    }
}
