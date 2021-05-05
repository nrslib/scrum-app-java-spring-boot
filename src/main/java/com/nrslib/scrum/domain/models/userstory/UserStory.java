package com.nrslib.scrum.domain.models.userstory;

import lombok.Getter;

import java.util.Objects;

public class UserStory {
    @Getter
    private final UserStoryId id;
    @Getter
    private String story;
    @Getter
    private int estimation;

    public UserStory(UserStoryId id, String story) {
        this.id = id;
        this.story = story;
    }

    public UserStory(UserStoryId id, String story, int estimation) {
        this(id, story);

        this.estimation = estimation;
    }

    public void estimate(int estimation) {
        if (estimation < 0) {
            throw new IllegalArgumentException("estimation must be positive numbers.");
        }

        this.estimation = estimation;
    }

    public void modifyStory(String story) {
        Objects.requireNonNull(story);

        this.story = story;
    }
}
