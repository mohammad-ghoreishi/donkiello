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
@Table(name = "don_products")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "DonProducts.findAll", query = "SELECT d FROM DonProducts d")})
public class DonProducts implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "don367id")
    private BigDecimal id;
    @Size(max = 1000)
    @Column(name = "don367tag_name")
    private String tagName;
    @Size(max = 1000)
    @Column(name = "don367description")
    private String description;
    @Column(name = "don367deleted")
    private Short deleted;
    @JoinColumn(name = "don366id", referencedColumnName = "don366id")
    @ManyToOne
    private DonBussinessInfo don366id;

    public DonProducts() {
    }

    public DonProducts(BigDecimal don367id) {
        this.id = don367id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof DonProducts)) {
            return false;
        }
        DonProducts other = (DonProducts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonProducts[ don367id=" + id + " ]";
    }
    
}
