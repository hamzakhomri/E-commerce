package com.example.Ecommerce.Controller.Userr;

import com.example.Ecommerce.Model.User.Useradresse;
import com.example.Ecommerce.Model.User.Userr;
import com.example.Ecommerce.Services.Userr.UserAdresse.IUserAdresseService;
import com.example.Ecommerce.Services.Userr.UserAdresse.UserAdresseService;
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


    @PutMapping("/{idUserAdresse}")
    public Useradresse update(@PathVariable Long idUserAdresse,@RequestBody Useradresse useradresse){
        return iUserAdresseService.update(idUserAdresse,useradresse);
    }

    @GetMapping()
    public List<Useradresse> getAll(){
        return iUserAdresseService.getlAll();
    }

    @GetMapping("/{idUserAdresse}")
    public Useradresse GetOneById(@PathVariable(name = "idUserAdresse")Long idUserAdresse){
         return iUserAdresseService.getOneByID(idUserAdresse);
     }

     @GetMapping("/filter")
     public Useradresse GetLikeUsername(@PathVariable String nameUser){
        return userAdresseService.findByUserr_NameUserLike(nameUser);
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
}