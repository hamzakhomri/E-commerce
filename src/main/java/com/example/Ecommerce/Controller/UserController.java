package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Userr;
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
    public Userr createUser(@RequestBody Userr userr){
        return userService.create(userr);
    }
    @GetMapping()
    public List<Userr> getAllUser(){
        return userService.getAllUer();
    }
    @GetMapping("/{IdUser}")
    public Userr GetUserByName(@RequestParam("IdUser")Long IdUser){
        return userService.getOneUserByID(IdUser);
    }

    @PutMapping("/{IdUser}")
    public Userr updateUser(@PathVariable(name = "IdUser")Long IdUser, @RequestBody Userr userr){
        return userService.updateUser(IdUser,userr);
    }
    @DeleteMapping("/{IdUser}")
    public void deteleUser(@PathVariable(name = "IdUser") Long IdUser){
        this.userService.deleteUser(IdUser);
    }

}
