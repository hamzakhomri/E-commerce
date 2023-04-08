package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.USERR;
import com.example.Ecommerce.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/User")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public USERR createUser(@RequestBody USERR userr){
        return userService.createUser(userr);
    }
    @GetMapping()
    public List<USERR> getAllUser(){
        return userService.getAllUer();
    }
    @GetMapping("/{IdUser}")
    public USERR GetUserByName(@RequestParam("IdUser")Long IdUser){
        return userService.getOneUserByID(IdUser);
    }

    @PutMapping("/{IdUser}")
    public USERR updateUser(@PathVariable(name = "IdUser")Long IdUser,@RequestBody USERR userr){
        return userService.updateUser(IdUser,userr);
    }

}
