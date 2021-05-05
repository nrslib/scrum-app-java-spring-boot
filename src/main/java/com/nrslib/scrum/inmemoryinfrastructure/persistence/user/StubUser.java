package com.nrslib.scrum.inmemoryinfrastructure.persistence.user;

import com.nrslib.scrum.domain.models.user.UserContext;
import com.nrslib.scrum.domain.models.user.UserId;

public class StubUser implements UserContext {
    @Override
    public UserId getId() {
        return new UserId("stub-user-id");
    }
}
