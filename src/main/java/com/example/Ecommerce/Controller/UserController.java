package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Useradresse;
import com.example.Ecommerce.Model.Userr;
import com.example.Ecommerce.Services.USer.IUserService;
import com.example.Ecommerce.Services.UserAdresse.IUserAdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IUserAdresseService userAdresseService;

    @GetMapping("/filter")
    public Userr getUserBynameUser(@RequestParam("nameUser") String nameUser){
        return userService.getOneBynameUser(nameUser);
    }

    @GetMapping("/{IdUser}")//'Done
    public Userr GetUserByID(@PathVariable("IdUser")Long IdUser){
        return userService.getOneUserByID(IdUser);
    }

    @PutMapping("/{IdUser}/useradresse/{idUserAdresse}")//Done
    public Userr updateUser(@PathVariable Long IdUser, @PathVariable Long idUserAdresse, @RequestBody Userr userr,@RequestBody Useradresse useradresse)
    {
        Userr updateUser =userService.update(Long IdUser Userr userr);
        Useradresse update = userAdresseService.update(Long idUserAdresse,Useradresse useradresse)

        if (updateUser!=null){
            return ResponseEntity.ok(updateUser).getBody();
        }
        else {
            return null;
        }
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
