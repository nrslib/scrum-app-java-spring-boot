package com.nrslib.webapplication.models.backlog.get;

public class UserStoryModel {
    public final String id;
    public final String story;

    public UserStoryModel(String id, String story) {
        this.id = id;
        this.story = story;
    }
}
