package com.asu.ser531.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.asu.ser531.ItemClickListener;
import com.asu.ser531.R;
import com.asu.ser531.adapters.TopicAdapter;
import com.asu.ser531.model.Topic;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SubTopicListActivity extends AppCompatActivity implements ItemClickListener {

    private static final String TAG = "SubTopicListActivity";
    private RecyclerView subtopicRecyclerView;
    private TopicAdapter adapter;
    private LinearLayoutManager llm;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Topic topic = (Topic) getIntent().getSerializableExtra("Topic");
        Log.d(TAG, "onCreate: "+topic);
        getSupportActionBar().setTitle(topic.getName());

        subtopicRecyclerView = findViewById(R.id.topicRV);
        llm = new LinearLayoutManager(this);
        adapter = new TopicAdapter(this, getDummySubTopics());
        subtopicRecyclerView.setLayoutManager(llm);
        subtopicRecyclerView.setAdapter(adapter);

    }

    private List<Topic> getDummySubTopics(){
        List<Topic> topics = new ArrayList<>();

        for(int i=0;i<20;i++){
            Topic topic = new Topic();
            topic.setName("Sub Topic: "+i);
            topics.add(topic);
        }

        return topics;
    }


    @Override
    public void itemClicked(Object object) {

        Intent intent = new Intent(this, TopicDetailActivity.class);
        Topic topic = (Topic)object;
        intent.putExtra("Topic", topic);
        startActivity(intent);
    }
}
