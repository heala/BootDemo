package com.syh.common.base;

import com.syh.common.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@Service
public abstract class AbstractService<T> implements BaseService<T> {

    public static final Logger logger = LoggerFactory.getLogger(AbstractService.class);

    protected Class<T> clazz;

    public AbstractService(){
        Class<T> tClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.clazz=tClass;
        logger.debug("获取的class信息：" + clazz.getName());
    }

    @Autowired
    private BaseMapper<T> baseMapper;

    @Resource
    protected RedisUtil redisUtil;

    @Override
    public T selectOne(Integer id) {
        logger.debug("获取的class信息：" + clazz.getName());
        T dataFromCache = (T) redisUtil.getDataFromCache(clazz.getName() + id);
        if (dataFromCache == null) {
            logger.debug("从数据库获取数据");
            dataFromCache = baseMapper.selectOne(id);
        }
        return dataFromCache;
    }

    @Override
    public Integer deleteOne(Integer id) {
        return baseMapper.deleteOne(id);
    }

    @Override
    public Integer deleteByT(T t) {
        return baseMapper.deleteByT(t);
    }

    @Override
    public Integer updateOne(T t) {
        return baseMapper.updateOne(t);
    }

    @Override
    public List<T> findAll() {
        return baseMapper.findAll();
    }

    @Override
    public List<T> findByParam(Integer id) {
        return baseMapper.findByParam(id);
    }

    @Override
    public Integer deleteById(Integer id) {
        return baseMapper.deleteById(id);
    }
}
