/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.entity.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "don_personal")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "DonPersonal.findAll", query = "SELECT d FROM DonPersonal d")})
public class DonPersonal implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "don361id")
    private BigDecimal id;
    @Size(max = 1000)
    @Column(name = "don361name")
    private String name;
    @Size(max = 1000)
    @Column(name = "don361family_name")
    private String familyName;
    @Column(name = "don361gender")
    private Short gender;
    @Size(max = 1000)
    @Column(name = "don361mobile_number")
    private String mobileNumber;
    @Size(max = 1000)
    @Column(name = "don361en_name")
    private String enName;
    @Size(max = 1000)
    @Column(name = "don361en_family")
    private String enFamily;
    @Size(max = 1000)
    @Column(name = "don361prefix")
    private String prefix;
    @Size(max = 1000)
    @Column(name = "don361en_prefix")
    private String enPrefix;
    @Size(max = 1000)
    @Column(name = "don361home_tel")
    private String homeTel;
    @Size(max = 1000)
    @Column(name = "don361home_fax")
    private String homeFax;
    @Size(max = 1000)
    @Column(name = "don361postal_code")
    private String postalCode;
    @Size(max = 3000)
    @Column(name = "don361home_address")
    private String homeAddress;
    @Size(max = 1000)
    @Column(name = "don361f_h_name")
    private String fHName;
    @Size(max = 1000)
    @Column(name = "don361en_f_h_name")
    private String enFHName;
    @Column(name = "don361birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Size(max = 1000)
    @Column(name = "don361en_home_address")
    private String enHomeAddress;
    @Size(max = 1000)
    @Column(name = "don361birth_place")
    private String birthPlace;
    @Size(max = 1000)
    @Column(name = "don361passport_no")
    private String passportNo;
    @Size(max = 100)
    @Column(name = "don361birth_cer_no")
    private String birthCerNo;
    @Size(max = 100)
    @Column(name = "don361personal_mail")
    private String personalMail;
    @Lob
    @Column(name = "don361passport_scan")
    private Serializable passportScan;
    @Lob
    @Column(name = "don361birth_cert_scan")
    private Serializable birthCertScan;
    @Lob
    @Column(name = "don361description")
    private String description;
    @Column(name = "don364deleted")
    private Short deleted;
    @JoinColumn(name = "don360id", referencedColumnName = "don360id")
    @ManyToOne
    private DonCustomer don360id;
    @OneToMany(mappedBy = "don361id")
    private List<DonHobbies> donHobbiesList;
    @OneToMany(mappedBy = "don361id")
    private List<DonCustomer> donCustomerList;

    public DonPersonal() {
    }

    public DonPersonal(BigDecimal don361id) {
        this.id = don361id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getEnFamily() {
        return enFamily;
    }

    public void setEnFamily(String enFamily) {
        this.enFamily = enFamily;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getEnPrefix() {
        return enPrefix;
    }

    public void setEnPrefix(String enPrefix) {
        this.enPrefix = enPrefix;
    }

    public String getHomeTel() {
        return homeTel;
    }

    public void setHomeTel(String homeTel) {
        this.homeTel = homeTel;
    }

    public String getHomeFax() {
        return homeFax;
    }

    public void setHomeFax(String homeFax) {
        this.homeFax = homeFax;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getfHName() {
        return fHName;
    }

    public void setfHName(String fHName) {
        this.fHName = fHName;
    }

    public String getEnFHName() {
        return enFHName;
    }

    public void setEnFHName(String enFHName) {
        this.enFHName = enFHName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEnHomeAddress() {
        return enHomeAddress;
    }

    public void setEnHomeAddress(String enHomeAddress) {
        this.enHomeAddress = enHomeAddress;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getBirthCerNo() {
        return birthCerNo;
    }

    public void setBirthCerNo(String birthCerNo) {
        this.birthCerNo = birthCerNo;
    }

    public String getPersonalMail() {
        return personalMail;
    }

    public void setPersonalMail(String personalMail) {
        this.personalMail = personalMail;
    }

    public Serializable getPassportScan() {
        return passportScan;
    }

    public void setPassportScan(Serializable passportScan) {
        this.passportScan = passportScan;
    }

    public Serializable getBirthCertScan() {
        return birthCertScan;
    }

    public void setBirthCertScan(Serializable birthCertScan) {
        this.birthCertScan = birthCertScan;
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

    public DonCustomer getDon360id() {
        return don360id;
    }

    public void setDon360id(DonCustomer don360id) {
        this.don360id = don360id;
    }

    @XmlTransient
    public List<DonHobbies> getDonHobbiesList() {
        return donHobbiesList;
    }

    public void setDonHobbiesList(List<DonHobbies> donHobbiesList) {
        this.donHobbiesList = donHobbiesList;
    }

    @XmlTransient
    public List<DonCustomer> getDonCustomerList() {
        return donCustomerList;
    }

    public void setDonCustomerList(List<DonCustomer> donCustomerList) {
        this.donCustomerList = donCustomerList;
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
        if (!(object instanceof DonPersonal)) {
            return false;
        }
        DonPersonal other = (DonPersonal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonPersonal[ don361id=" + id + " ]";
    }
    
}
