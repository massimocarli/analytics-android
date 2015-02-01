package uk.co.massimocarli.analyticstest;

import android.content.Context;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

/**
 * Created by Massimo Carli on 30/12/14.
 */
public final class Track {


    /**
     * The Singleton Instance
     */
    private static Track sInstance;

    /**
     * The Tracker
     */
    private final Tracker mTraker;

    /**
     * Private constructor
     *
     * @param context The Context
     */
    private Track(final Context context) {
        // We initialize the Tracker using the XML resource file
        mTraker = GoogleAnalytics.getInstance(context).newTracker(R.xml.tracker);
    }


    /**
     * Returns the Track singleton using the given Context for initialization
     *
     * @param context The Context
     * @return The Track singleton
     */
    public synchronized static Track get(final Context context) {
        if (sInstance == null) {
            sInstance = new Track(context);
        }
        return sInstance;
    }

    /**
     * Returns the Track singleton that should be already initialized
     *
     * @return The Track singleton
     */
    public synchronized static Track get() {
        if (sInstance == null) {
            throw new IllegalStateException("Invoke get(Context) before this!");
        }
        return sInstance;
    }

    /**
     * @return The Tracker reference
     */
    public Tracker getTracker() {
        if (mTraker == null) {
            throw new IllegalStateException("Tracker not initialized! Invoke get(Context) before this!");
        }
        return mTraker;
    }
}
