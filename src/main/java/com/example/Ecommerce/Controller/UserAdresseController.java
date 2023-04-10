package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Useradresse;
import com.example.Ecommerce.Services.UserAdresse.IUserAdresse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/useradresse")
public class UserAdresseController {
     @Autowired
    IUserAdresse iUserAdresse;
     @PostMapping()
    public Useradresse save(@RequestBody Useradresse useradresse){
         return iUserAdresse.create(useradresse);
     }
     @GetMapping("/{idUserAdresse}")
    public Useradresse GetOneById(@PathVariable(name = "idUserAdresse")Long idUserAdresse){
         return iUserAdresse.getOneByID(idUserAdresse);

     }
}