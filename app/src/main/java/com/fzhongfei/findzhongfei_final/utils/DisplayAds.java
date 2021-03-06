package com.fzhongfei.findzhongfei_final.utils;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class DisplayAds {

    private static final String TAG = "DisplayAds";

    public DisplayAds(AdView mAdView, final RelativeLayout adLayout) {
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            // Called when an ad is loaded.
            @Override
            public void onAdLoaded() {
                Log.e(TAG, "Google onAdLoaded");
                adLayout.setVisibility(View.VISIBLE);
            }

            // Called when an ad failed to load.
            @Override
            public void onAdFailedToLoad(int error) {
                String message = "Google onAdFailedToLoad: " + getErrorReason(error);
                Log.e(TAG, message);
            }

            // Called when an Activity is created in front of the app
            // (e.g. an interstitial is shown, or an ad is clicked and launches a new Activity).
            @Override
            public void onAdOpened() {
                Log.e(TAG, "Google onAdOpened");
            }

            // Called when an ad is clicked and about to return to the application.
            @Override
            public void onAdClosed() {
                Log.e(TAG, "Google onAdClosed");
            }

            // Called when an ad is clicked and going to start a new Activity that will leave the application
            // (e.g. breaking out to the Browser or Maps application).
            @Override
            public void onAdLeftApplication() {
                Log.d(TAG, "Google onAdLeftApplication");
            }
        });
    }

    private String getErrorReason(int errorCode) {
        // Gets a string error reason from an error code.
        String errorReason = "";
        switch (errorCode) {
            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                errorReason = "Internal error";
                break;
            case AdRequest.ERROR_CODE_INVALID_REQUEST:
                errorReason = "Invalid request";
                break;
            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                errorReason = "Network Error";
                break;
            case AdRequest.ERROR_CODE_NO_FILL:
                errorReason = "No fill";
                break;
        }
        return errorReason;
    }
}
