package com.cz.controller;

import com.cz.dto.DtoUser;
import com.cz.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jomalone_jia on 2017/11/8.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger _log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public Object test(){
        return "test";
    }

    @PostMapping("/register")
    public Object register(@RequestBody DtoUser dtoUser){
        _log.info(dtoUser.toString());
        try {
            userService.insertUser(dtoUser);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.badRequest();
    }
}