package com.nrslib.applicationsupportstack.domainsupport.valueobjects;

import lombok.Getter;

import java.util.Objects;

public class StringValueObject {
    @Getter
    private final String value;

    public StringValueObject(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringValueObject that = (StringValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
