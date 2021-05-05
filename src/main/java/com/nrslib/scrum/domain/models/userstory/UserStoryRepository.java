package com.nrslib.scrum.domain.models.userstory;

import java.util.Optional;

public interface UserStoryRepository {
    Optional<UserStory> find(UserStoryId id);
    void save(UserStory story);
    void delete(UserStory story);
}
