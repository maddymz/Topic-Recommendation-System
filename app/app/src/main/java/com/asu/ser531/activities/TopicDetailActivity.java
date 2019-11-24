package com.asu.ser531.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.asu.ser531.Config;
import com.asu.ser531.ItemClickListener;
import com.asu.ser531.R;
import com.asu.ser531.adapters.TopicAdapter;
import com.asu.ser531.model.Topic;
import com.asu.ser531.utilities.AppUtility;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TopicDetailActivity extends YouTubeBaseActivity implements ItemClickListener, YouTubePlayer.OnInitializedListener, View.OnClickListener {

    private static final String TAG = "TopicDetailActivity";
    private TextView textView, name, desc;
    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;

    private RecyclerView prereqRv;
    private TopicAdapter adapter;
    private LinearLayoutManager llm;
    private Topic topic;
    private TextView link1,link2,link3;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);
        textView = findViewById(R.id.prereqText);
        name = findViewById(R.id.name);
        desc = findViewById(R.id.desc);

        link1 = findViewById(R.id.link1);
        link2 = findViewById(R.id.link2);
        link3 = findViewById(R.id.link3);

        link1.setText("1) Probability Theory UCSD 2006");
        link2.setText("2) What is probability theory");
        link3.setText("3) Introduction to Probability By Charles M. Grinstead");

        link1.setOnClickListener(this);
        link2.setOnClickListener(this);
        link3.setOnClickListener(this);


        getTopicFromIntent();
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(Config.YOUTUBE_API_KEY, this);

        prereqRv = findViewById(R.id.prereqRV);
        llm = new LinearLayoutManager(this);
        adapter = new TopicAdapter(this, topic.getPrereqs(), true);
        Log.d(TAG, "onCreate: "+topic.getPrereqs());
        prereqRv.setLayoutManager(llm);
        prereqRv.setAdapter(adapter);
    }

    private void getTopicFromIntent(){
         topic = (Topic) getIntent().getSerializableExtra("Topic");
         name.setText(topic.getName());
         desc.setText(topic.getDescription());
    }

    private void getDummyTopic(){
        topic = AppUtility.getDummyTopic();
    }

    @Override
    public void itemClicked(Object object) {

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            player.cueVideo("f9XFM8YLccg"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = "Error";
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return youTubeView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.link1:
                opeLink(1);
                break;

            case R.id.link2:
                opeLink(2);
                break;

            case R.id.link3:
                opeLink(3);
                break;

            default:
        }
    }


    public void opeLink(int i){
        if(i==1){
            AppUtility.openInBrowser(this, "https://www.math.ucsd.edu/~tkemp/Kemp-Research-2016.pdf");
        }else if(i==2){
            AppUtility.openInBrowser(this, "https://www.ias.ac.in/article/fulltext/reso/020/04/0292-0310");
        }else {
            AppUtility.openInBrowser(this, "https://www.dartmouth.edu/~chance/teaching_aids/books_articles/probability_book/amsbook.mac.pdf");
        }
    }
}
