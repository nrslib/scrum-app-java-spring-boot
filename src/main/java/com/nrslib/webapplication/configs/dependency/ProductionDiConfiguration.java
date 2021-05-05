package com.nrslib.webapplication.configs.dependency;

import com.nrslib.scrum.application.services.backlog.query.BacklogQueryService;
import com.nrslib.scrum.inmemoryinfrastructure.queryservices.InMemoryBacklogQueryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("production")
public class ProductionDiConfiguration {
//    @Bean
//    public BacklogQueryService backlogQueryService() {
//        return new InMemoryBacklogQueryService();
//    }
}
