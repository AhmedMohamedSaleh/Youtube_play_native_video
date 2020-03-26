package com.example.android.youtube_play_native_video_github;


import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.android.youtube_play_native_video_github.Fragements.Home;
import com.example.android.youtube_play_native_video_github.ViewModel.ChannelsViewModel;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static String check = "Home";
    private String TAG = "MainActivity";
    Fragment selected = null;
    public ChannelsViewModel mViewModel;


    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // type logd then ! .
        Log.d(TAG, "onCreate: ");

        selected = new Home();

        ((Home) selected).setContext(getApplicationContext());
        getSupportFragmentManager().beginTransaction().replace(R.id.inflator,
                selected).commit();


//        mViewModel= new ViewModelProvider(this).get(ChannelsViewModel.class);
//        mViewModel.fragement.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                Log.d(TAG, "onChanged: khkjgjgkhjfhjgf");
//                String channel_name = s ;
//                selected = new Video_playing();
//                ((Video_playing) selected).setContext(getApplicationContext());
//                getSupportFragmentManager().beginTransaction().replace(R.id.inflator,
//                        selected).commit();
//            }
//        });
//        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//            }
//        };

    }

    @Override
    public void onBackPressed() {

        Log.d(TAG, "onBackPressed: "+check);
        if (check.equals("Home")) {
            finish();
            //additional code
        } else {
            selected = new Home();

            ((Home) selected).setContext(getApplicationContext());
            getSupportFragmentManager().beginTransaction().replace(R.id.inflator,
                    selected).addToBackStack("www").commit();
        }
    }
}
