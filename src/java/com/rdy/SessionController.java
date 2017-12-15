/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/product")
public class SessionController {
    
    @RequestMapping()
    public String addSomething(HttpServletRequest request) {
        HttpSession hs = request.getSession();
        hs.setAttribute("pesan", "Daftar Barang");
//        Employee staf = new Employee("Rini S", 450000);
//        hs.setAttribute("staf", staf);
//        Cart cart = (Cart) hs.getAttribute("cart");
//        if (cart==null) {
//            cart = new Cart();
//           
//        } 
//        Product p = new Product("Kacang Goreng", 1000);
//        Product m = new Product("Indomie", 4500);
//        cart.getCartItems().put(1, p);
//        cart.getCartItems().put(22, m );
//        hs.setAttribute("cart", cart);
        return "product";
                
    }
    
}
