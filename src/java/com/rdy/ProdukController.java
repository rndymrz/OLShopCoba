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
import com.rdy.dao.ProdukService;
import com.rdy.model.TblProduct;
import java.util.List;
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
@RequestMapping("/product")
public class ProdukController {
    
    @Autowired
    ProdukService ps;

@RequestMapping(value = "/all")
    public String showAllProduct(Model model) {
        List<TblProduct> product = ps.findAll();
        model.addAttribute("product", product);
        return "product";
    }
    @RequestMapping(value="{id}")
    public String showDetailProduct(@PathVariable Integer id, Model model){
        TblProduct product = ps.findById(id);
        model.addAttribute("product", product);
        return "product";
}

    
    @RequestMapping()
    public String addSomething(HttpServletRequest request) {
        HttpSession hs = request.getSession();
        hs.setAttribute("dftrprdk", "Daftar Produk");

        return "product";
                
    }
    
}
