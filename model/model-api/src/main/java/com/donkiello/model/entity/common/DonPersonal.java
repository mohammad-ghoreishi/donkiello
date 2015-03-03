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
import javax.persistence.Lob;
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
@Table(name = "don_personal")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "DonPersonal.findAll", query = "SELECT d FROM DonPersonal d"),
//    @NamedQuery(name = "DonPersonal.findByDon361id", query = "SELECT d FROM DonPersonal d WHERE d.don361id = :don361id"),
//    @NamedQuery(name = "DonPersonal.findByDon361name", query = "SELECT d FROM DonPersonal d WHERE d.don361name = :don361name"),
//    @NamedQuery(name = "DonPersonal.findByDon361familyName", query = "SELECT d FROM DonPersonal d WHERE d.don361familyName = :don361familyName"),
//    @NamedQuery(name = "DonPersonal.findByDon361gender", query = "SELECT d FROM DonPersonal d WHERE d.don361gender = :don361gender"),
//    @NamedQuery(name = "DonPersonal.findByDon361mobileNumber", query = "SELECT d FROM DonPersonal d WHERE d.don361mobileNumber = :don361mobileNumber"),
//    @NamedQuery(name = "DonPersonal.findByDon361enName", query = "SELECT d FROM DonPersonal d WHERE d.don361enName = :don361enName"),
//    @NamedQuery(name = "DonPersonal.findByDon361enFamily", query = "SELECT d FROM DonPersonal d WHERE d.don361enFamily = :don361enFamily"),
//    @NamedQuery(name = "DonPersonal.findByDon361prefix", query = "SELECT d FROM DonPersonal d WHERE d.don361prefix = :don361prefix"),
//    @NamedQuery(name = "DonPersonal.findByDon361enPrefix", query = "SELECT d FROM DonPersonal d WHERE d.don361enPrefix = :don361enPrefix"),
//    @NamedQuery(name = "DonPersonal.findByDon361homeTel", query = "SELECT d FROM DonPersonal d WHERE d.don361homeTel = :don361homeTel"),
//    @NamedQuery(name = "DonPersonal.findByDon361homeFax", query = "SELECT d FROM DonPersonal d WHERE d.don361homeFax = :don361homeFax"),
//    @NamedQuery(name = "DonPersonal.findByDon361postalCode", query = "SELECT d FROM DonPersonal d WHERE d.don361postalCode = :don361postalCode"),
//    @NamedQuery(name = "DonPersonal.findByDon361homeAddress", query = "SELECT d FROM DonPersonal d WHERE d.don361homeAddress = :don361homeAddress"),
//    @NamedQuery(name = "DonPersonal.findByDon361fHName", query = "SELECT d FROM DonPersonal d WHERE d.don361fHName = :don361fHName"),
//    @NamedQuery(name = "DonPersonal.findByDon361enFHName", query = "SELECT d FROM DonPersonal d WHERE d.don361enFHName = :don361enFHName"),
//    @NamedQuery(name = "DonPersonal.findByDon361birthday", query = "SELECT d FROM DonPersonal d WHERE d.don361birthday = :don361birthday"),
//    @NamedQuery(name = "DonPersonal.findByDon361enHomeAddress", query = "SELECT d FROM DonPersonal d WHERE d.don361enHomeAddress = :don361enHomeAddress"),
//    @NamedQuery(name = "DonPersonal.findByDon361birthPlace", query = "SELECT d FROM DonPersonal d WHERE d.don361birthPlace = :don361birthPlace"),
//    @NamedQuery(name = "DonPersonal.findByDon361passportNo", query = "SELECT d FROM DonPersonal d WHERE d.don361passportNo = :don361passportNo"),
//    @NamedQuery(name = "DonPersonal.findByDon361birthCerNo", query = "SELECT d FROM DonPersonal d WHERE d.don361birthCerNo = :don361birthCerNo"),
//    @NamedQuery(name = "DonPersonal.findByDon361personalMail", query = "SELECT d FROM DonPersonal d WHERE d.don361personalMail = :don361personalMail"),
//    @NamedQuery(name = "DonPersonal.findByDon361hobbies", query = "SELECT d FROM DonPersonal d WHERE d.don361hobbies = :don361hobbies"),
//    @NamedQuery(name = "DonPersonal.findByDon364deleted", query = "SELECT d FROM DonPersonal d WHERE d.don364deleted = :don364deleted")})
public class DonPersonal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DON361ID")
    private Integer don361id;
    @Size(max = 1000)
    @Column(name = "DON361NAME")
    private String don361name;
    @Size(max = 1000)
    @Column(name = "DON361FAMILY_NAME")
    private String don361familyName;
    @Column(name = "DON361GENDER")
    private Short don361gender;
    @Size(max = 1000)
    @Column(name = "DON361MOBILE_NUMBER")
    private String don361mobileNumber;
    @Size(max = 1000)
    @Column(name = "DON361EN_NAME")
    private String don361enName;
    @Size(max = 1000)
    @Column(name = "DON361EN_FAMILY")
    private String don361enFamily;
    @Size(max = 1000)
    @Column(name = "DON361PREFIX")
    private String don361prefix;
    @Size(max = 1000)
    @Column(name = "DON361EN_PREFIX")
    private String don361enPrefix;
    @Size(max = 1000)
    @Column(name = "DON361HOME_TEL")
    private String don361homeTel;
    @Size(max = 1000)
    @Column(name = "DON361HOME_FAX")
    private String don361homeFax;
    @Size(max = 1000)
    @Column(name = "DON361POSTAL_CODE")
    private String don361postalCode;
    @Size(max = 3000)
    @Column(name = "DON361HOME_ADDRESS")
    private String don361homeAddress;
    @Size(max = 1000)
    @Column(name = "DON361F_H_NAME")
    private String don361fHName;
    @Size(max = 1000)
    @Column(name = "DON361EN_F_H_NAME")
    private String don361enFHName;
    @Column(name = "DON361BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date don361birthday;
    @Size(max = 1000)
    @Column(name = "DON361EN_HOME_ADDRESS")
    private String don361enHomeAddress;
    @Size(max = 1000)
    @Column(name = "DON361BIRTH_PLACE")
    private String don361birthPlace;
    @Size(max = 1000)
    @Column(name = "DON361PASSPORT_NO")
    private String don361passportNo;
    @Size(max = 100)
    @Column(name = "DON361BIRTH_CER_NO")
    private String don361birthCerNo;
    @Size(max = 100)
    @Column(name = "DON361PERSONAL_MAIL")
    private String don361personalMail;
    @Lob
    @Column(name = "DON361PASSPORT_SCAN")
    private byte[] don361passportScan;
    @Lob
    @Column(name = "DON361BIRTH_CERT_SCAN")
    private byte[] don361birthCertScan;
    @Lob
    @Size(max = 65535)
    @Column(name = "DON361DESCRIPTION")
    private String don361description;
    @Size(max = 1000)
    @Column(name = "DON361HOBBIES")
    private String don361hobbies;
    @Column(name = "DON364DELETED")
    private Short deleted;
    @JoinColumn(name = "DON360ID", referencedColumnName = "DON360ID")
    @ManyToOne(optional = false)
    private DonCustomer don360id;

    public DonPersonal() {
    }

    public DonPersonal(Integer don361id) {
        this.don361id = don361id;
    }

    public Integer getDon361id() {
        return don361id;
    }

    public void setDon361id(Integer don361id) {
        this.don361id = don361id;
    }

    public String getDon361name() {
        return don361name;
    }

    public void setDon361name(String don361name) {
        this.don361name = don361name;
    }

    public String getDon361familyName() {
        return don361familyName;
    }

    public void setDon361familyName(String don361familyName) {
        this.don361familyName = don361familyName;
    }

    public Short getDon361gender() {
       
        return don361gender;
    }

    public void setDon361gender(Short don361gender) {
        this.don361gender = don361gender;
    }

    public String getDon361mobileNumber() {
        return don361mobileNumber;
    }

    public void setDon361mobileNumber(String don361mobileNumber) {
        this.don361mobileNumber = don361mobileNumber;
    }

    public String getDon361enName() {
        return don361enName;
    }

    public void setDon361enName(String don361enName) {
        this.don361enName = don361enName;
    }

    public String getDon361enFamily() {
        return don361enFamily;
    }

    public void setDon361enFamily(String don361enFamily) {
        this.don361enFamily = don361enFamily;
    }

    public String getDon361prefix() {
        return don361prefix;
    }

    public void setDon361prefix(String don361prefix) {
        this.don361prefix = don361prefix;
    }

    public String getDon361enPrefix() {
        return don361enPrefix;
    }

    public void setDon361enPrefix(String don361enPrefix) {
        this.don361enPrefix = don361enPrefix;
    }

    public String getDon361homeTel() {
        return don361homeTel;
    }

    public void setDon361homeTel(String don361homeTel) {
        this.don361homeTel = don361homeTel;
    }

    public String getDon361homeFax() {
        return don361homeFax;
    }

    public void setDon361homeFax(String don361homeFax) {
        this.don361homeFax = don361homeFax;
    }

    public String getDon361postalCode() {
        return don361postalCode;
    }

    public void setDon361postalCode(String don361postalCode) {
        this.don361postalCode = don361postalCode;
    }

    public String getDon361homeAddress() {
        return don361homeAddress;
    }

    public void setDon361homeAddress(String don361homeAddress) {
        this.don361homeAddress = don361homeAddress;
    }

    public String getDon361fHName() {
        return don361fHName;
    }

    public void setDon361fHName(String don361fHName) {
        this.don361fHName = don361fHName;
    }

    public String getDon361enFHName() {
        return don361enFHName;
    }

    public void setDon361enFHName(String don361enFHName) {
        this.don361enFHName = don361enFHName;
    }

    public Date getDon361birthday() {
        return don361birthday;
    }

    public void setDon361birthday(Date don361birthday) {
        this.don361birthday = don361birthday;
    }

    public String getDon361enHomeAddress() {
        return don361enHomeAddress;
    }

    public void setDon361enHomeAddress(String don361enHomeAddress) {
        this.don361enHomeAddress = don361enHomeAddress;
    }

    public String getDon361birthPlace() {
        return don361birthPlace;
    }

    public void setDon361birthPlace(String don361birthPlace) {
        this.don361birthPlace = don361birthPlace;
    }

    public String getDon361passportNo() {
        return don361passportNo;
    }

    public void setDon361passportNo(String don361passportNo) {
        this.don361passportNo = don361passportNo;
    }

    public String getDon361birthCerNo() {
        return don361birthCerNo;
    }

    public void setDon361birthCerNo(String don361birthCerNo) {
        this.don361birthCerNo = don361birthCerNo;
    }

    public String getDon361personalMail() {
        return don361personalMail;
    }

    public void setDon361personalMail(String don361personalMail) {
        this.don361personalMail = don361personalMail;
    }

    public byte[] getDon361passportScan() {
        return don361passportScan;
    }

    public void setDon361passportScan(byte[] don361passportScan) {
        this.don361passportScan = don361passportScan;
    }

    public byte[] getDon361birthCertScan() {
        return don361birthCertScan;
    }

    public void setDon361birthCertScan(byte[] don361birthCertScan) {
        this.don361birthCertScan = don361birthCertScan;
    }

    public String getDon361description() {
        return don361description;
    }

    public void setDon361description(String don361description) {
        this.don361description = don361description;
    }

    public String getDon361hobbies() {
        return don361hobbies;
    }

    public void setDon361hobbies(String don361hobbies) {
        this.don361hobbies = don361hobbies;
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
        hash += (don361id != null ? don361id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonPersonal)) {
            return false;
        }
        DonPersonal other = (DonPersonal) object;
        if ((this.don361id == null && other.don361id != null) || (this.don361id != null && !this.don361id.equals(other.don361id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonPersonal[ don361id=" + don361id + " ]";
    }
    
}
