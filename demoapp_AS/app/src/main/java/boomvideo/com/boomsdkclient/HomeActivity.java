


package boomvideo.com.boomsdkclient;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


import com.boomvideo.framework.dto.OperationResult;
import com.boomvideo.videotracker.BoomVideoResourceManager;
import com.boomvideo.videotracker.BoomVideoTrackerInf;








public class HomeActivity extends Activity implements BoomVideoTrackerInf {

    //private final String Boom_GUID = "e39970ec-34c6-41d8-90a1-2586bef04be9";
    //private final String Boom_GUID = "7a59cb93-b975-44f6-8add-508b602ba47c";
    //private final String Boom_GUID = "09fa348 8-2ea0-4ddb-af45-cbc2d7347c91";
    //private final String Boom_GUID = "9c6543a6-a41e-4657-9178-84210b22d794";
    private final String Boom_GUID = "9c6543a6-a41e-4657-9178-84210b22d794";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttonscreen_main);
        Button btnPreRoll = (Button) findViewById(R.id.preroll);
        btnPreRoll.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                if (validateGuid()) {
                    BoomVideoResourceManager boomVideoResourceManager = BoomVideoResourceManager
                            .getInstance();
                    boomVideoResourceManager.showVideoAds(Boom_GUID,
                            HomeActivity.this, BoomVideoResourceManager.VIDEO_PLAYER_TYPE.PREROLL);
                }
            }
        });


        Button btnRewards_yt = (Button) findViewById(R.id.rewards_yt);
        btnRewards_yt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validateGuid()) {

                    BoomVideoResourceManager boomVideoResourceManager = BoomVideoResourceManager
                            .getInstance();
                    boomVideoResourceManager
                            .showVideoAds(
                                    Boom_GUID,
                                    HomeActivity.this, BoomVideoResourceManager.VIDEO_PLAYER_TYPE.REWARDS);
                }
            }
        });

        /*Button btnrewards_nonyt = (Button) findViewById(R.id.rewards_nonyt);
        btnrewards_nonyt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (validateGuid()) {
                    BoomVideoResourceManager boomVideoResourceManager = BoomVideoResourceManager
                            .getInstance(HomeActivity.this);
                    boomVideoResourceManager
                            .showVideoAds(
                                    Boom_GUID,
                                    HomeActivity.this, BoomVideoResourceManager.VIDEO_PLAYER_TYPE.REWARDS);
                }
            }
        });*/
//
//
        Button btnOfferlist = (Button) findViewById(R.id.offerlist);
        btnOfferlist.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateGuid()) {
                    BoomVideoResourceManager boomVideoResourceManager = BoomVideoResourceManager
                            .getInstance();
                    boomVideoResourceManager.showVideoAds(Boom_GUID,
                            HomeActivity.this, BoomVideoResourceManager.VIDEO_PLAYER_TYPE.OFFLIST);
                }
            }
        });


        int density = getResources().getDisplayMetrics().densityDpi;
        switch (density) {
            case DisplayMetrics.DENSITY_LOW:
                // Toast.makeText(this, "LDPI", Toast.LENGTH_SHORT).show();
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                // Toast.makeText(this, "MDPI", Toast.LENGTH_SHORT).show();
                break;
            case DisplayMetrics.DENSITY_HIGH:
                // Toast.makeText(this, "HDPI", Toast.LENGTH_SHORT).show();
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                // Toast.makeText(this, "XHDPI", Toast.LENGTH_SHORT).show();
                break;

            case DisplayMetrics.DENSITY_TV:
                //  Toast.makeText(this, "DENSITY_TV", Toast.LENGTH_SHORT).show();
                break;
            case DisplayMetrics.DENSITY_400:
                //  Toast.makeText(this, "DENSITY_400", Toast.LENGTH_SHORT).show();
                break;
            case DisplayMetrics.DENSITY_XXHIGH:
                // Toast.makeText(this, "DENSITY_XXHIGH", Toast.LENGTH_SHORT).show();
                break;
            case DisplayMetrics.DENSITY_XXXHIGH:
                // Toast.makeText(this, "DENSITY_XXXHIGH", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    protected boolean validateGuid() {
        if (TextUtils.isEmpty(Boom_GUID)) {
            return false;
        }
        return true;
    }


    @Override
    public void onVideoTrackEvent(final OperationResult operationResult) {
        switch (operationResult.getResultMessages()) {

            case UKNOWN_ERROR:
                break;
            case VIDEO_UNAVAILABLE:
                // Toast.makeText(HomeActivity.this, "Video unavailable",
                //        Toast.LENGTH_SHORT).show();
                break;
            case PLAYER_INITAILIZATION_ERROR:
                // Toast.makeText(HomeActivity.this, "PLAYER_INITAILIZATION_ERROR",
                //        Toast.LENGTH_SHORT).show();
                break;
            case VIDEO_FIRST_PLAY:
                // Toast.makeText(HomeActivity.this, "VIDEO_FIRST_PLAY",
                //        Toast.LENGTH_SHORT).show();
                break;
            case VIDEO_END_PLAY:
                //Toast.makeText(HomeActivity.this, "VIDEO_END_PLAY",
                //       Toast.LENGTH_SHORT).show();
                break;

            case ANNOTATION_CLICK:
                //Toast.makeText(HomeActivity.this, "ANNOTATION_CLICK",
                //       Toast.LENGTH_SHORT).show();

                break;
            case VIDEO_CALLBACK_FIRETIME_COMPLETED:
                Toast.makeText(HomeActivity.this,
                        "Congrats rewards gained :: " + operationResult.getPoints(),
                        Toast.LENGTH_SHORT).show();

                break;

            case FACEBOOK_SHARE_COMPLETED:
                // Toast.makeText(HomeActivity.this, "FACEBOOK_COMPLETED",
                //         Toast.LENGTH_SHORT).show();
                break;
            case GOOGLE_SHARE_COMPLETED:
                // Toast.makeText(HomeActivity.this, "GOOGLE_SHARE_COMPLETED",
                //        Toast.LENGTH_SHORT).show();
                break;
            case TWITTER_SHARE_COMPLETED:
                // Toast.makeText(HomeActivity.this, "TWITTER_SHARE_COMPLETED",
                //       Toast.LENGTH_SHORT).show();
                break;
            case VIDEO_PAUSED:
                // Toast.makeText(HomeActivity.this, "VIDEO_PAUSED",
                //        Toast.LENGTH_SHORT).show();

                break;

            case INSTAGRAM_URL:

                // Toast.makeText(HomeActivity.this,
                //        "INSTAGRAM_SHARE_COMPLETED - " + operationResult.getPoints(),
                //       Toast.LENGTH_SHORT).show();
                break;

            case SLIDESHARE_URL:
                // Toast.makeText(HomeActivity.this,
                //       "SLIDESHARE_URL - " + operationResult.getPoints(), Toast.LENGTH_SHORT)
                //        .show();
                break;
            case SURVEY_COMPLETED:

                //Toast.makeText(HomeActivity.this,
                //       "SURVEY_CLICKED - " + operationResult.getPoints(), Toast.LENGTH_SHORT)
                //      .show();
                break;
            case BLOG_URL:

                Toast.makeText(HomeActivity.this, "BLOG_URL- " + operationResult.getPoints(),
                        Toast.LENGTH_SHORT).show();
                break;
            case APP_INSTALLED:

                //Toast.makeText(HomeActivity.this,
                //      "APP_INSTALLED- " + operationResult.getPoints(), Toast.LENGTH_SHORT)
                //      .show();
                break;

            case VIDEO_PROGRESS:

                int progressRule = (Integer) operationResult.getResult();

                if (progressRule == OperationResult.VIDEO_COMPLETED_25P) {

                    // Toast.makeText(HomeActivity.this, "Progress completed 25% ",
                    //       Toast.LENGTH_SHORT).show();
                } else if (progressRule == OperationResult.VIDEO_COMPLETED_50P) {

//                    Toast.makeText(HomeActivity.this, "Progress completed 50%",
//                            Toast.LENGTH_SHORT).show();

                } else if (progressRule == OperationResult.VIDEO_COMPLETED_75P) {

                    //    Toast.makeText(HomeActivity.this, "Progress completed 75%",
                    //           Toast.LENGTH_SHORT).show();
                }
                break;


            case INTERNET_UNAVAILABLE:
                //  Toast.makeText(HomeActivity.this, "INTERNET_UNAVAILABLE",
                //          Toast.LENGTH_SHORT).show();
                break;

            case OFFER_AVAILED_ALREADY:

                // Toast.makeText(HomeActivity.this, "You have already availed the offer!", Toast.LENGTH_SHORT).show();
                break;

            case INTERSTITIAL_LOADED:
                // Toast.makeText(HomeActivity.this, "Interstitial Loaded.......", Toast.LENGTH_SHORT).show();
                break;

            case INTERSTITIAL_CLICKED:

                //Toast.makeText(HomeActivity.this, "Interstitial Clicked", Toast.LENGTH_SHORT).show();
                break;

            case INTERSTITIAL_CLOSED:

                //  Toast.makeText(HomeActivity.this, "Interstitial Closed" + operationResult.getPoints(), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public Activity getContext() {
        return this;
    }
}