/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdy.dao;

import com.rdy.model.TblProduct;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Repository
@Transactional
public class ProdukService {
    @PersistenceContext
    private EntityManager em;

    public ProdukService() {
    }

    public ProdukService(EntityManager em) {
        this.em = em;
    }

    /**
     * @return the em
     */
    public EntityManager getEm() {
        return em;
    }

    /**
     * @param em the em to set
     */
    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    @Transactional
    public void addProduct(TblProduct prod){
        this.em.persist(prod);
    }
    
    public List<TblProduct> findAll(){
        List<TblProduct> prod;
        prod = this.em.createNamedQuery("TblProduct.findAll").getResultList();
        return prod;
    }
    
    public TblProduct findById(Integer id){
        return em.find(TblProduct.class, id);
    }
}
