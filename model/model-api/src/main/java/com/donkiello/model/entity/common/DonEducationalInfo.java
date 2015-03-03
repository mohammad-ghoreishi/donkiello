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
@Table(name = "don_educational-info")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "DonEducationalInfo.findAll", query = "SELECT d FROM DonEducationalInfo d")})
public class DonEducationalInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "don363id")
    private BigDecimal id;
    @Column(name = "don363deleted")
    private Short deleted;
    @OneToMany(mappedBy = "don363id")
    private List<DonPast> donPastList;
    @JoinColumn(name = "don360id", referencedColumnName = "don360id")
    @ManyToOne
    private DonCustomer don360id;
    @OneToMany(mappedBy = "don363id")
    private List<DonCustomer> donCustomerList;
    @OneToMany(mappedBy = "don363id")
    private List<DonProgram> donProgramList;

    public DonEducationalInfo() {
    }

    public DonEducationalInfo(BigDecimal don363id) {
        this.id = don363id;
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

    @XmlTransient
    public List<DonPast> getDonPastList() {
        return donPastList;
    }

    public void setDonPastList(List<DonPast> donPastList) {
        this.donPastList = donPastList;
    }

    public DonCustomer getDon360id() {
        return don360id;
    }

    public void setDon360id(DonCustomer don360id) {
        this.don360id = don360id;
    }

    @XmlTransient
    public List<DonCustomer> getDonCustomerList() {
        return donCustomerList;
    }

    public void setDonCustomerList(List<DonCustomer> donCustomerList) {
        this.donCustomerList = donCustomerList;
    }

    @XmlTransient
    public List<DonProgram> getDonProgramList() {
        return donProgramList;
    }

    public void setDonProgramList(List<DonProgram> donProgramList) {
        this.donProgramList = donProgramList;
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
        if (!(object instanceof DonEducationalInfo)) {
            return false;
        }
        DonEducationalInfo other = (DonEducationalInfo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonEducationalInfo[ don363id=" + id + " ]";
    }
    
}
