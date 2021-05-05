package com.nrslib.applicationsupportstack.domainsupport.valueobjects;

import lombok.Getter;

public class StringValueObject {
    @Getter
    private final String value;

    public StringValueObject(String value) {
        this.value = value;
    }
}
