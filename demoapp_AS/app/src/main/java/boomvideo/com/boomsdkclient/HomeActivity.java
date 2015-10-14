


package boomvideo.com.boomsdkclient;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


import com.boomvideo.framework.common.Logger;
import com.boomvideo.framework.dto.ERROR_TYPE;
import com.boomvideo.framework.dto.OperationResult;
import com.boomvideo.videotracker.BoomVideoResourceManager;
import com.boomvideo.videotracker.BoomVideoTrackerInf;








public class HomeActivity extends Activity implements BoomVideoTrackerInf {

    private static final String TAG = HomeActivity.class.getName();

    //private final String Boom_GUID = "e39970ec-34c6-41d8-90a1-2586bef04be9";
    //private final String Boom_GUID = "7a59cb93-b975-44f6-8add-508b602ba47c";
    //private final String Boom_GUID = "09fa348 8-2ea0-4ddb-af45-cbc2d7347c91";
    //private final String Boom_GUID = "9c6543a6-a41e-4657-9178-84210b22d794";
    private final String Boom_GUID = "27b55f7e-f75e-4d97-9b33-07f27a2856e5";



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
                            HomeActivity.this, BoomVideoResourceManager.VIDEO_PLAYER_TYPE.OFFERLIST);
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

            case AD_VIEW_LOADED:
                //Toast.makeText(HomeActivity.this, "AD_VIEW_LOADED...", Toast.LENGTH_SHORT).show();
                setLogs("AD_VIEW_LOADED...");
                break;
            case AD_FAILED:
                // Toast.makeText(HomeActivity.this, "AD FAILED..." + operationResult.getErrorInfo(), Toast.LENGTH_SHORT).show();
                setLogs("AD FAILED..." + operationResult.getErrorInfo());
                String errorInfo = operationResult.getErrorInfo().toString();
                if (errorInfo.equalsIgnoreCase(ERROR_TYPE.INTERNAL_ERROR.toString())) {
                    Logger.v(TAG, "INTERNAL ERROR");
                } else if (errorInfo.equalsIgnoreCase(ERROR_TYPE.NO_FILL.toString())) {
                    Logger.v(TAG, "NO FILL");
                } else {
                    Logger.v(TAG, "NO NETWORK AVAILABLE");
                }
                break;
            case POINTS_REVEALED:
                // Toast.makeText(HomeActivity.this, "SUCCESSFUL_SHARED_ON_FACEBOOK...",
                //         Toast.LENGTH_SHORT).show();
                setLogs("POINTS_REVEALED..." + operationResult.getPoints());
                break;

            case SUCCESSFUL_SHARED_ON_FACEBOOK:
                // Toast.makeText(HomeActivity.this, "SUCCESSFUL_SHARED_ON_FACEBOOK...",
                //         Toast.LENGTH_SHORT).show();
                setLogs("SUCCESSFUL_SHARED_ON_FACEBOOK...");
                break;
            case SUCCESSFUL_SHARED_ON_GOOGLEPLUS:
                // Toast.makeText(HomeActivity.this, "SUCCESSFUL_SHARED_ON_GOOGLEPLUS...",
                //         Toast.LENGTH_SHORT).show();
                setLogs("SUCCESSFUL_SHARED_ON_GOOGLEPLUS...");
                break;
            case SUCCESSFUL_SHARED_ON_TWITTER:
                // Toast.makeText(HomeActivity.this, "SUCCESSFUL_SHARED_ON_TWITTER...",
                //        Toast.LENGTH_SHORT).show();
                setLogs("SUCCESSFUL_SHARED_ON_TWITTER...");
                break;
            case AD_VIEW_CLOSED:
                // Toast.makeText(HomeActivity.this, "AD_VIEW_CLOSED..." + operationResult.getPoints(), Toast.LENGTH_SHORT).show();
                setLogs("AD_VIEW_CLOSED..." + operationResult.getPoints());
                break;
            default:
                break;
        }
    }

    public void setLogs(String message) {
        Logger.v(TAG, message);
    }

    @Override
    public Activity getContext() {
        return this;
    }
}