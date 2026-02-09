package com.elias.model.dao;

import java.util.List;

public interface CommonDaoInt<T> {

    public void insert(final T paramT);

    public void update(final T paramT);

    public void delete(final T paramT);

    public List<T> searchAll();

}