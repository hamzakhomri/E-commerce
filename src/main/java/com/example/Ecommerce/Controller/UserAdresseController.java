package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Model.USERADRESSE;
import com.example.Ecommerce.Services.UserAdresse.IUserAdresseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/useradresse")
public class UserAdresseController {
    private IUserAdresseService iUserAdresseService;
    @GetMapping()
    public List<USERADRESSE> getAllUSerAdresse(){
        return iUserAdresseService.getAllUserAdresse();
    }

    @GetMapping("/{idUserAdresse}")
    public USERADRESSE getUserAdressebyId(@RequestParam("IdUserAdresse")Long idUserAdresse){
        return iUserAdresseService.getOneUserAdresseById(idUserAdresse);
    }

    @DeleteMapping("deleteuserdetail/{idUserAdresse}")
    public void DeleteUserDetail(@PathVariable("IdUserAdresse")Long idUserAdresse){
        iUserAdresseService.DeletUseradresse(idUserAdresse);
    }

}
