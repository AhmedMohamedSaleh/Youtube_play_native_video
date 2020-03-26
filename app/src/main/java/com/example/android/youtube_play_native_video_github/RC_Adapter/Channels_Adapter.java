package com.example.android.youtube_play_native_video_github.RC_Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.youtube_play_native_video_github.Models.ChannelModel;
import com.example.android.youtube_play_native_video_github.Netwrok.Download_and_load_Image;
import com.example.android.youtube_play_native_video_github.R;
import com.example.android.youtube_play_native_video_github.ViewModel.ChannelsViewModel;

import java.util.ArrayList;

public class Channels_Adapter extends RecyclerView.Adapter<Channels_Adapter.myViewHolder> {

    private ArrayList<ChannelModel> channels ;

    private Context context;
    private ChannelsViewModel mViewModel;

    public void setContext(Context context) {
        this.context = context;
    }

    private String TAG = "Channels_Adapter";

    public Channels_Adapter(ArrayList<ChannelModel> h , ChannelsViewModel mViewModel) {
        channels = h;
        this.mViewModel = mViewModel;
    }

    @NonNull
    @Override
    public Channels_Adapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_row, parent, false);

        return new myViewHolder(view);
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

        TextView channelName;
        ToggleButton supscribing_button;
        ImageView imageView;
        LinearLayout LL_row;

        public myViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.icon);
            channelName =  view.findViewById(R.id.channelName);
            supscribing_button = view.findViewById(R.id.supscribing);
            LL_row = view.findViewById(R.id.row);

            LL_row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "LL_row_onClick: " + channelName.getText() );
                    int index=0;
                    for (int i=0;i<channels.size();i++){
                        if (channels.get(i).getName().equals((String) channelName.getText())){
                            index = i;
                        }
                    }
                    mViewModel.setThe_intendedChannel(channels.get(index));
                }
            });

            supscribing_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!supscribing_button.isChecked()) {

                        supscribing_button.setTextColor(context.getResources().getColor(R.color.gray));
                        supscribing_button.setBackgroundColor(context.getResources().getColor(R.color.white));
                    } else {

                        supscribing_button.setTextColor(context.getResources().getColor(R.color.white));
                        supscribing_button.setBackgroundColor(context.getResources().getColor(R.color.red));
                    }

                }
            });
      }
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.channelName.setText(channels.get(position).getName());

        Download_and_load_Image.load_images(channels.get(position).getImage_url(),holder.imageView,context);
    }

    @Override
    public int getItemCount() {
        return channels.size();
    }
}
