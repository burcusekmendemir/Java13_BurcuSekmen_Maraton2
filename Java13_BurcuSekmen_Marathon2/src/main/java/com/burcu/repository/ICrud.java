package com.burcu.repository;

import java.util.List;
import java.util.Optional;

public interface ICrud <T,ID>{

    T save(T entity);
    Iterable<T> saveAll(Iterable<T> entities);
    Optional<T> findById(ID id);
    Optional<T> findByColumn(String column,Object value);
    boolean existById(ID id); // Idnin olup olmadığını boolean dönen method
    List<T> findAll();
    List<T> findByColumnAndValue(String column, Object value); // select * from tblurun where ad=?
    void deleteById(ID id);
    List<T> findAllEntity(T entity);
}
