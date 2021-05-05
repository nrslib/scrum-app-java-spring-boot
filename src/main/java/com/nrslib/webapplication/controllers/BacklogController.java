package com.nrslib.webapplication.controllers;

import com.nrslib.scrum.application.services.backlog.BacklogAddUserStoryCommand;
import com.nrslib.scrum.application.services.backlog.BacklogApplicationService;
import com.nrslib.scrum.application.services.backlog.query.BacklogQueryService;
import com.nrslib.webapplication.models.backlog.get.BacklogGetResponseModel;
import com.nrslib.webapplication.models.backlog.index.BacklogIndexResponseModel;
import com.nrslib.webapplication.models.backlog.get.UserStoryModel;
import com.nrslib.webapplication.models.backlog.index.UserStorySummaryModel;
import com.nrslib.webapplication.models.backlog.post.BacklogPostRequestModel;
import com.nrslib.webapplication.models.backlog.put.BacklogPutRequestModel;
import org.springframework.web.bind.annotation.*;

import java.beans.ConstructorProperties;

@RestController
@RequestMapping("/api/backlog")
public class BacklogController {
    private final BacklogQueryService queryService;
    private final BacklogApplicationService backlogApplicationService;

    @ConstructorProperties({"queryService", "backlogApplicationService"})
    public BacklogController(BacklogQueryService queryService, BacklogApplicationService backlogApplicationService) {
        this.queryService = queryService;
        this.backlogApplicationService = backlogApplicationService;
    }

    @GetMapping
    public BacklogIndexResponseModel index() {
        var stories = queryService.getAllUserStories();
        var summaries = stories
                .stream()
                .map(x -> new UserStorySummaryModel(x.getId().getValue()))
                .toList();

        return new BacklogIndexResponseModel(summaries);    }

    @GetMapping("/{id}")
    public BacklogGetResponseModel get(@PathVariable("id") String id) {
        var optTestUser = backlogApplicationService.getUserStory(id);

        return optTestUser
                .map(x -> new BacklogGetResponseModel(
                        new UserStoryModel(x.getId().getValue(), x.getStory())))
                .orElse(null);
    }

    @PostMapping
    public void post(@ModelAttribute BacklogPostRequestModel request) {
        var command = new BacklogAddUserStoryCommand(request.getStory());
        backlogApplicationService.addUserStory(command);
    }

    @PutMapping("/{id}")
    public void put(@PathVariable("id") String id, @ModelAttribute BacklogPutRequestModel request) {
        backlogApplicationService.estimateUserStory(id, request.getEstimation());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        backlogApplicationService.deleteUserStory(id);
    }
}
