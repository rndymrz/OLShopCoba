/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *
 * @author user
 */


@Controller
@RequestMapping("/detailproduk")
public class DetailProduk {
    @RequestMapping()
    public String addSomething(HttpServletRequest request) {
        HttpSession hs = request.getSession();
        hs.setAttribute("dtlprdk", "Detail Produk");
        
     return "detailproduk";   
    }
}
