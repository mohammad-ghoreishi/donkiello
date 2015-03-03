/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.entity.common;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
//    @NamedQuery(name = "DonPast.findAll", query = "SELECT d FROM DonPast d"),
//    @NamedQuery(name = "DonPast.findByDon365id", query = "SELECT d FROM DonPast d WHERE d.don365id = :don365id"),
//    @NamedQuery(name = "DonPast.findByDon365degree", query = "SELECT d FROM DonPast d WHERE d.don365degree = :don365degree"),
//    @NamedQuery(name = "DonPast.findByDon365eduField", query = "SELECT d FROM DonPast d WHERE d.don365eduField = :don365eduField"),
//    @NamedQuery(name = "DonPast.findByDon365uniName", query = "SELECT d FROM DonPast d WHERE d.don365uniName = :don365uniName"),
//    @NamedQuery(name = "DonPast.findByDon365uniCity", query = "SELECT d FROM DonPast d WHERE d.don365uniCity = :don365uniCity"),
//    @NamedQuery(name = "DonPast.findByDon365gradiationDate", query = "SELECT d FROM DonPast d WHERE d.don365gradiationDate = :don365gradiationDate"),
//    @NamedQuery(name = "DonPast.findByDon365deleted", query = "SELECT d FROM DonPast d WHERE d.don365deleted = :don365deleted")})
public class DonPast implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DON365ID")
    private Integer don365id;
    @Size(max = 1000)
    @Column(name = "DON365DEGREE")
    private String don365degree;
    @Size(max = 1000)
    @Column(name = "DON365EDU_FIELD")
    private String don365eduField;
    @Size(max = 1000)
    @Column(name = "DON365UNI_NAME")
    private String don365uniName;
    @Size(max = 1000)
    @Column(name = "DON365UNI_CITY")
    private String don365uniCity;
    @Column(name = "DON365GRADIATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date don365gradiationDate;
    @Column(name = "DON365DELETED")
    private Short deleted;
    @JoinColumn(name = "DON360ID", referencedColumnName = "DON360ID")
    @ManyToOne(optional = false)
    private DonCustomer don360id;

    public DonPast() {
    }

    public DonPast(Integer don365id) {
        this.don365id = don365id;
    }

    public Integer getDon365id() {
        return don365id;
    }

    public void setDon365id(Integer don365id) {
        this.don365id = don365id;
    }

    public String getDon365degree() {
        return don365degree;
    }

    public void setDon365degree(String don365degree) {
        this.don365degree = don365degree;
    }

    public String getDon365eduField() {
        return don365eduField;
    }

    public void setDon365eduField(String don365eduField) {
        this.don365eduField = don365eduField;
    }

    public String getDon365uniName() {
        return don365uniName;
    }

    public void setDon365uniName(String don365uniName) {
        this.don365uniName = don365uniName;
    }

    public String getDon365uniCity() {
        return don365uniCity;
    }

    public void setDon365uniCity(String don365uniCity) {
        this.don365uniCity = don365uniCity;
    }

    public Date getDon365gradiationDate() {
        return don365gradiationDate;
    }

    public void setDon365gradiationDate(Date don365gradiationDate) {
        this.don365gradiationDate = don365gradiationDate;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (don365id != null ? don365id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonPast)) {
            return false;
        }
        DonPast other = (DonPast) object;
        if ((this.don365id == null && other.don365id != null) || (this.don365id != null && !this.don365id.equals(other.don365id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonPast[ don365id=" + don365id + " ]";
    }
    
}
