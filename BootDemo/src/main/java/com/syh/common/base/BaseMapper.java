package com.syh.common.base;

import java.util.List;

public interface BaseMapper<T> {

    T selectOne(Integer id);

    Integer deleteOne(Integer id);

    Integer deleteByT(T t);

    Integer deleteById(Integer id);

    Integer updateOne(T t);

    List<T> findAll();

    List<T> findByParam(Integer id);
}
