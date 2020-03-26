package com.example.android.youtube_play_native_video_github.Fragements;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.android.youtube_play_native_video_github.MainActivity;
import com.example.android.youtube_play_native_video_github.Netwrok.Download_and_load_Image;
import com.example.android.youtube_play_native_video_github.R;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class Video_playing extends Fragment {

    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    private Context context ;
    private String TAG = "Video_playing";

    public void setContext(Context context){
        this.context = context;
    }

    public static Video_playing newInstance() {
        return new Video_playing();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: Starting");
        MainActivity.check = "Video_playing";

        final View view = inflater.inflate(R.layout.video_playing, container, false);
//        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.card_recycler_view);
//        initViews(recyclerView);

//        youTubePlayerView = (YouTubePlayerView) view.findViewById(R.id.view);
//
//        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                Log.d("qqqqqqqqqqqqqq", "onInitializationSuccess: yes");
//                youTubePlayer.loadVideo("https://www.youtube.com/watch?v=CSa6Ocyog4U");
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//                Log.d("qqqqqqqqqqqqqq", "onInitializationSuccess: no");
//            }
//        };
//
//        youTubePlayerView.initialize("AIzaSyB43vfEpUD3NFH5ZV3l1UXcJOZ5aZ7SIZQ", onInitializedListener);

//        YouTubePlayerSupportFragment youTubePlayerFragment = (YouTubePlayerSupportFragment) getFragmentManager()
//                .findFragmentById(R.id.viewq);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
       // transaction.replace(R.id.viewq, youTubePlayerFragment).commit();

        TextView tv = view.findViewById(R.id.tview);
        ImageView imageView = view.findViewById(R.id.icon);
        String value="";
        value = getArguments().getString("image_url");

        Download_and_load_Image.load_images(value,imageView,context);
        //Retrieve the value
        value = getArguments().getString("specifiedChannel");
        tv.setText(value);
        return view;
    }

//    private void initViews(RecyclerView recyclerView){
//
//        recyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
//        recyclerView.setLayoutManager(layoutManager);
//
//
//        ArrayList<ChannelModel> channels =new ArrayList<>();
//        channels.add(new ChannelModel("Ali Media Center", "https://www.youtube.com/channel/UCL42dFucNLBSqIgpw2ECNBg",
//                "https://yt3.ggpht.com/a/AATXAJwhWMroySP4J87NQIzo0OVbDkDzGAgnLYyjFA=s88-c-k-c0xffffffff-no-rj-mo"));
//        channels.add(new ChannelModel("Android Developers", "https://www.youtube.com/channel/UCVHFbqXqoYvEWM1Ddxl0QDg",
//                "https://yt3.ggpht.com/a/AATXAJz-xXlS2ao5fm1K97AbykChh3X6jnltOvyBBQ=s88-c-k-c0xffffffff-no-rj-mo"));
//        channels.add(new ChannelModel("coding with nerds", "https://www.youtube.com/channel/UCnDAXfhnL5j-KhHc1KhvXHw",
//                "https://yt3.ggpht.com/a/AATXAJzfPgD-wLHJvZhq4CfQE69_KYMk7NEOnE_cGQ=s88-c-k-c0xffffffff-no-rj-mo"));
//        Channels_Adapter adapter = new Channels_Adapter(channels);
//        adapter.setContext(context);
//        recyclerView.setAdapter(adapter);
//
//    }

}
