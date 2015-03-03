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
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "don_users")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "DonUsers.findAll", query = "SELECT d FROM DonUsers d"),
//    @NamedQuery(name = "DonUsers.findByDon369id", query = "SELECT d FROM DonUsers d WHERE d.don369id = :don369id"),
//    @NamedQuery(name = "DonUsers.findByDon369username", query = "SELECT d FROM DonUsers d WHERE d.don369username = :don369username"),
//    @NamedQuery(name = "DonUsers.findByDon369password", query = "SELECT d FROM DonUsers d WHERE d.don369password = :don369password"),
//    @NamedQuery(name = "DonUsers.findByDon369name", query = "SELECT d FROM DonUsers d WHERE d.don369name = :don369name"),
//    @NamedQuery(name = "DonUsers.findByDon369family", query = "SELECT d FROM DonUsers d WHERE d.don369family = :don369family"),
//    @NamedQuery(name = "DonUsers.findByDon369role", query = "SELECT d FROM DonUsers d WHERE d.don369role = :don369role"),
//    @NamedQuery(name = "DonUsers.findByDon369deleted", query = "SELECT d FROM DonUsers d WHERE d.don369deleted = :don369deleted")})
public class DonUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DON369ID")
    private Integer don369id;
    @Size(max = 30)
    @Column(name = "DON369USERNAME")
    private String don369username;
    @Size(max = 30)
    @Column(name = "DON369PASSWORD")
    private String don369password;
    @Size(max = 50)
    @Column(name = "DON369NAME")
    private String don369name;
    @Size(max = 50)
    @Column(name = "DON369FAMILY")
    private String don369family;
    @Lob
    @Column(name = "DON369IMAGE")
    private byte[] don369image;
    @Size(max = 30)
    @Column(name = "DON369ROLE")
    private String don369role;
    @Column(name = "DON369DELETED")
    private Short deleted;

    public DonUsers() {
    }

    public DonUsers(Integer don369id) {
        this.don369id = don369id;
    }

    public Integer getDon369id() {
        return don369id;
    }

    public void setDon369id(Integer don369id) {
        this.don369id = don369id;
    }

    public String getDon369username() {
        return don369username;
    }

    public void setDon369username(String don369username) {
        this.don369username = don369username;
    }

    public String getDon369password() {
        return don369password;
    }

    public void setDon369password(String don369password) {
        this.don369password = don369password;
    }

    public String getDon369name() {
        return don369name;
    }

    public void setDon369name(String don369name) {
        this.don369name = don369name;
    }

    public String getDon369family() {
        return don369family;
    }

    public void setDon369family(String don369family) {
        this.don369family = don369family;
    }

    public byte[] getDon369image() {
        return don369image;
    }

    public void setDon369image(byte[] don369image) {
        this.don369image = don369image;
    }

    public String getDon369role() {
        return don369role;
    }

    public void setDon369role(String don369role) {
        this.don369role = don369role;
    }

    public Short getDeleted() {
        return deleted;
    }

    public void setDeleted(Short deleted) {
        this.deleted = deleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (don369id != null ? don369id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonUsers)) {
            return false;
        }
        DonUsers other = (DonUsers) object;
        if ((this.don369id == null && other.don369id != null) || (this.don369id != null && !this.don369id.equals(other.don369id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonUsers[ don369id=" + don369id + " ]";
    }
    
}
