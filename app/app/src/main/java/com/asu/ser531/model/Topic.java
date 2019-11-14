package com.asu.ser531.model;

import java.util.List;

public class Topic {

    private String name;
    private String description;
    private List<String> videoLinks;
    private List<String> researchLinks;

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
}
