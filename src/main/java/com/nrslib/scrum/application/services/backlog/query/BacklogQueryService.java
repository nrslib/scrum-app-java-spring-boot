package com.nrslib.scrum.application.services.backlog.query;

import com.nrslib.scrum.domain.models.userstory.UserStory;

import java.util.List;

public interface BacklogQueryService {
    List<UserStory> getAllUserStories();
}
