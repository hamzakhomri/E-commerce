package com.example.Ecommerce.Controller.Userr;

import com.example.Ecommerce.Model.User.Useradresse;
import com.example.Ecommerce.Model.User.Userr;
import com.example.Ecommerce.Services.Userr.UserAdresse.USer.IUserService;
import com.example.Ecommerce.Services.Userr.UserAdresse.IUserAdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserAdresseService userAdresseService;

    @PutMapping("/{IdUser}")
    public Userr UpdateUser(@PathVariable Long IdUser,@RequestBody Userr userr){
        return userService.update(IdUser,userr);
    }

    @GetMapping("/filter")
    public Userr getUserBynameUser(@RequestParam("nameUser") String nameUser){
        return userService.getOneBynameUser(nameUser);
    }
    @GetMapping("/{IdUser}")//'Done
    public Userr GetUserByID(@PathVariable("IdUser")Long IdUser){
        return userService.getOneUserByID(IdUser);
    }

    @PostMapping()//Don
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
