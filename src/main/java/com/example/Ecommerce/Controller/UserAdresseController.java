package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.Useradresse;
import com.example.Ecommerce.Services.UserAdresse.IUserAdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/useradresse")
public class UserAdresseController {
     @Autowired
     IUserAdresseService iUserAdresseService;
//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°° GET °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
    @GetMapping()
    public List<Useradresse> getAll(){
        return iUserAdresseService.getlAll();
    }

    @GetMapping("/{idUserAdresse}")
    public Useradresse GetOneById(@PathVariable(name = "idUserAdresse")Long idUserAdresse){
        return iUserAdresseService.getOneByID(idUserAdresse);
    }
    @GetMapping("/getbyname/{nameUser}")
    private List<Optional<Useradresse>>getBynameUser(@PathVariable(name = "nameUser") String nameUser){
        return iUserAdresseService.findByUserr_NameUserStartsWith(nameUser);
    }

    //°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°° END GET °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
    @PutMapping("/{idUserAdresse}")
    public Useradresse update(@PathVariable Long idUserAdresse,@RequestBody Useradresse useradresse){
        return iUserAdresseService.update(idUserAdresse,useradresse);
    }

    @PostMapping()
    public Useradresse save(@RequestBody Useradresse useradresse){
        return iUserAdresseService.create(useradresse);
    }

     @PostMapping("user/{idUser}")
    public Useradresse assignToUser(@PathVariable Long idUser, @RequestBody Useradresse useradresse ){
       useradresse.setIdUserAdresse(idUser);
         return iUserAdresseService.assign(idUser,useradresse);
     }
s}