package com.chapslife.shakeshackandroid;

import android.app.Application;

import com.chapslife.shakeshackandroid.models.ShackLocation;
import com.chapslife.shakeshackandroid.utils.Constants;

import java.util.ArrayList;

/**
 * Created by kchapman on 11/7/13.
 */
public class ShakeShackAndroid extends Application{


    public static final ArrayList<ShackLocation> sShackLocations = new ArrayList<ShackLocation>();

    @Override
    public void onCreate() {
        super.onCreate();
        loadShackLocations();
    }

    private void loadShackLocations(){
        sShackLocations.add(new ShackLocation(Constants.NEW_HAVEN, Constants.MENU_NEW_HAVEN, Constants.LATLNG_NEW_HAVEN, Constants.URL_NEW_HAVEN ));
        sShackLocations.add(new ShackLocation(Constants.WESTPORT, Constants.MENU_WESTPORT, Constants.LATLNG_WESTPORT, Constants.URL_WESTPORT ));

        sShackLocations.add(new ShackLocation(Constants.S_BEACH, Constants.MENU_S_BEACH, Constants.LATLNG_S_BEACH, Constants.URL_S_BEACH ));
        sShackLocations.add(new ShackLocation(Constants.CORAL_GABLES, Constants.MENU_CORAL_GABLES, Constants.LATLNG_CORAL_GABLES, Constants.URL_CORAL_GABLES ));
        sShackLocations.add(new ShackLocation(Constants.BOCA, Constants.MENU_BOCA, Constants.LATLNG_BOCA, Constants.URL_BOCA ));

        sShackLocations.add(new ShackLocation(Constants.MSP, Constants.MENU_MSP, Constants.LATLNG_MSP, Constants.URL_MSP ));
        sShackLocations.add(new ShackLocation(Constants.BPC, Constants.MENU_BPC, Constants.LATLNG_BPC, Constants.URL_BPC ));
        sShackLocations.add(new ShackLocation(Constants.TD, Constants.MENU_TD, Constants.LATLNG_TD, Constants.URL_TD ));
        sShackLocations.add(new ShackLocation(Constants.UES, Constants.MENU_UES, Constants.LATLNG_UES, Constants.URL_UES ));
        sShackLocations.add(new ShackLocation(Constants.UWS, Constants.MENU_UWS, Constants.LATLNG_UWS, Constants.URL_UWS ));
        sShackLocations.add(new ShackLocation(Constants.BKLYN, Constants.MENU_BKLYN, Constants.LATLNG_BKLYN, Constants.URL_BKLYN ));
        sShackLocations.add(new ShackLocation(Constants.GST, Constants.MENU_GST, Constants.LATLNG_GST, Constants.URL_GST ));
        sShackLocations.add(new ShackLocation(Constants.JFK_T4, Constants.MENU_JFK_T4, Constants.LATLNG_JFK_T4, Constants.URL_JFK_T4 ));
        sShackLocations.add(new ShackLocation(Constants.WBY, Constants.MENU_WBY, Constants.LATLNG_WBY, Constants.URL_WBY ));
        sShackLocations.add(new ShackLocation(Constants.SSNY, Constants.MENU_SSNY, Constants.LATLNG_SSNY, Constants.URL_SSNY ));
        sShackLocations.add(new ShackLocation(Constants.SHITI_FIELD, Constants.MENU_SHITI_FIELD, Constants.LATLNG_SHITI_FIELD, Constants.URL_SHITI_FIELD ));

        sShackLocations.add(new ShackLocation(Constants.CENTER_CITY, Constants.MENU_CENTER_CITY, Constants.LATLNG_CENTER_CITY, Constants.URL_CENTER_CITY ));
        sShackLocations.add(new ShackLocation(Constants.U_CITY, Constants.MENU_U_CITY, Constants.LATLNG_U_CITY, Constants.URL_U_CITY ));
        sShackLocations.add(new ShackLocation(Constants.KOP, Constants.MENU_KOP, Constants.LATLNG_KOP, Constants.URL_KOP ));

        sShackLocations.add(new ShackLocation(Constants.DUPONT_CIRCLE, Constants.MENU_DUPONT_CIRCLE, Constants.LATLNG_DUPONT_CIRCLE, Constants.URL_DUPONT_CIRCLE ));
        sShackLocations.add(new ShackLocation(Constants.NATS_PARK, Constants.MENU_NATS_PARK, Constants.LATLNG_NATS_PARK, Constants.URL_NATS_PARK ));
        sShackLocations.add(new ShackLocation(Constants.F_STREET, Constants.MENU_F_STREET, Constants.LATLNG_F_STREET, Constants.URL_F_STREET ));

        sShackLocations.add(new ShackLocation(Constants.CHESNUT_HILL, Constants.MENU_CHESNUT_HILL, Constants.LATLNG_CHESNUT_HILL, Constants.URL_CHESNUT_HILL ));
    }
}
