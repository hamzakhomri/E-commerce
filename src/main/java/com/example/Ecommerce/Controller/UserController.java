package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Userr;
import com.example.Ecommerce.Services.USer.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{IdUser}")//dont'Done

    public Userr GetUserByID(@PathVariable("IdUser")Long IdUser){
        return userService.getOneUserByID(IdUser);
    }

    @PutMapping("/{IdUser}")//Done
    public Userr updateUser(@PathVariable(name = "IdUser")Long IdUser, @RequestBody Userr userr){
        return userService.update(IdUser,userr);
    }

    @PostMapping()//Done
    public Userr createUser(@RequestBody Userr userr){
        return userService.create(userr);
    }
    @GetMapping()//Done
    public List<Userr> getAllUser(){
        return userService.getAllUer();
    }
    @DeleteMapping("/{IdUser}")//Done
    public void deteleUser(@PathVariable(name = "IdUser") Long IdUser){
        this.userService.deleteUser(IdUser);
    }

}
