/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdy;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class Welcome {
    
    @RequestMapping()
    public String welcome(Model model) {
        model.addAttribute("msg", "Selamat datang di ASDASD Shop");
        return "welcome";
    }
    
    @RequestMapping("/drink")
    public String drink(Model model)  {
        model.addAttribute("msg", "Mari, silakan minum");
        return "welcome";
    }
    
}
