package com.menglang.student.service;

import java.io.Serializable;
import java.util.Optional;

public interface BaseService<T extends Serializable,R extends Serializable> {
    R create(T dto)  ;
    R update(Long id,T dto) ;
    R delete(Long id) ;
    Optional<R> getById(Long id);

}
