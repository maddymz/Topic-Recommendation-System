package com.asu.ser531.utilities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.asu.ser531.model.Topic;

import java.util.ArrayList;
import java.util.List;

public class AppUtility {

    public static Topic getDummyTopic(){
        Topic topic = new Topic();
        topic.setName("Probability Theorem");
        topic.setDescription("lorem ipsumorem ipsumorem ipsumorem ipsumorem ipsumorem ipsumorem ipsumorem ipsumorem ipsum");

        List<String> researchLinks = new ArrayList<>();
        researchLinks.add("https://www.dartmouth.edu/~chance/teaching_aids/books_articles/probability_book/amsbook.mac.pdf");
        researchLinks.add("http://www.iiserpune.ac.in/~ayan/MTH201/Sahoo_textbook.pdf");
        topic.setResearchLinks(researchLinks);

        List<String> videoLinks = new ArrayList<>();
        videoLinks.add("https://www.youtube.com/watch?v=uzkc-qNVoOk");
        videoLinks.add("https://www.youtube.com/watch?v=KzfWUEJjG18");
        topic.setVideoLinks(videoLinks);

        return topic;
    }


    public static void openInBrowser(Context context, String url){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(browserIntent);
    }

    public static void openInYouTube(String url){

    }


}
