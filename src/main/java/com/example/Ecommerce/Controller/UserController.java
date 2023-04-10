package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.USERR;
import com.example.Ecommerce.Services.USer.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping()
    public USERR createUser(@RequestBody USERR userr){
        return userService.create(userr);
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
    @DeleteMapping("/{IdUser}")
    public void deteleUser(@PathVariable(name = "IdUser") Long IdUser){
        this.userService.deleteUser(IdUser);
    }

}
