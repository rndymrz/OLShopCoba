/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdy;

import com.rdy.dao.ProdukService;
import com.rdy.model.TblProduct;
import java.util.Map;
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
public class CartController {
    
    @Autowired
    ProdukService ps;

    CartBean cart;
    double totalHargaDalamCart;
    int key = 1;

    public CartController() {
        cart = new CartBean();
    }

    @RequestMapping(value = "/add/{productID}")
    public String addCart(@PathVariable Integer productID, Model model, HttpSession session) {
        try {
//           cart =new CartBean();
            TblProduct prod = ps.findById(productID);

            cart.getCarts().put(key++, prod);
            int count = cart.getCarts().size();
//            System.out.println("tot: "+count);
            Double tot = totalHargaDalamCart + prod.getHarga();
            model.addAttribute("carts", tot);
            session.setAttribute("cart", cart);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/product/all";
    }

    @RequestMapping(value = "/show")
    public String showCart(Model model, HttpSession session) {
        Map<Integer, TblProduct> cartsa = cart.getCarts();
        Double total = 0.0;
        for (Map.Entry<Integer, TblProduct> entry : cartsa.entrySet()) {
            TblProduct value = entry.getValue();
            total = total + value.getHarga();
        }
        totalHargaDalamCart = total;
        model.addAttribute("carts", total);
        return "carts";
    }

    @RequestMapping(value = "/{productID}/{value}")
    public String removeCart(@PathVariable Integer productID, @PathVariable Integer value, HttpSession totalHarga, Model model) {

        try {
            TblProduct prod = ps.findById(productID);
            if (prod == null) {
                model.addAttribute("errMsg", "Cart Still Empty");
                return "product";
            }
            Double tot;
            totalHargaDalamCart = totalHargaDalamCart - prod.getHarga();
            cart.getCarts().remove(value, prod);
//            cart.getCarts().remove(ps);
            int count = cart.getCarts().size();
//            System.out.println("tot: "+count);
            model.addAttribute("carts", totalHargaDalamCart);

//            session.setAttribute("cart", cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "carts";
    }
    
}
