package com.harbor.example.module.shared.domain;

import java.util.List;
import java.util.Objects;

public abstract class ListValueObject<T> {
    protected final List<T> value;

    public ListValueObject(List<T> value) {
        this.value = value;
    }

    public List<T> value() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListValueObject<?> that = (ListValueObject<?>) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
