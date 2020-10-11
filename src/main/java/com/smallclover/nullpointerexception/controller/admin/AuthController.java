package com.smallclover.nullpointerexception.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author Amadeus
 * @date 2019-12-17
 */
@Controller
@RequestMapping("/admin/login")
public class AuthController {

    @GetMapping(value = {"", "/"})
    public String login(){
        return "/admin/login";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "/admin/login";
    }
}
