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
@Table(name = "don_hobbies")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "DonHobbies.findAll", query = "SELECT d FROM DonHobbies d")})
public class DonHobbies implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "don362id")
    private BigDecimal id;
    @Size(max = 1000)
    @Column(name = "don362hobby_name")
    private String hobbyName;
    @Column(name = "don364deleted")
    private Short deleted;
    @JoinColumn(name = "don361id", referencedColumnName = "don361id")
    @ManyToOne
    private DonPersonal don361id;

    public DonHobbies() {
    }

    public DonHobbies(BigDecimal don362id) {
        this.id = don362id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getHobbyName() {
        return hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    public Short getDeleted() {
        return deleted;
    }

    public void setDeleted(Short deleted) {
        this.deleted = deleted;
    }

    public DonPersonal getDon361id() {
        return don361id;
    }

    public void setDon361id(DonPersonal don361id) {
        this.don361id = don361id;
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
        if (!(object instanceof DonHobbies)) {
            return false;
        }
        DonHobbies other = (DonHobbies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonHobbies[ don362id=" + id + " ]";
    }
    
}
