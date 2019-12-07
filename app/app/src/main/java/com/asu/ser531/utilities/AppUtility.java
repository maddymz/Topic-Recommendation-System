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

        topic.setPrereqs(prereqs);

        return topic;
    }

    public static void openInBrowser(Context context, String url){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        context.startActivity(browserIntent);
    }

    public static void openInYouTube(String url){

    }


    public static String getCleanSubtoipc(String input){

        input = input.replace("http://127.0.0.1:3333/", "");
        input = input.replace("%2C+", " ");
        input = input.replace("+", " ");


        return input;
    }


    public static String getStringWithPlus(String input) {

        input = input.trim();
        input = input.replace(" ","+");

        return input;

    }


}
