/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.entity.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "don_bussiness-info")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "DonBussinessInfo.findAll", query = "SELECT d FROM DonBussinessInfo d")})
public class DonBussinessInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "don366id")
    private BigDecimal id;
    @Column(name = "don366deleted")
    private Short deleted;
    @JoinColumn(name = "don360id", referencedColumnName = "don360id")
    @ManyToOne
    private DonCustomer don360id;
    @OneToMany(mappedBy = "don366id")
    private List<DonBussiness> donBussinessList;
    @OneToMany(mappedBy = "don366id")
    private List<DonCustomer> donCustomerList;
    @OneToMany(mappedBy = "don366id")
    private List<DonProducts> donProductsList;

    public DonBussinessInfo() {
    }

    public DonBussinessInfo(BigDecimal don366id) {
        this.id = don366id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Short getDeleted() {
        return deleted;
    }

    public void setDeleted(Short deleted) {
        this.deleted = deleted;
    }

    public DonCustomer getDon360id() {
        return don360id;
    }

    public void setDon360id(DonCustomer don360id) {
        this.don360id = don360id;
    }

    @XmlTransient
    public List<DonBussiness> getDonBussinessList() {
        return donBussinessList;
    }

    public void setDonBussinessList(List<DonBussiness> donBussinessList) {
        this.donBussinessList = donBussinessList;
    }

    @XmlTransient
    public List<DonCustomer> getDonCustomerList() {
        return donCustomerList;
    }

    public void setDonCustomerList(List<DonCustomer> donCustomerList) {
        this.donCustomerList = donCustomerList;
    }

    @XmlTransient
    public List<DonProducts> getDonProductsList() {
        return donProductsList;
    }

    public void setDonProductsList(List<DonProducts> donProductsList) {
        this.donProductsList = donProductsList;
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
        if (!(object instanceof DonBussinessInfo)) {
            return false;
        }
        DonBussinessInfo other = (DonBussinessInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonBussinessInfo[ don366id=" + id + " ]";
    }
    
}
