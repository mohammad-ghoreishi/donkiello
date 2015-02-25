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
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

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
    private List<DonPast> listPast = null;
    private List<DonPast> templistPast = null;
    private List<DonPast> deletedListPast = null;
    private List<DonProgram> listIdaq = null;
    private List<DonProgram> templistIdaq = null;
    private List<DonProgram> deletedListIdaq = null;
    private DonPersonal personal;
    private DonBussiness bussiness;
    private DonPast pastEdu;
    private int activeIndex, selectedIndex;
    private IDonCustomerService customerService;
    private String rashtiSex = "Male";
    private String tempDate = "";
    private File passScan;
    private boolean passScanAvailable;
    private IDonPastService donPastService;
    private IDonProgramService donProgramService;
    private UploadedFile pfile;
    private String tmpFirstPayment;

    private StreamedContent passImage;

    private IDonCustomerService getService() {
        return customerService = (IDonCustomerService) JndiUtils.getModelEjb("DonCustomerService");
    }

    public AddCustomer() {
        donPastService = (IDonPastService) JndiUtils.getModelEjb("DonPastService");
        donProgramService = (IDonProgramService) JndiUtils.getModelEjb("DonProgramService");
    }

    public void initialize() {
        passScanAvailable = false;
        if (null == listPast) {
            listBussiness = new ArrayList<DonBussiness>();
            listPast = new ArrayList<DonPast>();
            listPersonal = new ArrayList<DonPersonal>();
            listIdaq = new ArrayList<DonProgram>();
        }
        getService();
        customer = (DonCustomer) JSFUtils.getFromSession("selectedCustomer");
        if (customer != null) {
            JSFUtils.removeFromSession("selectedCustomer");
            if (null != customer.getDonPersonalList() && null != customer.getDonProgramList()) {
                personal = customer.getDonPersonalList().get(0);
                bussiness = customer.getDonBussinessList().get(0);
                templistPast = customer.getDonPastList();
                templistIdaq = customer.getDonProgramList();
                //loading Photos
                if (null != personal.getDon361passportScan()) {
                    passScanAvailable = true;
                    
//                    try {
//                        FileOutputStream fos = new FileOutputStream(passScan);
//                        fos.write(personal.getDon361passportScan());
//                        fos.close();
//                    } catch (Exception ex) {
//                        System.out.println("exception in byte to file : " + ex.getMessage());
//                    }

                }
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
    }

    public void onRowCancel(RowEditEvent event) {
    }

    public void handleFileUpload(FileUploadEvent event) {

        this.pfile = event.getFile();
        System.out.println(pfile.getFileName());
        byte[] myfile = new byte[pfile.getContents().length];
        System.arraycopy(pfile.getContents(), 0, myfile, 0, pfile.getContents().length);
        System.out.println("before setting do entity");
        personal.setDon361passportScan(myfile);
        System.out.println("after setting to entity");

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
        personal.setDon360id(customer);
        personal.setDeleted(BaseEntity.DELETE_NO);
        bussiness.setDeleted(BaseEntity.DELETE_NO);
        listBussiness.add(bussiness);
        listPersonal.add(personal);
        customer.setDonBussinessList(listBussiness);
        customer.setDonPersonalList(listPersonal);
        customer.setDonProgramList(listIdaq);
        customer.setDonPastList(listPast);
        customer.setDeleted(BaseEntity.DELETE_NO);
        //uploading File
        //http://forum.primefaces.org/viewtopic.php?f=3&t=14562
        // tokhom adding
        // TODO : tell and bussinessname and payment status and program lists
        customer.setDon360name(personal.getDon361enName() + " " + personal.getDon361enFamily());
        customer.setDon360mobileno(personal.getDon361mobileNumber());
        customer.setDon360bussinessNames(bussiness.getDon368bussName());
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

    public String getRashtiSex() {
        return rashtiSex;
    }

    public void setRashtiSex(String rashtiSex) {
        this.rashtiSex = rashtiSex;
    }

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

    public void setpscan() {
        this.passScanAvailable = true;
        System.out.println("wordk");
        if (null != pfile) {
            System.out.println(pfile.getFileName());
        }
    }

    public UploadedFile getPfile() {
        System.out.println("getting pfile");
        return pfile;
    }

    public void setPfile(UploadedFile pfile) {
        this.pfile = pfile;
        System.out.println("setting pfile");
    }

    public StreamedContent getPassImage() {

        if(null==this.passImage){
            InputStream is = new ByteArrayInputStream(personal.getDon361passportScan());
            passImage = new DefaultStreamedContent(is);
        
        }
        return passImage;
    }

    public void setPassImage(StreamedContent passImage) {
        this.passImage = passImage;
    }

}
