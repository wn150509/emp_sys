package com.lx.emp.controller;

import com.lx.emp.pojo.Permission;
import com.lx.emp.service.PermissionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 76452
 */
@RestController
@CrossOrigin
@RequestMapping("/permission")
public class PermissionController {

    @Resource
    private PermissionService permissionService;

    @GetMapping("/list")
    public List<Permission> list(){
        return permissionService.findAll();
    }
}
