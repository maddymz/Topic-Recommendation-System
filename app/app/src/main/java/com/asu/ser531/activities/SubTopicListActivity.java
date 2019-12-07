package com.asu.ser531.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.asu.ser531.ItemClickCallBack;
import com.asu.ser531.ItemClickListener;
import com.asu.ser531.R;
import com.asu.ser531.adapters.AppStringAdapter;
import com.asu.ser531.adapters.TopicAdapter;
import com.asu.ser531.model.Topic;
import com.asu.ser531.sparqlQueries.AppQuery;
import com.asu.ser531.utilities.AppUtility;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SubTopicListActivity extends AppCompatActivity implements ItemClickCallBack {

    private static final String TAG = "What";
    private RecyclerView subtopicRecyclerView;
    private AppStringAdapter adapter;
    private LinearLayoutManager llm;

    private String topic;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topic = getIntent().getStringExtra("Topic");
        Log.d(TAG, "onCreate: "+topic);

        getSupportActionBar().setTitle(topic);

        subtopicRecyclerView = findViewById(R.id.topicRV);
        llm = new LinearLayoutManager(this);
        adapter = new AppStringAdapter(this, new ArrayList<String >());
        subtopicRecyclerView.setLayoutManager(llm);
        subtopicRecyclerView.setAdapter(adapter);

        new QueryAsyncTask().execute();


    }

    private List<Topic> getDummySubTopics(){
        List<Topic> topics = new ArrayList<>();

        ArrayList<String> researchLinks = new ArrayList<>();
        researchLinks.add("https://www.youtube.com/watch?v=f9XFM8YLccg");

        ArrayList<String> researchPapers = new ArrayList<>();
        researchPapers.add("https://www.math.ucsd.edu/~tkemp/Kemp-Research-2016.pdf");

        Topic topic = new Topic();
        topic.setName("Probability");
        topic.setDescription("This topic talks about the topicProbability. This secrion will help us understand, learn and find the pre requisite of this topic");
        topic.setPrereqs(getPrereqs());
        topic.setVideoLinks(researchLinks);
        topic.setResearchLinks(researchPapers);
        topics.add(topic);

        Topic topic1 = new Topic();
        topic1.setName("Randomness, Pseudorandomness, Quasirandomness");
        topic1.setDescription("This topic talks about the topicProbability. This secrion will help us understand, learn and find the pre requisite of this topic");
        topic1.setPrereqs(getPrereqs());
        topic1.setVideoLinks(researchLinks);
        topic1.setResearchLinks(researchPapers);
        topics.add(topic1);

        Topic topic2 = new Topic();
        topic2.setName("Randomization, hardware random number generator");
        topic2.setDescription("This topic talks about the topicProbability. This secrion will help us understand, learn and find the pre requisite of this topic");
        topic2.setPrereqs(getPrereqs());
        topic2.setVideoLinks(researchLinks);
        topic2.setResearchLinks(researchPapers);
        topics.add(topic2);

        Topic topic3 = new Topic();
        topic3.setName("Random sequence");
        topic3.setDescription("This topic talks about the topicProbability. This secrion will help us understand, learn and find the pre requisite of this topic");
        topic3.setPrereqs(getPrereqs());
        topic3.setVideoLinks(researchLinks);
        topic3.setResearchLinks(researchPapers);
        topics.add(topic3);

        Topic topic4 = new Topic();
        topic4.setName("Uncertainty");
        topic4.setDescription("This topic talks about the topicProbability. This secrion will help us understand, learn and find the pre requisite of this topic");
        topic4.setPrereqs(getPrereqs());
        topic4.setVideoLinks(researchLinks);
        topic4.setResearchLinks(researchPapers);
        topics.add(topic4);

        Topic topic5 = new Topic();
        topic5.setName("Statistical dispersion");
        topic5.setDescription("This topic talks about the topicProbability. This secrion will help us understand, learn and find the pre requisite of this topic");
        topic5.setPrereqs(getPrereqs());
        topic5.setVideoLinks(researchLinks);
        topic5.setResearchLinks(researchPapers);
        topics.add(topic5);

        Topic topic6 = new Topic();
        topic6.setName("Observational error");
        topic6.setDescription("This topic talks about the topicProbability. This secrion will help us understand, learn and find the pre requisite of this topic");
        topic6.setPrereqs(getPrereqs());
        topic6.setVideoLinks(researchLinks);
        topic6.setResearchLinks(researchPapers);
        topics.add(topic6);

        Topic topic7 = new Topic();
        topic7.setName("Equiprobable");
        topic7.setDescription("This topic talks about the topicProbability. This secrion will help us understand, learn and find the pre requisite of this topic");
        topic7.setPrereqs(getPrereqs());
        topic7.setVideoLinks(researchLinks);
        topic7.setResearchLinks(researchPapers);
        topics.add(topic7);

        Topic topic8 = new Topic();
        topic8.setDescription("This topic talks about the topicProbability. This secrion will help us understand, learn and find the pre requisite of this topic");
        topic8.setPrereqs(getPrereqs());
        topic8.setVideoLinks(researchLinks);
        topic8.setResearchLinks(researchPapers);
        topic8.setName("Average");
        topics.add(topic8);

        Topic topic9 = new Topic();
        topic9.setName("Probability interpretations");
        topic9.setDescription("This topic talks about the topicProbability. This secrion will help us understand, learn and find the pre requisite of this topic");
        topic9.setPrereqs(getPrereqs());
        topic9.setVideoLinks(researchLinks);
        topic9.setResearchLinks(researchPapers);
        topics.add(topic9);

        Topic topic10 = new Topic();
        topic10.setName("Markovian");
        topic10.setDescription("This topic talks about the topicProbability. This secrion will help us understand, learn and find the pre requisite of this topic");
        topic10.setPrereqs(getPrereqs());
        topic10.setVideoLinks(researchLinks);
        topic10.setResearchLinks(researchPapers);
        topics.add(topic10);

        Topic topic11 = new Topic();
        topic11.setName("Statistical regularity");
        topic11.setDescription("This topic talks about the topicProbability. This secrion will help us understand, learn and find the pre requisite of this topic");
        topic11.setPrereqs(getPrereqs());
        topic11.setVideoLinks(researchLinks);
        topic11.setResearchLinks(researchPapers);
        topics.add(topic11);

        Topic topic12 = new Topic();
        topic12.setName("Central tendency");
        topic12.setDescription("This topic talks about the topicProbability. This secrion will help us understand, learn and find the pre requisite of this topic");
        topic12.setPrereqs(getPrereqs());
        topic12.setVideoLinks(researchLinks);
        topic12.setResearchLinks(researchPapers);
        topics.add(topic12);

        Topic topic13 = new Topic();
        topic13.setName("Bean machine");
        topic13.setDescription("This topic talks about the topicProbability. This secrion will help us understand, learn and find the pre requisite of this topic");
        topic13.setPrereqs(getPrereqs());
        topic13.setVideoLinks(researchLinks);
        topic13.setResearchLinks(researchPapers);
        topics.add(topic13);

        return topics;
    }

    private List<Topic> getPrereqs(){

        List<Topic> prereqs = new ArrayList<>();
        Topic prereq1 = new Topic();
        prereq1.setName("Martingale representation theorem");
        Topic prereq2 = new Topic();
        prereq2.setName("Canonical correlation");
        Topic prereq3 = new Topic();
        prereq3.setName("Information geometry");
        Topic prereq4 = new Topic();
        prereq4.setName("Disintegration theorem");
        Topic prereq5 = new Topic();
        prereq5.setName("Extractor");

        prereqs.add(prereq1);
        prereqs.add(prereq2);
        prereqs.add(prereq3);
        prereqs.add(prereq4);
        prereqs.add(prereq5);

        return prereqs;

    }


    @Override
    public void itemClick(String name) {

        Intent intent = new Intent(this, TopicDetailActivity.class);
        intent.putExtra(name, "Topic");
//        Topic topic = (Topic)object;
//        intent.putExtra("Topic", topic);
        startActivity(intent);

    }


    class QueryAsyncTask extends AsyncTask<String,Integer,String> {

        private List<String> topics;

        public QueryAsyncTask(){
            this.topics = new ArrayList<>();
        }


        @Override
        protected String doInBackground(String... strings) {

            topics = AppQuery.getAllSubtopics(AppUtility.getStringWithPlus(topic), 20,0);

            return null;
        }


        @Override
        public void onPostExecute(String result)
        {
            adapter = new AppStringAdapter(SubTopicListActivity.this, topics);
            subtopicRecyclerView.setAdapter(adapter);

        }

        @Override
        public void onProgressUpdate(Integer... params)
        {
            // show in spinner, access UI elements
        }

    }
}
