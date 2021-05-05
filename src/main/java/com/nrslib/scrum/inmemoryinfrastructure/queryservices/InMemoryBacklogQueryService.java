package com.nrslib.scrum.inmemoryinfrastructure.queryservices;

import com.nrslib.scrum.application.services.backlog.query.BacklogQueryService;
import com.nrslib.scrum.domain.models.userstory.UserStory;
import com.nrslib.scrum.inmemoryinfrastructure.persistence.userstory.InMemoryUserStoryRepository;

import java.util.List;

public class InMemoryBacklogQueryService implements BacklogQueryService {
    private final InMemoryUserStoryRepository userStoryRepository;

    public InMemoryBacklogQueryService(InMemoryUserStoryRepository userStoryRepository) {
        this.userStoryRepository = userStoryRepository;
    }

    @Override
    public List<UserStory> getAllUserStories() {
        return userStoryRepository.keyToValue.values().stream().toList();
    }
}
