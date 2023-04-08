package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.USERR;
import com.example.Ecommerce.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/User")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public USERR createUser(@RequestBody USERR userr){
        return userService.createUser(userr);
    }
}
