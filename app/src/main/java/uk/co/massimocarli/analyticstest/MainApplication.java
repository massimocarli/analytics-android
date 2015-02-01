package uk.co.massimocarli.analyticstest;

import android.app.Application;

/**
 * Created by Massimo Carli on 30/12/14.
 */
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // We initialize the Tracking
        Track.get(this);
    }
}
