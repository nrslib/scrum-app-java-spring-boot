package com.nrslib.webapplication.models.backlog.index;

import java.util.List;

public class BacklogIndexResponseModel {
    public List<UserStorySummaryModel> summaries;

    public BacklogIndexResponseModel(List<UserStorySummaryModel> summaries) {
        this.summaries = summaries;
    }
}
