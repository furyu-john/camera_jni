package com.example.hellojni.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.VideoView;

import com.example.hellojni.HelloJni;
import com.example.hellojni.R;
import com.example.hellojni.model.Album;
import com.example.hellojni.model.Video;

import java.util.List;

/**
 * データリストからリストビューを生み出すためのカスタムアダプター
 */
public class ShowAlbumListAdapter extends ArrayAdapter<Album> {

    LayoutInflater layoutInflater;

    public ShowAlbumListAdapter(Context context, int resource, List<Album> objects) {
        super(context, 0, objects);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.template_show_album_list, null);
        }

        Album data = getItem(position);
        VideoView videoView = (VideoView) convertView.findViewById(R.id.video);
        videoView.setVideoPath(Environment.getExternalStorageDirectory().getPath() + data.image.path);
        videoView.start();

        return convertView;
    }
}

