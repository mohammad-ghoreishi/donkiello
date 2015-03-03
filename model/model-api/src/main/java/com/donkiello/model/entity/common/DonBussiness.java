/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.entity.common;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
//    @NamedQuery(name = "DonBussiness.findAll", query = "SELECT d FROM DonBussiness d"),
//    @NamedQuery(name = "DonBussiness.findByDon368id", query = "SELECT d FROM DonBussiness d WHERE d.don368id = :don368id"),
//    @NamedQuery(name = "DonBussiness.findByDon368bussName", query = "SELECT d FROM DonBussiness d WHERE d.don368bussName = :don368bussName"),
//    @NamedQuery(name = "DonBussiness.findByDon368position", query = "SELECT d FROM DonBussiness d WHERE d.don368position = :don368position"),
//    @NamedQuery(name = "DonBussiness.findByDon368bussAddress", query = "SELECT d FROM DonBussiness d WHERE d.don368bussAddress = :don368bussAddress"),
//    @NamedQuery(name = "DonBussiness.findByDon368brand", query = "SELECT d FROM DonBussiness d WHERE d.don368brand = :don368brand"),
//    @NamedQuery(name = "DonBussiness.findByDon368bussField", query = "SELECT d FROM DonBussiness d WHERE d.don368bussField = :don368bussField"),
//    @NamedQuery(name = "DonBussiness.findByDon368officeTel", query = "SELECT d FROM DonBussiness d WHERE d.don368officeTel = :don368officeTel"),
//    @NamedQuery(name = "DonBussiness.findByDon368secretaryName", query = "SELECT d FROM DonBussiness d WHERE d.don368secretaryName = :don368secretaryName"),
//    @NamedQuery(name = "DonBussiness.findByDon368secretaryTel", query = "SELECT d FROM DonBussiness d WHERE d.don368secretaryTel = :don368secretaryTel"),
//    @NamedQuery(name = "DonBussiness.findByDon368fax", query = "SELECT d FROM DonBussiness d WHERE d.don368fax = :don368fax"),
//    @NamedQuery(name = "DonBussiness.findByDon368bussMail", query = "SELECT d FROM DonBussiness d WHERE d.don368bussMail = :don368bussMail"),
//    @NamedQuery(name = "DonBussiness.findByDon368bussWebsite", query = "SELECT d FROM DonBussiness d WHERE d.don368bussWebsite = :don368bussWebsite"),
//    @NamedQuery(name = "DonBussiness.findByDon368branchComp", query = "SELECT d FROM DonBussiness d WHERE d.don368branchComp = :don368branchComp"),
//    @NamedQuery(name = "DonBussiness.findByDon368pastComps", query = "SELECT d FROM DonBussiness d WHERE d.don368pastComps = :don368pastComps"),
//    @NamedQuery(name = "DonBussiness.findByDon368bussDescreption", query = "SELECT d FROM DonBussiness d WHERE d.don368bussDescreption = :don368bussDescreption"),
//    @NamedQuery(name = "DonBussiness.findByDon368tag", query = "SELECT d FROM DonBussiness d WHERE d.don368tag = :don368tag"),
//    @NamedQuery(name = "DonBussiness.findByDon368deleted", query = "SELECT d FROM DonBussiness d WHERE d.don368deleted = :don368deleted")})
public class DonBussiness implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DON368ID")
    private Integer don368id;
    @Size(max = 1000)
    @Column(name = "DON368BUSS_NAME")
    private String don368bussName;
    @Size(max = 1000)
    @Column(name = "DON368POSITION")
    private String don368position;
    @Size(max = 3000)
    @Column(name = "DON368BUSS_ADDRESS")
    private String don368bussAddress;
    @Size(max = 1000)
    @Column(name = "DON368BRAND")
    private String don368brand;
    @Size(max = 1000)
    @Column(name = "DON368BUSS_FIELD")
    private String don368bussField;
    @Size(max = 1000)
    @Column(name = "DON368OFFICE_TEL")
    private String don368officeTel;
    @Size(max = 1000)
    @Column(name = "DON368SECRETARY_NAME")
    private String don368secretaryName;
    @Size(max = 1000)
    @Column(name = "DON368SECRETARY_TEL")
    private String don368secretaryTel;
    @Size(max = 1000)
    @Column(name = "DON368FAX")
    private String don368fax;
    @Size(max = 1000)
    @Column(name = "DON368BUSS_MAIL")
    private String don368bussMail;
    @Size(max = 200)
    @Column(name = "DON368BUSS_WEBSITE")
    private String don368bussWebsite;
    @Size(max = 1000)
    @Column(name = "DON368BRANCH_COMP")
    private String don368branchComp;
    @Size(max = 1000)
    @Column(name = "DON368PAST_COMPS")
    private String don368pastComps;
    @Size(max = 2000)
    @Column(name = "DON368BUSS_DESCREPTION")
    private String don368bussDescreption;
    @Size(max = 500)
    @Column(name = "DON368TAG")
    private String don368tag;
    @Column(name = "DON368DELETED")
    private Short deleted;
    @JoinColumn(name = "DON360ID", referencedColumnName = "DON360ID")
    @ManyToOne(optional = false)
    private DonCustomer don360id;

    public DonBussiness() {
    }

    public DonBussiness(Integer don368id) {
        this.don368id = don368id;
    }

    public Integer getDon368id() {
        return don368id;
    }

    public void setDon368id(Integer don368id) {
        this.don368id = don368id;
    }

    public String getDon368bussName() {
        return don368bussName;
    }

    public void setDon368bussName(String don368bussName) {
        this.don368bussName = don368bussName;
    }

    public String getDon368position() {
        return don368position;
    }

    public void setDon368position(String don368position) {
        this.don368position = don368position;
    }

    public String getDon368bussAddress() {
        return don368bussAddress;
    }

    public void setDon368bussAddress(String don368bussAddress) {
        this.don368bussAddress = don368bussAddress;
    }

    public String getDon368brand() {
        return don368brand;
    }

    public void setDon368brand(String don368brand) {
        this.don368brand = don368brand;
    }

    public String getDon368bussField() {
        return don368bussField;
    }

    public void setDon368bussField(String don368bussField) {
        this.don368bussField = don368bussField;
    }

    public String getDon368officeTel() {
        return don368officeTel;
    }

    public void setDon368officeTel(String don368officeTel) {
        this.don368officeTel = don368officeTel;
    }

    public String getDon368secretaryName() {
        return don368secretaryName;
    }

    public void setDon368secretaryName(String don368secretaryName) {
        this.don368secretaryName = don368secretaryName;
    }

    public String getDon368secretaryTel() {
        return don368secretaryTel;
    }

    public void setDon368secretaryTel(String don368secretaryTel) {
        this.don368secretaryTel = don368secretaryTel;
    }

    public String getDon368fax() {
        return don368fax;
    }

    public void setDon368fax(String don368fax) {
        this.don368fax = don368fax;
    }

    public String getDon368bussMail() {
        return don368bussMail;
    }

    public void setDon368bussMail(String don368bussMail) {
        this.don368bussMail = don368bussMail;
    }

    public String getDon368bussWebsite() {
        return don368bussWebsite;
    }

    public void setDon368bussWebsite(String don368bussWebsite) {
        this.don368bussWebsite = don368bussWebsite;
    }

    public String getDon368branchComp() {
        return don368branchComp;
    }

    public void setDon368branchComp(String don368branchComp) {
        this.don368branchComp = don368branchComp;
    }

    public String getDon368pastComps() {
        return don368pastComps;
    }

    public void setDon368pastComps(String don368pastComps) {
        this.don368pastComps = don368pastComps;
    }

    public String getDon368bussDescreption() {
        return don368bussDescreption;
    }

    public void setDon368bussDescreption(String don368bussDescreption) {
        this.don368bussDescreption = don368bussDescreption;
    }

    public String getDon368tag() {
        return don368tag;
    }

    public void setDon368tag(String don368tag) {
        this.don368tag = don368tag;
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
        hash += (don368id != null ? don368id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonBussiness)) {
            return false;
        }
        DonBussiness other = (DonBussiness) object;
        if ((this.don368id == null && other.don368id != null) || (this.don368id != null && !this.don368id.equals(other.don368id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonBussiness[ don368id=" + don368id + " ]";
    }
    
}
