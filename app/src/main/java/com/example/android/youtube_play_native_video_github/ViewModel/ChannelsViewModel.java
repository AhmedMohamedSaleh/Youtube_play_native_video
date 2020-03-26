package com.example.android.youtube_play_native_video_github.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.youtube_play_native_video_github.Models.ChannelModel;

import java.util.ArrayList;

public class ChannelsViewModel extends ViewModel {

    public MutableLiveData<ArrayList<ChannelModel>> mutableLiveData = new MutableLiveData<>();
    public MutableLiveData<ChannelModel> fragement = new MutableLiveData<>();

    public void setThe_intendedChannel(ChannelModel specifiedChannel){
        fragement.setValue(specifiedChannel);
    }

    public void getChannels(){
        ArrayList<ChannelModel> channels = getAllChannels();
        mutableLiveData.setValue(channels);
    }

    private ArrayList<ChannelModel> getAllChannels(){

        ArrayList<ChannelModel> channels =new ArrayList<>();
        channels.add(new ChannelModel("Ali Media Center", "https://www.youtube.com/channel/UCL42dFucNLBSqIgpw2ECNBg",
                "https://yt3.ggpht.com/a/AATXAJwhWMroySP4J87NQIzo0OVbDkDzGAgnLYyjFA=s88-c-k-c0xffffffff-no-rj-mo"
        , "PLMcnQ3olsBMQwwIPb3ts4MmlGZDFmnRqo"));
        channels.add(new ChannelModel("Android Developers", "https://www.youtube.com/channel/UCVHFbqXqoYvEWM1Ddxl0QDg",
                "https://yt3.ggpht.com/a/AATXAJz-xXlS2ao5fm1K97AbykChh3X6jnltOvyBBQ=s88-c-k-c0xffffffff-no-rj-mo"
        , "PLWz5rJ2EKKc_HHVa1JEL7vnBTr6fFezqO"));
        channels.add(new ChannelModel("coding with nerds", "https://www.youtube.com/channel/UCnDAXfhnL5j-KhHc1KhvXHw",
                "https://yt3.ggpht.com/a/AATXAJzfPgD-wLHJvZhq4CfQE69_KYMk7NEOnE_cGQ=s88-c-k-c0xffffffff-no-rj-mo"
        , "PLXjbGq0ERjFq0KvT7clQoOxM5TTd03yji"));
        channels.add(new ChannelModel("CodingWithMitch", "https://www.youtube.com/channel/UCoNZZLhPuuRteu02rh7bzsw",
                "https://yt3.ggpht.com/a/AATXAJzeVaKgaaldp7IpjgXSWImHTNV9kDqkrCJrMQ=s288-c-k-c0xffffffff-no-rj-mo"
        , "PLgCYzUzKIBE-8wE9Sv3yzYZlo70PBmFPz"));
        channels.add(new ChannelModel("Coding in Flow", "https://www.youtube.com/channel/UC_Fh8kvtkVPkeihBs42jGcA",
                "https://yt3.ggpht.com/a/AATXAJyfJAXXqdLLM-XjzTbCTOB3d-z7Q00VOMCyqg=s176-c-k-c0xffffffff-no-rj-mo"
        , "PLrnPJCHvNZuBAaN07RO7boUrFT4gkDlpL"));
        return channels;
    }

}
