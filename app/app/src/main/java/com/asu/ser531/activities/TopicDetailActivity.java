package com.asu.ser531.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.asu.ser531.R;
import com.asu.ser531.model.Topic;

import androidx.appcompat.app.AppCompatActivity;

public class TopicDetailActivity extends AppCompatActivity {

    private static final String TAG = "TopicDetailActivity";

    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);
        textView = findViewById(R.id.textName);

        Topic topic = (Topic) getIntent().getSerializableExtra("Topic");

        Log.d(TAG, "onCreate: "+topic);
        textView.setText(topic.toString());

    }
}
