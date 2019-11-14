package com.asu.ser531.activities;

import android.os.Bundle;
import android.util.Log;

import com.asu.ser531.R;
import com.asu.ser531.model.Topic;

import java.security.PublicKey;

import androidx.appcompat.app.AppCompatActivity;

public class SubTopicListActivity extends AppCompatActivity {


    private static final String TAG = "SubTopicListActivity";
    
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_topic);


        Topic topic = (Topic) getIntent().getSerializableExtra("Topic");

        Log.d(TAG, "onCreate: "+topic);


    }


}
