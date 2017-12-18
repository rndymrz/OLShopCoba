/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rdy.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "TBL_PRODUCT")
@NamedQueries({
    @NamedQuery(name = "TblProduct.findAll", query = "SELECT t FROM TblProduct t")
    , @NamedQuery(name = "TblProduct.findById", query = "SELECT t FROM TblProduct t WHERE t.id = :id")
    , @NamedQuery(name = "TblProduct.findByHarga", query = "SELECT t FROM TblProduct t WHERE t.harga = :harga")
    , @NamedQuery(name = "TblProduct.findByNamaproduct", query = "SELECT t FROM TblProduct t WHERE t.namaproduct = :namaproduct")})
public class TblProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HARGA")
    private Double harga;
    @Column(name = "NAMAPRODUCT")
    private String namaproduct;
    @ManyToMany(mappedBy = "tblProductList")
    private List<TblCart> tblCartList;

    public TblProduct() {
    }

    public TblProduct(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getHarga() {
        return harga;
    }

    public void setHarga(Double harga) {
        this.harga = harga;
    }

    public String getNamaproduct() {
        return namaproduct;
    }

    public void setNamaproduct(String namaproduct) {
        this.namaproduct = namaproduct;
    }

    public List<TblCart> getTblCartList() {
        return tblCartList;
    }

    public void setTblCartList(List<TblCart> tblCartList) {
        this.tblCartList = tblCartList;
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
        if (!(object instanceof TblProduct)) {
            return false;
        }
        TblProduct other = (TblProduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.rdy.model.TblProduct[ id=" + id + " ]";
    }
    
}
