package com.nst.dms.service.base;

import java.util.Optional;

/**
 * Created by nmarkovi on 3/4/18.
 */
public interface BaseService<T> {

    public T save(T entity);

    public Optional<T> findById(Long id);

    public boolean deleteById(Long id);

}
