package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Useradresse;
import com.example.Ecommerce.Services.UserAdresse.IUserAdresseService;
import com.example.Ecommerce.Services.UserAdresse.UserAdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/useradresse")
public class UserAdresseController {
     @Autowired
     IUserAdresseService iUserAdresseService;
     @Autowired
    private UserAdresseService userAdresseService;

     @PostMapping()
    public Useradresse save(@RequestBody Useradresse useradresse){
         return iUserAdresseService.create(useradresse);
     }

    @GetMapping()
    public List<Useradresse> getAll(){
        return iUserAdresseService.getlAll();
    }

    @GetMapping("/{idUserAdresse}")
    public Useradresse GetOneById(@PathVariable(name = "idUserAdresse")Long idUserAdresse){
         return iUserAdresseService.getOneByID(idUserAdresse);
     }

}