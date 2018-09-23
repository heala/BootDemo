package com.syh;

import com.Application;
import com.syh.bean.Permission;
import com.syh.service.PermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class SpringTest {

    @Autowired
    private PermissionService permissionService;

    @Test
    public void test1(){
        Permission permission = new Permission(1,"张三","#",null,null);
        permissionService.selectOne(1);
    }
}
