package com.example.android.youtube_play_native_video_github.Fragements;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.youtube_play_native_video_github.MainActivity;
import com.example.android.youtube_play_native_video_github.Models.ChannelModel;
import com.example.android.youtube_play_native_video_github.R;
import com.example.android.youtube_play_native_video_github.RC_Adapter.Channels_Adapter;
import com.example.android.youtube_play_native_video_github.VideoPlaying_Activity;
import com.example.android.youtube_play_native_video_github.ViewModel.ChannelsViewModel;

import java.util.ArrayList;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class Home extends Fragment {


    private ChannelsViewModel mViewModel;
    private Context context ;

    public void setContext(Context context){
        this.context = context;
    }

    public static Home newInstance() {
        return new Home();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        MainActivity.check = "Home";

        final View view = inflater.inflate(R.layout.home_fragment, container, false);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.card_recycler_view);
        initViews(recyclerView);
        return view;
    }

    private void initViews(final RecyclerView recyclerView){

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        mViewModel= new ViewModelProvider(this).get(ChannelsViewModel.class);
        mViewModel.getChannels();
        mViewModel.mutableLiveData.observe(getViewLifecycleOwner(), new Observer<ArrayList<ChannelModel>>() {
            @Override
            public void onChanged(ArrayList<ChannelModel> channelModels) {
                Channels_Adapter adapter = new Channels_Adapter(channelModels,mViewModel);
                adapter.setContext(context);
                recyclerView.setAdapter(adapter);
            }
        });

        mViewModel= new ViewModelProvider(this).get(ChannelsViewModel.class);
        mViewModel.fragement.observe(getViewLifecycleOwner(), new Observer<ChannelModel>() {
            @Override
            public void onChanged(ChannelModel selectedChannel) {
                Log.d("kkkkkkkk", "onChanged: khkjgjgkhjfhjgf");

//                Fragment selected = new Video_playing();
//                Bundle args = new Bundle();
//                args.putString("specifiedChannel", selectedChannel.getName());
//                args.putString("image_url", selectedChannel.getImage_url());
//                selected.setArguments(args);
//
//                ((Video_playing) selected).setContext(context);
//                FragmentTransaction ft = getFragmentManager().beginTransaction();
//                ft.replace(R.id.inflator ,selected);
//
//                ft.addToBackStack("asd");
//
//                ft.commit();

                Intent mIntent = new Intent(context, VideoPlaying_Activity.class);
                mIntent.addFlags(FLAG_ACTIVITY_NEW_TASK);

                mIntent.putExtra("specifiedChannel", selectedChannel.getName());
                mIntent.putExtra("image_url", selectedChannel.getImage_url());
                mIntent.putExtra("con", String.valueOf(context));
                mIntent.putExtra("playlistName", String.valueOf(selectedChannel.getPlaylist()));
                VideoPlaying_Activity.setContext(context);
                context.startActivity(mIntent);

//                ((Video_playing) selected).setContext(context);
//                getFragmentManager().beginTransaction().replace(R.id.inflator,
//                        selected).commit();

            }
        });



    }

}
