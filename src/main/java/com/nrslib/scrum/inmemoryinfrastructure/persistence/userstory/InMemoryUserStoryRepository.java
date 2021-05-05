package com.nrslib.scrum.inmemoryinfrastructure.persistence.userstory;

import com.nrslib.applicationsupportstack.domainsupport.repository.InMemoryCrudRepository;
import com.nrslib.scrum.domain.models.userstory.UserStory;
import com.nrslib.scrum.domain.models.userstory.UserStoryId;
import com.nrslib.scrum.domain.models.userstory.UserStoryRepository;

public class InMemoryUserStoryRepository extends InMemoryCrudRepository<UserStoryId, UserStory> implements UserStoryRepository {
    @Override
    protected UserStoryId getKey(UserStory value) {
        return value.getId();
    }

    @Override
    protected UserStory deepClone(UserStory value) {
        return new UserStory(value.getId(), value.getStory(), value.getEstimation());
    }
}
