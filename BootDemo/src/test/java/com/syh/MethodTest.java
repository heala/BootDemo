package com.syh;

import com.alibaba.fastjson.JSONObject;
import com.syh.bean.Permission;
import org.junit.Test;

public class MethodTest {

    @Test
    public void test1(){
        Permission permission = new Permission(1, "a", "a", null, null);
        String o = (String) JSONObject.toJSONString(permission);
        System.out.println(o);
    }
}
