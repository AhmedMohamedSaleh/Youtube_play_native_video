package com.example.android.youtube_play_native_video_github;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.youtube_play_native_video_github.Netwrok.Download_and_load_Image;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VideoPlaying_Activity extends YouTubeBaseActivity {

    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.tview)
    TextView tview;

    private String playlist_name;
    private String TAG = " VideoPlaying_Activity";
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    public VideoPlaying_Activity() {
        super();
    }

    private static Context ccontext;
    public static void setContext(Context context){
        ccontext = context;
    }
    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.test);
        ButterKnife.bind(this);
        Intent mIntent = getIntent();
        if (mIntent != null && mIntent.getExtras()!=null) {
            String value = (String) mIntent.getExtras().get("specifiedChannel");
//            Context context = (Context) mIntent.getExtras().get("con");
            //      Binding not working
            tview = findViewById(R.id.tview);
            icon = findViewById(R.id.icon);
            tview.setText(value);
            Download_and_load_Image.load_images((String) mIntent.getExtras().get("image_url"),icon,ccontext);
            playlist_name = (String) mIntent.getExtras().get("playlistName");
        }else{
            Log.d("_Activity_extra_data", "intent null");

        }
        //Download_and_load_Image.load_images((String) mIntent.getExtras().get("image_url"),icon,getApplicationContext());

        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.ss);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onInitializationSuccess: yes");
                //youTubePlayer.loadVideo("CSa6Ocyog4U");
                youTubePlayer.loadPlaylist(playlist_name);

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onInitializationFailure: no");
            }
        };
        youTubePlayerView.initialize("AIzaSyB43vfEpUD3NFH5ZV3l1UXcJOZ5aZ7SIZQ", onInitializedListener);

    }
}
