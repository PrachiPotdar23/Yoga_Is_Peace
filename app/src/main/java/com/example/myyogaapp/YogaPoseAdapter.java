package com.example.myyogaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class YogaPoseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<YogaPose> yogaPoses;

    public YogaPoseAdapter(Context context, ArrayList<YogaPose> yogaPoses) {
        this.context = context;
        this.yogaPoses = yogaPoses;
    }

    @Override
    public int getCount() {
        return yogaPoses.size();
    }

    @Override
    public Object getItem(int position) {
        return yogaPoses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_item_yoga_pose, parent, false);
        }

        YogaPose currentPose = yogaPoses.get(position);

        ImageView poseImageView = convertView.findViewById(R.id.pose_imageview);
        poseImageView.setImageResource(currentPose.getImageResourceId());

        TextView poseNameTextView = convertView.findViewById(R.id.pose_name_textview);
        poseNameTextView.setText(currentPose.getName());

        return convertView;
    }
}

