package com.example.android.youtube_play_native_video_github.Netwrok;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

public class Download_and_load_Image {
    private static String TAG = "Download_and_load_Image";

    public static void load_images(final String image_url, ImageView imageView, Context context){
        Picasso p = new Picasso.Builder(context)
                .memoryCache(new LruCache(24000))
                .build();
        RequestCreator requestCreator = p.load(image_url);
        requestCreator.resize(100, 60)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d(TAG, "onSuccess: ");
                        Log.d("yes", image_url);
                      //  Toast.makeText(context, channels.get(position).getName(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError() {
                        Log.d("no",  image_url);
                     //   Toast.makeText(context, "no :- " + channels.get(position).getName(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
