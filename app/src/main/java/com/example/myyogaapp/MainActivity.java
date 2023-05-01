package com.example.myyogaapp;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private TextView poseNameTextView;
    private ImageView imageView;

    private TextView timerTextView;

    private ArrayList<YogaPose> yogaPoses = new ArrayList<>();
    private int currentPoseIndex = 0;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poseNameTextView = findViewById(R.id.pose_name_textview);
        imageView = findViewById(R.id.imageview);


        gridView = findViewById(R.id.gridview);


        yogaPoses.add(new YogaPose("Mountain Pose", R.drawable.mountain_pose));
        yogaPoses.add(new YogaPose("Downward Dog", R.drawable.downward_facing_dog));
        yogaPoses.add(new YogaPose("Tree Pose", R.drawable.tree_pose));
        yogaPoses.add(new YogaPose("Triangle Pose", R.drawable.warrior_i_pose));
        yogaPoses.add(new YogaPose("Child's Pose", R.drawable.childs_pose));
        yogaPoses.add(new YogaPose("Chair pose", R.drawable.img_1));


        YogaPoseAdapter adapter = new YogaPoseAdapter(this, yogaPoses);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, FullScreenImageActivity.class);
                intent.putExtra("image_resource_id", yogaPoses.get(position).getImageResourceId());
                startActivity(intent);
            }
        });

    }
}





