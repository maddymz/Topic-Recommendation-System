package com.asu.ser531.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.asu.ser531.R;
import com.asu.ser531.model.Topic;
import com.asu.ser531.utilities.AppUtility;

import androidx.appcompat.app.AppCompatActivity;

public class TopicDetailActivity extends AppCompatActivity {

    private static final String TAG = "TopicDetailActivity";

    private TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);
        textView = findViewById(R.id.textName);

        final String paperLink = AppUtility.getDummyTopic().getResearchLinks().get(0);

        textView.setText(paperLink);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppUtility.openInBrowser(TopicDetailActivity.this, paperLink);
            }
        });


//        Log.d(TAG, "onCreate: "+topic);
//        textView.setText(topic.toString());toString
    }

    private void getTopicFromIntent(){
        Topic topic = (Topic) getIntent().getSerializableExtra("Topic");
    }


}
