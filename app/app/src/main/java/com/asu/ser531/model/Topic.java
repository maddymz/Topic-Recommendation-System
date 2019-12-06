package com.asu.ser531.model;

import java.io.Serializable;
import java.util.List;

public class Topic implements Serializable {

    private String name;
    private String description;
    private List<String> videoLinks;
    private List<String> researchLinks;
    private List<Topic> prereqs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getVideoLinks() {
        return videoLinks;
    }

    public void setVideoLinks(List<String> videoLinks) {
        this.videoLinks = videoLinks;
    }

    public List<String> getResearchLinks() {
        return researchLinks;
    }

    public void setResearchLinks(List<String> researchLinks) {
        this.researchLinks = researchLinks;
    }

    public List<Topic> getPrereqs() {
        return prereqs;
    }

    public void setPrereqs(List<Topic> prereqs) {
        this.prereqs = prereqs;
    }

    @Override
    public String toString(){

        if(prereqs!=null){
            return "Name: "+name+" "+prereqs.toString();
        }else {
            return "Name: "+name;
        }
    }
}
