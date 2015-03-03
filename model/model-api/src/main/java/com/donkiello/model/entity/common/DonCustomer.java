/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.entity.common;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "don_customer")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "DonCustomer.findAll", query = "SELECT d FROM DonCustomer d"),
//    @NamedQuery(name = "DonCustomer.findByDon360id", query = "SELECT d FROM DonCustomer d WHERE d.don360id = :don360id"),
//    @NamedQuery(name = "DonCustomer.findByDon360deleted", query = "SELECT d FROM DonCustomer d WHERE d.don360deleted = :don360deleted"),
//    @NamedQuery(name = "DonCustomer.findByDon360name", query = "SELECT d FROM DonCustomer d WHERE d.don360name = :don360name"),
//    @NamedQuery(name = "DonCustomer.findByDon360bussinessNames", query = "SELECT d FROM DonCustomer d WHERE d.don360bussinessNames = :don360bussinessNames"),
//    @NamedQuery(name = "DonCustomer.findByDon360programs", query = "SELECT d FROM DonCustomer d WHERE d.don360programs = :don360programs"),
//    @NamedQuery(name = "DonCustomer.findByDon360paymentStatus", query = "SELECT d FROM DonCustomer d WHERE d.don360paymentStatus = :don360paymentStatus"),
//    @NamedQuery(name = "DonCustomer.findByDon360mobileno", query = "SELECT d FROM DonCustomer d WHERE d.don360mobileno = :don360mobileno")})
public class DonCustomer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DON360ID")
    private Integer don360id;
    @Lob
    @Size(max = 65535)
    @Column(name = "DON360CUSTOMER_RATE")
    private String don360customerRate;
    @Lob
    @Size(max = 65535)
    @Column(name = "DON360CUSTOMER_ECO_RATE")
    private String don360customerEcoRate;
    @Column(name = "DON360DELETED")
    private Short deleted;
    @Size(max = 1000)
    @Column(name = "DON360NAME")
    private String don360name;
    @Lob
    @Column(name = "DON360IMAGE")
    private byte[] don360image;
    @Size(max = 5000)
    @Column(name = "DON360BUSSINESS_NAMES")
    private String don360bussinessNames;
    @Size(max = 500)
    @Column(name = "DON360PROGRAMS")
    private String don360programs;
    @Size(max = 100)
    @Column(name = "DON360PAYMENT_STATUS")
    private String don360paymentStatus;
    @Size(max = 200)
    @Column(name = "DON360MOBILENO")
    private String don360mobileno;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "don360id" )
    private List<DonPersonal> donPersonalList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "don360id" )
    private List<DonPast> donPastList;
    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "don360id" )
    private List<DonBussiness> donBussinessList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "don360id")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<DonProgram> donProgramList;

    public DonCustomer() {
    }

    public DonCustomer(Integer don360id) {
        this.don360id = don360id;
    }

    public Integer getDon360id() {
        return don360id;
    }

    public void setDon360id(Integer don360id) {
        this.don360id = don360id;
    }

    public String getDon360customerRate() {
        return don360customerRate;
    }

    public void setDon360customerRate(String don360customerRate) {
        this.don360customerRate = don360customerRate;
    }

    public String getDon360customerEcoRate() {
        return don360customerEcoRate;
    }

    public void setDon360customerEcoRate(String don360customerEcoRate) {
        this.don360customerEcoRate = don360customerEcoRate;
    }

    public Short getDeleted() {
        return deleted;
    }

    public void setDeleted(Short deleted) {
        System.out.println("in set deleted");
        this.deleted = deleted;
        System.out.println("after set deleted");
    }

    public String getDon360name() {
        return don360name;
    }

    public void setDon360name(String don360name) {
        this.don360name = don360name;
    }

    public byte[] getDon360image() {
        return don360image;
    }

    public void setDon360image(byte[] don360image) {
        this.don360image = don360image;
    }

    public String getDon360bussinessNames() {
        return don360bussinessNames;
    }

    public void setDon360bussinessNames(String don360bussinessNames) {
        this.don360bussinessNames = don360bussinessNames;
    }

    public String getDon360programs() {
        return don360programs;
    }

    public void setDon360programs(String don360programs) {
        this.don360programs = don360programs;
    }

    public String getDon360paymentStatus() {
        return don360paymentStatus;
    }

    public void setDon360paymentStatus(String don360paymentStatus) {
        this.don360paymentStatus = don360paymentStatus;
    }

    public String getDon360mobileno() {
        return don360mobileno;
    }

    public void setDon360mobileno(String don360mobileno) {
        this.don360mobileno = don360mobileno;
    }

    @XmlTransient
    public List<DonPersonal> getDonPersonalList() {
        return donPersonalList;
    }

    public void setDonPersonalList(List<DonPersonal> donPersonalList) {
        this.donPersonalList = donPersonalList;
    }

    @XmlTransient
    public List<DonPast> getDonPastList() {
        return donPastList;
    }

    public void setDonPastList(List<DonPast> donPastList) {
        this.donPastList = donPastList;
    }

    @XmlTransient
    public List<DonBussiness> getDonBussinessList() {
        return donBussinessList;
    }

    public void setDonBussinessList(List<DonBussiness> donBussinessList) {
        this.donBussinessList = donBussinessList;
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
        hash += (don360id != null ? don360id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonCustomer)) {
            return false;
        }
        DonCustomer other = (DonCustomer) object;
        if ((this.don360id == null && other.don360id != null) || (this.don360id != null && !this.don360id.equals(other.don360id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonCustomer[ don360id=" + don360id + " ]";
    }
    
}
