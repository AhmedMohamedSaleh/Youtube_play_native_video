package com.example.android.youtube_play_native_video_github.Models;

import java.util.ArrayList;

public class ChannelModel {

    private String name;
    private String id;
    private String image_url;

    public String getPlaylist() {
        return playlist;
    }

    public void setPlaylist(String playlist) {
        this.playlist = playlist;
    }

    private String playlist;

    private Boolean sup_state;
    private ArrayList<String> videosnames;

    public ChannelModel(String name, String id,String image_url,String playlistName) {
        this.name = name;
        this.id = id;
        this.image_url = image_url;
        this.playlist = playlistName;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }



    public Boolean getSup_state() {
        return sup_state;
    }

    public void setSup_state(Boolean sup_state) {
        this.sup_state = sup_state;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getVideos() {
        return videosnames;
    }

    public void setVideos(ArrayList<String> videos) {
        this.videosnames = videos;
    }
}
