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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "don_customer")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "DonCustomer.findAll", query = "SELECT d FROM DonCustomer d")})
public class DonCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "don360id")
    private BigDecimal id;
    @Lob
    @Column(name = "don360customer_rate")
    private String customerRate;
    @Lob
    @Column(name = "don360customer_eco_rate")
    private String customerEcoRate;
    @Column(name = "don360deleted")
    private Short deleted;
    @Size(max = 1000)
    @Column(name = "don360name")
    private String name;
    @Lob
    @Column(name = "don360image")
    private Serializable image;
    @OneToMany(mappedBy = "don360id")
    private List<DonPersonal> donPersonalList;
    @OneToMany(mappedBy = "don360id")
    private List<DonBussinessInfo> donBussinessInfoList;
    @OneToMany(mappedBy = "don360id")
    private List<DonEducationalInfo> donEducationalInfoList;
    @JoinColumn(name = "don361id", referencedColumnName = "don361id")
    @ManyToOne
    private DonPersonal don361id;
    @JoinColumn(name = "don363id", referencedColumnName = "don363id")
    @ManyToOne
    private DonEducationalInfo don363id;
    @JoinColumn(name = "don366id", referencedColumnName = "don366id")
    @ManyToOne
    private DonBussinessInfo don366id;

    public DonCustomer() {
    }

    public DonCustomer(BigDecimal don360id) {
        this.id = don360id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getCustomerRate() {
        return customerRate;
    }

    public void setCustomerRate(String customerRate) {
        this.customerRate = customerRate;
    }

    public String getCustomerEcoRate() {
        return customerEcoRate;
    }

    public void setCustomerEcoRate(String customerEcoRate) {
        this.customerEcoRate = customerEcoRate;
    }

    public Short getDeleted() {
        return deleted;
    }

    public void setDeleted(Short deleted) {
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Serializable getImage() {
        return image;
    }

    public void setImage(Serializable image) {
        this.image = image;
    }

    @XmlTransient
    public List<DonPersonal> getDonPersonalList() {
        return donPersonalList;
    }

    public void setDonPersonalList(List<DonPersonal> donPersonalList) {
        this.donPersonalList = donPersonalList;
    }

    @XmlTransient
    public List<DonBussinessInfo> getDonBussinessInfoList() {
        return donBussinessInfoList;
    }

    public void setDonBussinessInfoList(List<DonBussinessInfo> donBussinessInfoList) {
        this.donBussinessInfoList = donBussinessInfoList;
    }

    @XmlTransient
    public List<DonEducationalInfo> getDonEducationalInfoList() {
        return donEducationalInfoList;
    }

    public void setDonEducationalInfoList(List<DonEducationalInfo> donEducationalInfoList) {
        this.donEducationalInfoList = donEducationalInfoList;
    }

    public DonPersonal getDon361id() {
        return don361id;
    }

    public void setDon361id(DonPersonal don361id) {
        this.don361id = don361id;
    }

    public DonEducationalInfo getDon363id() {
        return don363id;
    }

    public void setDon363id(DonEducationalInfo don363id) {
        this.don363id = don363id;
    }

    public DonBussinessInfo getDon366id() {
        return don366id;
    }

    public void setDon366id(DonBussinessInfo don366id) {
        this.don366id = don366id;
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
        if (!(object instanceof DonCustomer)) {
            return false;
        }
        DonCustomer other = (DonCustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonCustomer[ don360id=" + id + " ]";
    }
    
}
