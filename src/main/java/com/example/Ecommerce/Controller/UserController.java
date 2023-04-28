package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.User.Useradresse;
import com.example.Ecommerce.Model.User.Userr;
import com.example.Ecommerce.Services.USer.IUserService;
import com.example.Ecommerce.Services.UserAdresse.IUserAdresseService;
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

    @GetMapping("/filter")
    public Userr getUserBynameUser(@RequestParam("nameUser") String nameUser){
        return userService.getOneBynameUser(nameUser);
    }

    @GetMapping("/{IdUser}")//'Done
    public Userr GetUserByID(@PathVariable("IdUser")Long IdUser){
        return userService.getOneUserByID(IdUser);
    }

    @PutMapping("/{IdUser}")//Done
    public Userr updateUser(@PathVariable Long IdUser, @RequestBody Userr userr)
    {
        Userr updateUser =userService.update(IdUser,userr);
        if (updateUser!=null){
            return ResponseEntity.ok(updateUser).getBody();
        }
        else {
            return null;
        }
    }

    @PutMapping("updates/{IdUser}")
    public ResponseEntity<?> updateUserAndAdresse(@PathVariable Long userrId, @RequestBody Userr userr, @RequestBody Useradresse useradresse) {
        userService.update2(userrId, userr.getUserAdresse().getUserr(), useradresse.getUserr().getUserAdresse());
        return ResponseEntity.ok().build();
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
