package com.syh.controller;

import com.syh.bean.Permission;
import com.syh.common.base.BaseController;
import com.syh.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PermissionController extends BaseController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/pInfo/{pid}")
    public Permission getInfo(@PathVariable Integer pid){
        ModelAndView mv = new ModelAndView();
        Permission permission = permissionService.selectOne(pid);
        return permission;
    }

    @RequestMapping("/updatePinfo")
    public int updatePermission(){
        Permission permission = new Permission(1,"员工福利","#",null,null);
        int result = permissionService.updateOne(permission);
        return result;
    }
}
