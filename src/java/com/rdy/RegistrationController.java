/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdy;

import com.rdy.dao.UserService;
import com.rdy.model.TblUser;
import com.rdy.utils.PasswordDigest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    
    @Autowired
    UserService us;
   
    @RequestMapping() 
    public String registerForm(Model model) {
        RegisterFormBean registerBean = new RegisterFormBean();
        //registerBean.setLastName("Smith");
        model.addAttribute("registerBean", registerBean);
        return "registration";
    }
    
    @RequestMapping(value="/save") 
    public String saveRegistration(@ModelAttribute("registerBean") RegisterFormBean registerBean, 
            Model model) {
        TblUser user = new TblUser();
        String encryptedPassword = 
                PasswordDigest.createEncryptedPassword(registerBean.getPassword());
        user.setFirstname(registerBean.getFirstName());
        user.setLastname(registerBean.getLastName());
        user.setUsername(registerBean.getUsername());
        user.setPassword(registerBean.getPassword());
        user.setAlamat(registerBean.getAlamat());
        user.setEmail(registerBean.getEmail());
        user.setNotelp(registerBean.getNotelp());
        
        us.saveUser(user);
        
        model.addAttribute("data", registerBean);
        return "successregistration";
    }
    
}
