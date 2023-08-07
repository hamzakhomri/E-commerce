package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Userr;
import com.example.Ecommerce.Services.USer.IUserService;
import com.example.Ecommerce.Services.UserAdresse.IUserAdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Optional;

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
    public List<Optional<Userr>> getUserBynameUser(@RequestParam("nameUser") String nameUser){
        return userService.getOneBynameUser(nameUser);
    }
    @GetMapping("/{IdUser}")//'Done
    public Userr GetUserByID(@PathVariable("IdUser")Long IdUser){
        return userService.getOneUserByID(IdUser);
    }

    @PostMapping()//Don
    public Userr createUser(HttpServletRequest request, @RequestBody Userr userr) throws UnknownHostException, SocketException {
        System.out.println(request.getRemoteAddr());
        return userService.create(userr);
    }
    @GetMapping()//Done
    public List<Userr> getAllUser(){
        return userService.getAllUer();
    }
    @DeleteMapping("/{IdUser}")//Done
    public String deteleUser(@PathVariable(name = "IdUser") Long IdUser){
        this.userService.deleteUser(IdUser);
        return IdUser+": Deleted";
    }
}
