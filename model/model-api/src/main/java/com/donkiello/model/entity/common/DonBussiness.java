/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.entity.common;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "don_bussiness")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "DonBussiness.findAll", query = "SELECT d FROM DonBussiness d")})
public class DonBussiness implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "don368id")
    private BigDecimal id;
    @Size(max = 1000)
    @Column(name = "don368buss_name")
    private String bussName;
    @Size(max = 1000)
    @Column(name = "don368position")
    private String position;
    @Size(max = 3000)
    @Column(name = "don368buss_address")
    private String bussAddress;
    @Size(max = 1000)
    @Column(name = "don368brand")
    private String brand;
    @Size(max = 1000)
    @Column(name = "don368buss_field")
    private String bussField;
    @Size(max = 1000)
    @Column(name = "don368office_tel")
    private String officeTel;
    @Size(max = 1000)
    @Column(name = "don368secretary_name")
    private String secretaryName;
    @Size(max = 1000)
    @Column(name = "don368secretary_tel")
    private String secretaryTel;
    @Size(max = 1000)
    @Column(name = "don368fax")
    private String fax;
    @Size(max = 1000)
    @Column(name = "don368buss_mail")
    private String bussMail;
    @Size(max = 200)
    @Column(name = "don368buss_website")
    private String bussWebsite;
    @Size(max = 1000)
    @Column(name = "don368branch_comp")
    private String branchComp;
    @Size(max = 1000)
    @Column(name = "don368past_comps")
    private String pastComps;
    @Size(max = 2000)
    @Column(name = "don368buss_descreption")
    private String bussDescreption;
    @Column(name = "don368deleted")
    private Short deleted;
    @JoinColumn(name = "don366id", referencedColumnName = "don366id")
    @ManyToOne
    private DonBussinessInfo don366id;

    public DonBussiness() {
    }

    public DonBussiness(BigDecimal don368id) {
        this.id = don368id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getBussName() {
        return bussName;
    }

    public void setBussName(String bussName) {
        this.bussName = bussName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBussAddress() {
        return bussAddress;
    }

    public void setBussAddress(String bussAddress) {
        this.bussAddress = bussAddress;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBussField() {
        return bussField;
    }

    public void setBussField(String bussField) {
        this.bussField = bussField;
    }

    public String getOfficeTel() {
        return officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
    }

    public String getSecretaryName() {
        return secretaryName;
    }

    public void setSecretaryName(String secretaryName) {
        this.secretaryName = secretaryName;
    }

    public String getSecretaryTel() {
        return secretaryTel;
    }

    public void setSecretaryTel(String secretaryTel) {
        this.secretaryTel = secretaryTel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getBussMail() {
        return bussMail;
    }

    public void setBussMail(String bussMail) {
        this.bussMail = bussMail;
    }

    public String getBussWebsite() {
        return bussWebsite;
    }

    public void setBussWebsite(String bussWebsite) {
        this.bussWebsite = bussWebsite;
    }

    public String getBranchComp() {
        return branchComp;
    }

    public void setBranchComp(String branchComp) {
        this.branchComp = branchComp;
    }

    public String getPastComps() {
        return pastComps;
    }

    public void setPastComps(String pastComps) {
        this.pastComps = pastComps;
    }

    public String getBussDescreption() {
        return bussDescreption;
    }

    public void setBussDescreption(String bussDescreption) {
        this.bussDescreption = bussDescreption;
    }

    public Short getDeleted() {
        return deleted;
    }

    public void setDeleted(Short deleted) {
        this.deleted = deleted;
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
        if (!(object instanceof DonBussiness)) {
            return false;
        }
        DonBussiness other = (DonBussiness) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonBussiness[ don368id=" + id + " ]";
    }
    
}
