/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.entity.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "don_past")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "DonPast.findAll", query = "SELECT d FROM DonPast d")})
public class DonPast implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "don365id")
    private BigDecimal id;
    @Size(max = 1000)
    @Column(name = "don365degree")
    private String degree;
    @Size(max = 1000)
    @Column(name = "don365edu_field")
    private String eduField;
    @Size(max = 1000)
    @Column(name = "don365uni_name")
    private String uniName;
    @Size(max = 1000)
    @Column(name = "don365uni_city")
    private String uniCity;
    @Column(name = "don365gradiation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date graduationDate;
    @Column(name = "don365deleted")
    private Short deleted;
    @JoinColumn(name = "don363id", referencedColumnName = "don363id")
    @ManyToOne
    private DonEducationalInfo don363id;

    public DonPast() {
    }

    public DonPast(BigDecimal don365id) {
        this.id = don365id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getEduField() {
        return eduField;
    }

    public void setEduField(String eduField) {
        this.eduField = eduField;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getUniCity() {
        return uniCity;
    }

    public void setUniCity(String uniCity) {
        this.uniCity = uniCity;
    }

    public Date getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(Date graduationDate) {
        this.graduationDate = graduationDate;
    }

    public Short getDeleted() {
        return deleted;
    }

    public void setDeleted(Short deleted) {
        this.deleted = deleted;
    }

    public DonEducationalInfo getDon363id() {
        return don363id;
    }

    public void setDon363id(DonEducationalInfo don363id) {
        this.don363id = don363id;
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
        if (!(object instanceof DonPast)) {
            return false;
        }
        DonPast other = (DonPast) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonPast[ don365id=" + id + " ]";
    }
    
}
