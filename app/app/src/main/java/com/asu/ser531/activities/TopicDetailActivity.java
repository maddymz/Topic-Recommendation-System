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

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TopicDetailActivity extends YouTubeBaseActivity implements ItemClickListener, YouTubePlayer.OnInitializedListener {

    private static final String TAG = "TopicDetailActivity";
    private TextView textView;
    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubeView;


    private RecyclerView prereqRv;
    private TopicAdapter adapter;
    private LinearLayoutManager llm;


    private Topic topic;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);
        getDummyTopic();
        getTopicFromIntent();
        textView = findViewById(R.id.prereqText);
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
        Log.d(TAG, "getTopicFromIntent: "+topic.toString());
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
            player.cueVideo("fhWaJi1Hsfo"); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
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
}
