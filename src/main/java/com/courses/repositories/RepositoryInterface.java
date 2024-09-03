package com.courses.repositories;

import java.util.ArrayList;

public interface RepositoryInterface<T,ID> {
    void create(T entity);
    void update(T entity);
    void delete(ID id);
    T findById(ID id);
    ArrayList<T> findAll();
}
