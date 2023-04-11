package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Useradresse;
import com.example.Ecommerce.Services.UserAdresse.IUserAdresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/useradresse")
public class UserAdresseController {
     @Autowired
    IUserAdresse iUserAdresse;
     @PostMapping("/user/{idUser}")
     public Useradresse assignnewToUserAdresse(@PathVariable("idUser")Long idUser,@RequestBody Useradresse useradresse){
         return iUserAdresse.assign(idUser,useradresse);
     }









     @PostMapping()
    public Useradresse save(@RequestBody Useradresse useradresse){
         return iUserAdresse.create(useradresse);
     }
     @GetMapping("/{idUserAdresse}")
    public Useradresse GetOneById(@PathVariable(name = "idUserAdresse")Long idUserAdresse){
         return iUserAdresse.getOneByID(idUserAdresse);
     }

     @GetMapping()
    public List<Useradresse> getAll(){
         return iUserAdresse.getlAll();
     }

}