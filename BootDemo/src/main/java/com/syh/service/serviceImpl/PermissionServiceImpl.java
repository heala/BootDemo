package com.syh.service.serviceImpl;

import com.syh.annotion.CacheValue;
import com.syh.bean.Permission;
import com.syh.common.base.AbstractService;
import com.syh.common.utils.SerializerUtils;
import com.syh.dao.PermissionMapper;
import com.syh.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends AbstractService<Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    @CacheValue(clazz = Permission.class, id=1, method = "putDataToCache")
    public Permission selectOne(Integer id) {
        return super.selectOne(id);
    }

    @Override
    public Integer updateOne(Permission permission) {
        redisUtil.putDataToCache(Permission.class.getName()+permission.getPid(), permission,0L);
        return super.updateOne(permission);
    }
}
