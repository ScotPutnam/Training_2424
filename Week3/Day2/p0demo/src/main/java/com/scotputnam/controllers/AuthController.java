package com.scotputnam.controllers;

import com.scotputnam.DAOs.AuthDAO;
import com.scotputnam.models.Employee;
import com.scotputnam.models.LoginDTO;
import io.javalin.http.Cookie;
import io.javalin.http.Handler;
import io.javalin.http.HttpStatus;
import jakarta.servlet.http.HttpSession;

public class AuthController {

    AuthDAO aDAO = new AuthDAO();


    public static HttpSession ses;

    public Handler loginHandler = (ctx -> {
        LoginDTO loginDTO = ctx.bodyAsClass(LoginDTO.class);

        Employee loggedInEmployee = aDAO.login(loginDTO.getFirst_name(), loginDTO.getLast_name());

        System.out.println(loggedInEmployee);

        if(loggedInEmployee!=null){

            //this is how we create a session
            ses= ctx.req().getSession();

            //we can use setAttribute() to set certain values to certain keys
            //THIS IS HOW WE CAN SAVE DATA IN A SESSION
            ses.setAttribute("employee_id",loggedInEmployee.getEmployee_id());

            ctx.json(loggedInEmployee);
            ctx.status(HttpStatus.ACCEPTED);
        } else {
            ctx.status(HttpStatus.UNAUTHORIZED);
        }

    });
}
