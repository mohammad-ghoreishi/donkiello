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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
//    @NamedQuery(name = "DonProgram.findAll", query = "SELECT d FROM DonProgram d")})
public class DonProgram implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "don364id")
    private BigDecimal id;
    @Size(max = 1000)
    @Column(name = "don364program_name")
    private String programName;
    @Size(max = 2000)
    @Column(name = "don364master_thesis")
    private String masterThesis;
    @Size(max = 2000)
    @Column(name = "don364thesis_subject")
    private String thesisSubject;
    @Size(max = 1000)
    @Column(name = "don364supervisor")
    private String supervisor;
    @Column(name = "don364first_payment")
    private Short firstPayment;
    @Column(name = "don364second_payment")
    private Short secondPayment;
    @Size(max = 2000)
    @Column(name = "don364payment_desc")
    private String paymentDesc;
    @Column(name = "don364deleted")
    private Short deleted;
    @JoinColumn(name = "don363id", referencedColumnName = "don363id")
    @ManyToOne
    private DonEducationalInfo don363id;

    public DonProgram() {
    }

    public DonProgram(BigDecimal don364id) {
        this.id = don364id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getMasterThesis() {
        return masterThesis;
    }

    public void setMasterThesis(String masterThesis) {
        this.masterThesis = masterThesis;
    }

    public String getThesisSubject() {
        return thesisSubject;
    }

    public void setThesisSubject(String thesisSubject) {
        this.thesisSubject = thesisSubject;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public Short getFirstPayment() {
        return firstPayment;
    }

    public void setFirstPayment(Short firstPayment) {
        this.firstPayment = firstPayment;
    }

    public Short getSecondPayment() {
        return secondPayment;
    }

    public void setSecondPayment(Short secondPayment) {
        this.secondPayment = secondPayment;
    }

    public String getPaymentDesc() {
        return paymentDesc;
    }

    public void setPaymentDesc(String paymentDesc) {
        this.paymentDesc = paymentDesc;
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
        if (!(object instanceof DonProgram)) {
            return false;
        }
        DonProgram other = (DonProgram) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.donkiello.model.entity.common.DonProgram[ don364id=" + id + " ]";
    }
    
}
