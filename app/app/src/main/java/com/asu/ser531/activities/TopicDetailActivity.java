package com.asu.ser531.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.asu.ser531.ItemClickListener;
import com.asu.ser531.R;
import com.asu.ser531.adapters.TopicAdapter;
import com.asu.ser531.model.Topic;
import com.asu.ser531.utilities.AppUtility;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TopicDetailActivity extends AppCompatActivity implements ItemClickListener {

    private static final String TAG = "TopicDetailActivity";
    private TextView textView;

//    private RecyclerView prereqRv;
//    private TopicAdapter adapter;
//    private LinearLayoutManager llm;


    private Topic topic;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);
//        getDummyTopic();
        getTopicFromIntent();
        textView = findViewById(R.id.prereqText);
////        prereqRv = findViewById(R.id.prereqRV);
//        llm = new LinearLayoutManager(this);
//        adapter = new TopicAdapter(this, topic.getPrereqs());
//        Log.d(TAG, "onCreate: "+topic.getPrereqs());
//        prereqRv.setLayoutManager(llm);
//        prereqRv.setAdapter(adapter);
    }

    private void getTopicFromIntent(){
         topic = (Topic) getIntent().getSerializableExtra("Topic");
        Log.d(TAG, "getTopicFromIntent: "+topic.toString());
    }

    private void getDummyTopic(){
        topic = AppUtility.getDummyTopic();
    }

    @Override
    public void itemClicked(Object object) {

    }
}
