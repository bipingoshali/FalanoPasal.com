/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.falanopasal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author bipin
 */
@Controller
@RequestMapping("/")
public class AdminController {
    
    @RequestMapping("/admin/home")
    public String adminHomePage(){
        return "/admin/home";
    }
}
