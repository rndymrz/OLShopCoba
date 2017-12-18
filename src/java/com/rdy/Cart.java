/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdy;

import com.rdy.dao.ProdukService;
import com.rdy.model.TblProduct;
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
@RequestMapping("/cart")
public class Cart {
    
    @Autowired
    ProdukService ps;

    CartBean keranjang = new CartBean();
    double totalHargaDalamCart;
    int key = 1;
    
    @RequestMapping()
    public String addSomething(HttpServletRequest request) {
        HttpSession hs = request.getSession();
        hs.setAttribute("msgcrt", "Isi Keranjang Belanjaan");
        
     return "cart";   
     
     
     
     
    }
    
    @RequestMapping(value = "/add/{productID}")
    public String addCart(@PathVariable Integer productID, Model model, HttpSession totalHarga, HttpSession session) {
        try {
            TblProduct prod = ps.findById(productID);
            totalHargaDalamCart = totalHargaDalamCart + prod.getHarga();

            keranjang.getCarts().put(key++, prod);
            int count = keranjang.getCarts().size();
//            System.out.println("tot: "+count);
            totalHarga.setAttribute("total", totalHargaDalamCart);
            model.addAttribute("carts", count);
            session.setAttribute("cart", keranjang);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/product/all";
    }
    
    @RequestMapping(value = "/show")
    public String showCart(Model model, HttpSession session) {
        return "carts";
    }
    
    @RequestMapping(value = "/{productID}/{value}")
    public String removeCart(@PathVariable Integer productID, @PathVariable Integer value, HttpSession totalHarga, Model model, HttpSession session) {

        try {
            TblProduct prod = ps.findById(productID);
            if (prod == null) {
                model.addAttribute("errMsg", "Belom ada barang yg dipilih");
                return "product";
            }
            totalHargaDalamCart = totalHargaDalamCart - prod.getHarga();
            keranjang.getCarts().remove(value, prod);
            int count = keranjang.getCarts().size();
            totalHarga.setAttribute("total", totalHargaDalamCart);
            model.addAttribute("carts", count);
            session.setAttribute("cart", keranjang);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "carts";
    }
    
}
