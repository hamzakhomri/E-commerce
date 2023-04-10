package com.example.Ecommerce.Services.UserAdresse;

import com.example.Ecommerce.Model.Useradresse;

public interface IUserAdresse {
    Useradresse create(Useradresse useradresse);
    Useradresse getOneByID(Long idUserAdresse);
}
