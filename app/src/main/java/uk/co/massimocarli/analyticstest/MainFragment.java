package uk.co.massimocarli.analyticstest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.analytics.ExceptionReporter;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    /**
     * The name of this screen
     */
    private static final String SCREEN_NAME = "MainFragment";


    /**
     * Example of Category for e-commerce
     */
    private static final String E_COMMERCE_CATEGORY = "e-commerce";

    /**
     * Example of Buy Action
     */
    private static final String BUY_ACTION = "buy";

    /**
     * Label
     */
    private static final String BOOK_LABEL = "book";

    /**
     * Value for book
     */
    private static final long BOOK_VALUE = 37;

    /**
     * Example of Buy Action
     */
    private static final String VIEW_PRODUCT_ACTION = "view-product";

    /**
     * Label
     */
    private static final String TIME_LABEL = "time";

    /**
     * Example of Category for performance
     */
    private static final String PERFORMANCE_CATEGORY = "performance";


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // We send the screen name info
        final Tracker tracker = Track.get().getTracker();
        tracker.setScreenName(SCREEN_NAME);
        tracker.send(new HitBuilders.AppViewBuilder().build());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, null);
        view.findViewById(R.id.send_event_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEvent1();
            }
        });
        view.findViewById(R.id.send_event_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEvent2();
            }
        });
        view.findViewById(R.id.send_event_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEvent2();
            }
        });
        view.findViewById(R.id.send_event_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEvent3();
            }
        });

        return view;
    }

    /**
     * Example of an event
     */
    private void sendEvent1() {
        final Tracker tracker = Track.get().getTracker();
        tracker.send(new HitBuilders.EventBuilder()
                .setCategory(E_COMMERCE_CATEGORY)
                .setAction(BUY_ACTION)
                .setLabel(BOOK_LABEL)
                .setValue(BOOK_VALUE)
                .build());
    }

    /**
     * Example of an event
     */
    private void sendEvent2() {
        final Tracker tracker = Track.get().getTracker();
        tracker.send(new HitBuilders.EventBuilder()
                .setCategory(E_COMMERCE_CATEGORY)
                .setAction(VIEW_PRODUCT_ACTION)
                .setLabel(BOOK_LABEL)
                .setValue(BOOK_VALUE)
                .build());
    }

    /**
     * Example of a timed event
     */
    private void sendEvent3() {
        final Tracker tracker = Track.get().getTracker();
        tracker.send(new HitBuilders.TimingBuilder()
                .setCategory(PERFORMANCE_CATEGORY)
                .setLabel(TIME_LABEL)
                .setValue(System.currentTimeMillis())
                .build());
    }

}
