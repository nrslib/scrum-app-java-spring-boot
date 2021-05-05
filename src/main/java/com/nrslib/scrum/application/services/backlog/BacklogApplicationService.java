package com.nrslib.scrum.application.services.backlog;

import com.nrslib.applicationsupportstack.applicationsupport.exceptions.NotFoundException;
import com.nrslib.scrum.domain.models.user.UserContext;
import com.nrslib.scrum.domain.models.userstory.*;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public class BacklogApplicationService {
    private final UserContext userContext;
    private final UserStoryRepository userStoryRepository;

    public BacklogApplicationService(UserContext userContext, UserStoryRepository userStoryRepository) {
        this.userContext = userContext;
        this.userStoryRepository = userStoryRepository;
    }

    public Optional<UserStory> getUserStory(String aId) {
        Objects.requireNonNull(aId);

        var id = new UserStoryId(aId);

        return userStoryRepository.find(id);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void addUserStory(BacklogAddUserStoryCommand command) {
        Objects.requireNonNull(command.getStory());

        var id = new UserStoryId(UUID.randomUUID().toString());
        var story = new UserStory(id, command.getStory());

        userStoryRepository.save(story);
    }

    @Transactional
    public void estimateUserStory(String aId, int estimation) {
        Objects.requireNonNull(aId);

        var id = new UserStoryId(aId);
        var optStory = userStoryRepository.find(id);

        optStory.ifPresentOrElse(
                x -> {
                    x.estimate(estimation);
                    userStoryRepository.save(x);
                },
                () -> {
                    throw new NotFoundException("Unknown story of id: " + aId);
                }
        );
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void deleteUserStory(String aId) {
        Objects.requireNonNull(aId);

        var id = new UserStoryId(aId);
        var optStory = userStoryRepository.find(id);

        optStory.ifPresent(userStoryRepository::delete);
    }
}
