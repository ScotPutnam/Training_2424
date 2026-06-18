package com.scotputnam.controllers;

import com.scotputnam.DAOs.AuthDAO;
import com.scotputnam.models.Employee;
import com.scotputnam.models.LoginDTO;
import io.javalin.http.Cookie;
import io.javalin.http.Handler;
import jakarta.servlet.http.HttpSession;

public class AuthController {

    AuthDAO aDAO = new AuthDAO();


    public static HttpSession ses;

    public Handler loginHandler = (ctx -> {
        LoginDTO loginDTO = ctx.bodyAsClass(LoginDTO.class);

        Employee loggedInEmployee = aDAO.login(loginDTO.getFirst_Name(), loginDTO.getLast_Name());

        System.out.println(loggedInEmployee);

        // TODO: ???
        if(loggedInEmployee!=null){
            
        }

    });
}
