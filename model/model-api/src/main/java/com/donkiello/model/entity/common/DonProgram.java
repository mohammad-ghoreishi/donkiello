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
@Table(name = "don_program")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "DonProgram.findAll", query = "SELECT d FROM DonProgram d"),
//    @NamedQuery(name = "DonProgram.findByDon364id", query = "SELECT d FROM DonProgram d WHERE d.don364id = :don364id"),
//    @NamedQuery(name = "DonProgram.findByDon364programName", query = "SELECT d FROM DonProgram d WHERE d.don364programName = :don364programName"),
//    @NamedQuery(name = "DonProgram.findByDon364masterThesis", query = "SELECT d FROM DonProgram d WHERE d.don364masterThesis = :don364masterThesis"),
//    @NamedQuery(name = "DonProgram.findByDon364thesisSubject", query = "SELECT d FROM DonProgram d WHERE d.don364thesisSubject = :don364thesisSubject"),
//    @NamedQuery(name = "DonProgram.findByDon364supervisor", query = "SELECT d FROM DonProgram d WHERE d.don364supervisor = :don364supervisor"),
//    @NamedQuery(name = "DonProgram.findByDon364firstPayment", query = "SELECT d FROM DonProgram d WHERE d.don364firstPayment = :don364firstPayment"),
//    @NamedQuery(name = "DonProgram.findByDon364secondPayment", query = "SELECT d FROM DonProgram d WHERE d.don364secondPayment = :don364secondPayment"),
//    @NamedQuery(name = "DonProgram.findByDon364paymentDesc", query = "SELECT d FROM DonProgram d WHERE d.don364paymentDesc = :don364paymentDesc"),
//    @NamedQuery(name = "DonProgram.findByDon364deleted", query = "SELECT d FROM DonProgram d WHERE d.don364deleted = :don364deleted")})
public class DonProgram implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DON364ID")
    private Integer don364id;
    @Size(max = 1000)
    @Column(name = "DON364PROGRAM_NAME")
    private String don364programName;
    @Size(max = 2000)
    @Column(name = "DON364MASTER_THESIS")
    private String don364masterThesis;
    @Size(max = 2000)
    @Column(name = "DON364THESIS_SUBJECT")
    private String don364thesisSubject;
    @Size(max = 1000)
    @Column(name = "DON364SUPERVISOR")
    private String don364supervisor;
    @Size(max = 100)
    @Column(name = "DON364FIRST_PAYMENT")
    private String don364firstPayment;
    @Size(max = 100)
    @Column(name = "DON364SECOND_PAYMENT")
    private String don364secondPayment;
    @Size(max = 2000)
    @Column(name = "DON364PAYMENT_DESC")
    private String don364paymentDesc;
    @Size(max = 100)
    @Column(name = "DON364PAYMENT_STATUS")
    private String don364paymentStatus;
    @Size(max = 100)
    @Column(name = "DON364ISSTUDYING")
    private String don364isStudying;
    
    @Column(name = "DON364DELETED")
    private Short deleted;
    @JoinColumn(name = "DON360ID", referencedColumnName = "DON360ID")
    @ManyToOne(optional = false)
    private DonCustomer don360id;

    public DonProgram() {
    }

    public DonProgram(Integer don364id) {
        this.don364id = don364id;
    }

    public Integer getDon364id() {
        return don364id;
    }

    public void setDon364id(Integer don364id) {
        this.don364id = don364id;
    }

    public String getDon364programName() {
        return don364programName;
    }

    public void setDon364programName(String don364programName) {
        this.don364programName = don364programName;
    }

    public String getDon364masterThesis() {
        return don364masterThesis;
    }

    public void setDon364masterThesis(String don364masterThesis) {
        this.don364masterThesis = don364masterThesis;
    }

    public String getDon364thesisSubject() {
        return don364thesisSubject;
    }

    public void setDon364thesisSubject(String don364thesisSubject) {
        this.don364thesisSubject = don364thesisSubject;
    }

    public String getDon364supervisor() {
        return don364supervisor;
    }

    public void setDon364supervisor(String don364supervisor) {
        this.don364supervisor = don364supervisor;
    }


    public String getDon364paymentDesc() {
        return don364paymentDesc;
    }

    public void setDon364paymentDesc(String don364paymentDesc) {
        this.don364paymentDesc = don364paymentDesc;
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

    public String getDon364firstPayment() {
        return don364firstPayment;
    }

    public void setDon364firstPayment(String don364firstPayment) {
        this.don364firstPayment = don364firstPayment;
    }

    public String getDon364secondPayment() {
        return don364secondPayment;
    }

    public void setDon364secondPayment(String don364secondPayment) {
        this.don364secondPayment = don364secondPayment;
    }

    public String getDon364paymentStatus() {
        return don364paymentStatus;
    }

    public void setDon364paymentStatus(String don364paymentStatus) {
        this.don364paymentStatus = don364paymentStatus;
    }

    public String getDon364isStudying() {
        return don364isStudying;
    }

    public void setDon364isStudying(String don364isStudying) {
        this.don364isStudying = don364isStudying;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (don364id != null ? don364id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DonProgram)) {
            return false;
        }
        DonProgram other = (DonProgram) object;
        if ((this.don364id == null && other.don364id != null) || (this.don364id != null && !this.don364id.equals(other.don364id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonProgram[ don364id=" + don364id + " ]";
    }
    
}
