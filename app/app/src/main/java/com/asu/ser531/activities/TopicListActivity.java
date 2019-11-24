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

import java.io.Serializable;
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

        Topic topic = new Topic();
        topic.setName("General Aspects");
        topics.add(topic);
        Topic topic1 = new Topic();
        topic1.setName("Foundations of probability theory");
        topics.add(topic1);
        Topic topic2 = new Topic();
        topic2.setName("Random variables");
        topics.add(topic2);
        Topic topic3 = new Topic();
        topic3.setName("Condition Probability");
        topics.add(topic3);
        Topic topic4 = new Topic();
        topic4.setName("Theory of Probability Distribution");
        topics.add(topic4);
        Topic topic5 = new Topic();
        topic5.setName("Properties of Probability distribution");
        topics.add(topic5);
        Topic topic6 = new Topic();
        topic6.setName("Applied Probability");
        topics.add(topic6);
        Topic topic7 = new Topic();
        topic7.setName("Stochastic Processes");
        topics.add(topic7);
        Topic topic8 = new Topic();
        topic8.setName("Geometric Probability");
        topics.add(topic8);
        Topic topic9 = new Topic();
        topic9.setName("Gambling");
        topics.add(topic9);
        Topic topic10 = new Topic();
        topic10.setName("Coincidence");
        topics.add(topic10);
        Topic topic11 = new Topic();
        topic11.setName("Algorithmcs");
        topics.add(topic11);
        Topic topic12 = new Topic();
        topic12.setName("Financial Mathematics");
        topics.add(topic12);
        Topic topic13 = new Topic();
        topic13.setName("Genetics");
        topics.add(topic13);

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
