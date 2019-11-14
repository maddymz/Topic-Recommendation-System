package com.asu.ser531.activities;

import android.content.Intent;
import android.os.Bundle;

import com.asu.ser531.ItemClickListener;
import com.asu.ser531.R;
import com.asu.ser531.adapters.TopicAdapter;
import com.asu.ser531.model.Topic;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class TopicListActivity extends AppCompatActivity implements ItemClickListener {


    private RecyclerView topicRecyclerView;
    private TopicAdapter adapter;
    private LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topicRecyclerView = findViewById(R.id.topicRV);
        llm = new LinearLayoutManager(this);
        adapter = new TopicAdapter(this, getDummyTopics());

        topicRecyclerView.setLayoutManager(llm);
        topicRecyclerView.setAdapter(adapter);
    }


    private List<Topic> getDummyTopics(){

        List<Topic> topics = new ArrayList<>();

        for(int i=0;i<20;i++){
            Topic topic = new Topic();
            topic.setName("Topic: "+i);
            topics.add(topic);
        }

        return topics;
    }

    @Override
    public void itemClicked(Object object) {

        Intent intent = new Intent(this, SubTopicListActivity.class);
        Topic topic = (Topic)object;
        intent.putExtra("Topic", topic);
        startActivity(intent);

    }
}
