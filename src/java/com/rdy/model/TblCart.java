/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdy.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "TBL_CART")
@NamedQueries({
    @NamedQuery(name = "TblCart.findAll", query = "SELECT t FROM TblCart t")
    , @NamedQuery(name = "TblCart.findById", query = "SELECT t FROM TblCart t WHERE t.id = :id")
    , @NamedQuery(name = "TblCart.findByJumlah", query = "SELECT t FROM TblCart t WHERE t.jumlah = :jumlah")
    , @NamedQuery(name = "TblCart.findByTotalharga", query = "SELECT t FROM TblCart t WHERE t.totalharga = :totalharga")})
public class TblCart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "JUMLAH")
    private Integer jumlah;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTALHARGA")
    private Double totalharga;

    public TblCart() {
    }

    public TblCart(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Double getTotalharga() {
        return totalharga;
    }

    public void setTotalharga(Double totalharga) {
        this.totalharga = totalharga;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCart)) {
            return false;
        }
        TblCart other = (TblCart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rdy.model.TblCart[ id=" + id + " ]";
    }
    
}
