/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohammad.donkiello.donkielloapp;

import com.donkiello.model.entity.base.BaseEntity;
import com.donkiello.model.entity.common.DonBussiness;
import com.donkiello.model.entity.common.DonCustomer;
import com.donkiello.model.entity.common.DonPast;
import com.donkiello.model.entity.common.DonPersonal;
import com.donkiello.model.entity.common.DonProgram;
import com.donkiello.model.service.common.IDonCustomerService;
import com.donkiello.model.service.common.IDonPastService;
import com.donkiello.model.service.common.IDonProgramService;
import com.donkiello.utility.JSFUtils;
import com.donkiello.utility.JndiUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author Keyvan Sasani
 */
@ManagedBean(name = "addCustomer")
@ViewScoped
public class AddCustomer implements Serializable {

    private DonCustomer customer = null;
    private List<DonPersonal> listPersonal;
    private List<DonBussiness> listBussiness;
//    private List<DonProgram> listProgram;
    private List<DonPast> listPast = null;
    private List<DonPast> templistPast = null;
    private List<DonPast> deletedListPast = null;
    private List<DonProgram> listIdaq = null;
    private List<DonProgram> templistIdaq = null;
    private List<DonProgram> deletedListIdaq = null;

    private DonPersonal personal;
    private DonBussiness bussiness;
    private DonPast pastEdu;
//    private DonProgram programEdu;
    private int activeIndex, selectedIndex;
    private IDonCustomerService customerService;
    private String rashtiSex = "Male";
//    private String rashtiFirstPayment = "true";
//    private String rashtisecondPayment = "true";
    private String tempDate = "";
    private File passScan;
    private StreamedContent streamedPassScan;
    private Byte[] bps;
    private IDonPastService donPastService;
    private IDonProgramService donProgramService;
    private boolean passScanAvailable;

    private IDonCustomerService getService() {

        return customerService = (IDonCustomerService) JndiUtils.getModelEjb("DonCustomerService");
    }

    public AddCustomer() {
        donPastService = (IDonPastService) JndiUtils.getModelEjb("DonPastService");
        donProgramService = (IDonProgramService) JndiUtils.getModelEjb("DonProgramService");
    }

    public void initialize() {
        passScanAvailable= false;

        if (null == listPast) {
            listBussiness = new ArrayList<DonBussiness>();
            listPast = new ArrayList<DonPast>();
            listPersonal = new ArrayList<DonPersonal>();
            listIdaq = new ArrayList<DonProgram>();
        }
        getService();
        System.out.println("in add customer serializable");
        customer = (DonCustomer) JSFUtils.getFromSession("selectedCustomer");
        if (customer != null) {
            JSFUtils.removeFromSession("selectedCustomer");
            System.out.println(" in if");
            if (null != customer.getDonPersonalList() && null != customer.getDonProgramList()) {
                System.out.println("in second if");
                System.out.println(customer.getDonPersonalList().get(0).getDon361enName());
                personal = customer.getDonPersonalList().get(0);
//                pastEdu = customer.getDonPastList().get(0);
//                programEdu = customer.getDonProgramList().get(0);
                bussiness = customer.getDonBussinessList().get(0);
                templistPast = customer.getDonPastList();
                templistIdaq = customer.getDonProgramList();
                if (null != templistPast) {
                    for (DonPast p : templistPast) {
                        if (p.getDeleted().equals(BaseEntity.DELETE_NO)) {
                            listPast.add(p);
                        }
                    }
                }
                if (null != templistIdaq) {
                    for (DonProgram p : templistIdaq) {
                        if (p.getDeleted().equals(BaseEntity.DELETE_NO)) {
                            listIdaq.add(p);
                        }
                    }
                }

                if (customer.getDonPersonalList().get(0).getDon361birthday() != null) {
                    tempDate = customer.getDonPersonalList().get(0).getDon361birthday().toString();
                }

                if (customer.getDonPersonalList().get(0).getDon361gender() == BaseEntity.DELETE_YES) {
                    rashtiSex = "Male";
                } else {
                    rashtiSex = "Female";
                }

//                if (customer.getDonProgramList().get(0).getDon364firstPayment() == BaseEntity.DELETE_YES) {
//                    rashtiFirstPayment = "true";
//                } else {
//                    rashtiFirstPayment = "false";
//                }
//
//                if (customer.getDonProgramList().get(0).getDon364secondPayment() == BaseEntity.DELETE_YES) {
//                    rashtisecondPayment = "true";
//                } else {
//                    rashtisecondPayment = "false";
//                }
            }
        } else {
            System.out.println("in else");
            customer = new DonCustomer();
            bussiness = new DonBussiness();
            personal = new DonPersonal();
            pastEdu = new DonPast();

        }
    }

    public void onRowEdit(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Car Edited", ((Car) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Car) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void addPast() {
        System.out.println("add past method ");
        DonPast t = new DonPast();
        t.setDon360id(customer);
        t.setDeleted(BaseEntity.DELETE_NO);
        listPast.add(t);

    }

    public void addIdaq() {
        System.out.println("add idaq method ");
        DonProgram t = new DonProgram();
        t.setDon360id(customer);
        t.setDeleted(BaseEntity.DELETE_NO);
        listIdaq.add(t);

    }

    public void deletePastRow(DonPast p) {
        if (null == deletedListPast) {
            deletedListPast = new ArrayList<DonPast>();
        }
        p.setDeleted(BaseEntity.DELETE_YES);
        deletedListPast.add(p);

        listPast.remove(p);

    }

    public void deleteIdaqRow(DonProgram p) {
        if (null == deletedListIdaq) {
            deletedListIdaq = new ArrayList<DonProgram>();
        }
        p.setDeleted(BaseEntity.DELETE_YES);
        deletedListIdaq.add(p);
        listIdaq.remove(p);
    }

    public String addPastInfo() {
        System.out.println("salam");

        return "";
    }

    public String addIdaqInfo() {
        System.out.println("salam");
        System.out.println("salam2");
        return "";
    }

    public String addNewBussiness() {
        System.out.println("salam");
        System.out.println("salam2");
        return "";
    }

    public String commitCustomer() {
        System.out.println("in commit");
        if (rashtiSex.equalsIgnoreCase("male")) {
            personal.setDon361gender(BaseEntity.DELETE_YES);
        } else {
            personal.setDon361gender(BaseEntity.DELETE_NO);
        }

//        if (rashtiFirstPayment.equalsIgnoreCase("true")) {
//            programEdu.setDon364firstPayment(BaseEntity.DELETE_YES);
//        } else {
//            programEdu.setDon364firstPayment(BaseEntity.DELETE_NO);
//        }
//
//        if (rashtisecondPayment.equalsIgnoreCase("true")) {
//            programEdu.setDon364secondPayment(BaseEntity.DELETE_YES);
//        } else {
//            programEdu.setDon364secondPayment(BaseEntity.DELETE_NO);
//        }
        /// adding father to childs
        for (DonPast p : listPast) {
            if (null == p.getDon360id() && null == p.getDeleted()) {
                System.out.println("jack na");
                p.setDeleted(BaseEntity.DELETE_NO);
                p.setDon360id(customer);
            }
        }
        if (null != deletedListPast) {
            for (DonPast p : deletedListPast) {
                donPastService.remove(p);
            }
        }
        for (DonProgram p : listIdaq) {
            if (null == p.getDon360id() && null == p.getDeleted()) {
                p.setDeleted(BaseEntity.DELETE_NO);
                p.setDon360id(customer);
            }
        }
        if (null != deletedListIdaq) {
            for (DonProgram p : deletedListIdaq) {
                donProgramService.remove(p);
            }
        }

        bussiness.setDon360id(customer);
//        pastEdu.setDon360id(customer);
        personal.setDon360id(customer);
//        programEdu.setDon360id(customer);
//        programEdu.setDeleted(BaseEntity.DELETE_NO);
        personal.setDeleted(BaseEntity.DELETE_NO);
        bussiness.setDeleted(BaseEntity.DELETE_NO);
//        pastEdu.setDeleted(BaseEntity.DELETE_NO);
        listBussiness.add(bussiness);
//        listPast.add(pastEdu);

        listPersonal.add(personal);
//        listProgram.add(programEdu);
        customer.setDonBussinessList(listBussiness);
        customer.setDonPersonalList(listPersonal);
        customer.setDonProgramList(listIdaq);
//        customer.setDonPastList(null);

        customer.setDonPastList(listPast);
//        customer.setDonProgramList(list);
        customer.setDeleted(BaseEntity.DELETE_NO);
        System.out.println(personal.getDon361name());

        //uploading File
        //http://forum.primefaces.org/viewtopic.php?f=3&t=14562
        // tokhom adding
        // TODO : tell and bussinessname and payment status and program lists
        customer.setDon360name(personal.getDon361enName() + " " + personal.getDon361enFamily());
        customer.setDon360mobileno(personal.getDon361mobileNumber());
        customer.setDon360bussinessNames(bussiness.getDon368bussName());
//        customer.setDon360programs(programEdu.getDon364programName());
        customer.setDon360programs(managePrograms(listIdaq));
        customerService.update(customer);
        System.out.println("after commit");
        return "firstPage";
    }

    public String cancelCustomer() {
        return "firstPage";
    }

    //oni ke to oon safhe aval neshoon midim
    public String managePrograms(List<DonProgram> programList) {
        String s = "";
        int i = 0;
        for (DonProgram p : programList) {
            if (null != p.getDon364programName()) {
                if (i == 0) {
                    s += p.getDon364programName();
                } else {
                    s += " - " + p.getDon364programName();
                }
            }
            i++;
        }
        return s;
    }

    ///Setters And Getters
    public DonCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(DonCustomer customer) {
        this.customer = customer;
    }

    public DonPersonal getPersonal() {
        return personal;
    }

    public void setPersonal(DonPersonal personal) {
        this.personal = personal;
    }

    public DonBussiness getBussiness() {
        return bussiness;
    }

    public void setBussiness(DonBussiness bussiness) {
        this.bussiness = bussiness;
    }

    public DonPast getPastEdu() {
        return pastEdu;
    }

    public void setPastEdu(DonPast pastEdu) {
        this.pastEdu = pastEdu;
    }

//    public DonProgram getProgramEdu() {
//        return programEdu;
//    }
//
//    public void setProgramEdu(DonProgram programEdu) {
//        this.programEdu = programEdu;
//    }
    public String getRashtiSex() {
        return rashtiSex;
    }

    public void setRashtiSex(String rashtiSex) {
        this.rashtiSex = rashtiSex;
    }

//    public String getRashtiFirstPayment() {
//        return rashtiFirstPayment;
//    }
//
//    public void setRashtiFirstPayment(String rashtiFirstPayment) {
//        this.rashtiFirstPayment = rashtiFirstPayment;
//    }
//
//    public String getRashtisecondPayment() {
//        return rashtisecondPayment;
//    }
//
//    public void setRashtisecondPayment(String rashtisecondPayment) {
//        this.rashtisecondPayment = rashtisecondPayment;
//    }
    public String getTempDate() {
        return tempDate;
    }

    public void setTempDate(String tempDate) {

        this.tempDate = tempDate;
    }

    public File getPassScan() {
        return passScan;
    }

    public void setPassScan(File passScan) {
        this.passScan = passScan;
        try {
            this.streamedPassScan = new DefaultStreamedContent( new FileInputStream(passScan));
            } catch (FileNotFoundException ex) {
                System.out.println("exception\n" + ex.getMessage());
        }
    }

    public int getSelectedIndex() {
        return selectedIndex;
    }

    public void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public int getActiveIndex() {
        return activeIndex;
    }

    public void setActiveIndex(int activeIndex) {
        this.activeIndex = activeIndex;
    }

    public List<DonPast> getListPast() {
        return listPast;
    }

    public void setListPast(List<DonPast> listPast) {
        this.listPast = listPast;
    }

    public List<DonProgram> getListIdaq() {
        return listIdaq;
    }

    public void setListIdaq(List<DonProgram> listIdaq) {
        this.listIdaq = listIdaq;
    }

    public boolean isPassScanAvailable() {
        return passScanAvailable;
    }

    public void setPassScanAvailable(boolean passScanAvailable) {
        this.passScanAvailable = passScanAvailable;
    }
    
    public void setpscan(){
        this.passScanAvailable = true;
    }

    public StreamedContent getStreamedPassScan() {
        return streamedPassScan;
    }

    public void setStreamedPassScan(StreamedContent streamedPassScan) {
        this.streamedPassScan = streamedPassScan;
    }
    
}
