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

    private static final String TAG = "What";
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
            topic.setPrereqs(getPrereqs());
            topics.add(topic);
        }



        return topics;
    }

    private List<Topic> getPrereqs(){

        List<Topic> prereqs = new ArrayList<>();
        Topic prereq1 = new Topic();
        prereq1.setName("Prereq 1");
        Topic prereq2 = new Topic();
        prereq2.setName("Prereq 2");
        Topic prereq3 = new Topic();
        prereq3.setName("Prereq 3");
        Topic prereq4 = new Topic();
        prereq4.setName("Prereq 4");
        Topic prereq5 = new Topic();
        prereq5.setName("Prereq 5");

        prereqs.add(prereq1);
        prereqs.add(prereq2);
        prereqs.add(prereq3);
        prereqs.add(prereq4);
        prereqs.add(prereq5);

        return prereqs;

    }


    @Override
    public void itemClicked(Object object) {


        Intent intent = new Intent(this, TopicDetailActivity.class);
        Topic topic = (Topic)object;
        intent.putExtra("Topic", topic);
        startActivity(intent);
    }

}
