package com.nrslib.scrum.application.services.backlog;

import lombok.Getter;

@Getter
public class BacklogAddUserStoryCommand {
    private final String story;
    private String demo;

    public BacklogAddUserStoryCommand(String story) {
        this.story = story;
    }

    public BacklogAddUserStoryCommand(String story, String demo) {
        this(story);

        this.demo = demo;
    }
}
