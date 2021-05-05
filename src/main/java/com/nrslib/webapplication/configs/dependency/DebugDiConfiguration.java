package com.nrslib.webapplication.configs.dependency;

import com.nrslib.scrum.application.services.backlog.BacklogApplicationService;
import com.nrslib.scrum.application.services.backlog.query.BacklogQueryService;
import com.nrslib.scrum.domain.models.user.UserContext;
import com.nrslib.scrum.domain.models.userstory.UserStoryRepository;
import com.nrslib.scrum.inmemoryinfrastructure.persistence.user.StubUser;
import com.nrslib.scrum.inmemoryinfrastructure.persistence.userstory.InMemoryUserStoryRepository;
import com.nrslib.scrum.inmemoryinfrastructure.queryservices.InMemoryBacklogQueryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.context.annotation.RequestScope;

@Configuration
@Profile("debug")
public class DebugDiConfiguration {
    @Bean
    public UserContext userContext() {
        return new StubUser();
    }

    @Bean
    public UserStoryRepository userStoryRepository() {
        return new InMemoryUserStoryRepository();
    }

    @Bean
    @RequestScope
    public BacklogQueryService backlogQueryService() {
        return new InMemoryBacklogQueryService((InMemoryUserStoryRepository) userStoryRepository());
    }

    @Bean
    @RequestScope
    public BacklogApplicationService backlogApplicationService() {
        return new BacklogApplicationService(userContext(), userStoryRepository());
    }
}