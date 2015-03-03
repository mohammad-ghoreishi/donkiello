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
import com.donkiello.model.entity.common.DonUsers;
import com.donkiello.model.service.common.IDonCustomerService;
import com.donkiello.utility.JSFUtils;
import com.donkiello.utility.JndiUtils;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 *
 * @author Mohammad
 */
@ManagedBean
@ViewScoped
public class CustomerManager implements Serializable {

    private DonCustomer selectedCustomer;
    private List<DonCustomer> customerList, filteredCustomers;
    private DonUsers onlineUser;
    private IDonCustomerService customerService;
    private String[] programms;

    public CustomerManager() {

        customerService = getCustomerService();
        customerList = customerService.getAll();
        programms = new String[2];
        programms[0] = "MBA";
        programms[1] = "DBA";
    }

    public String removeRow(DonCustomer selectedCustomer) {
        
        DonCustomer selectedCustomer1 = null;

        if (selectedCustomer != null) {
            selectedCustomer1 = customerService.searchById(selectedCustomer.getDon360id());
            String temp = selectedCustomer.getDon360name();
            
            //cascading remove
            if(selectedCustomer1.getDonPersonalList()!=null)
                for( DonPersonal p : selectedCustomer.getDonPersonalList())
                    p.setDeleted(BaseEntity.DELETE_YES);
            if(selectedCustomer1.getDonBussinessList()!=null)
                for( DonBussiness p : selectedCustomer.getDonBussinessList())
                    p.setDeleted(BaseEntity.DELETE_YES);
            if(selectedCustomer1.getDonPastList()!=null)
                for( DonPast p : selectedCustomer.getDonPastList())
                    p.setDeleted(BaseEntity.DELETE_YES);
            if(selectedCustomer1.getDonProgramList()!=null)
                for( DonProgram p : selectedCustomer.getDonProgramList())
                    p.setDeleted(BaseEntity.DELETE_YES);
            customerService.remove(selectedCustomer);
            customerList.remove(selectedCustomer);
            
            JSFUtils.addFacesInfoMessage(temp + " removed from customers!");
        } else {
        }
        return "";  
    }
    
     public void postProcessXLS(Object document) {
		HSSFWorkbook wb = (HSSFWorkbook) document;
		HSSFSheet sheet = wb.getSheetAt(0);
		HSSFRow header = sheet.getRow(0);
		HSSFCellStyle cellStyle = wb.createCellStyle();  
		cellStyle.setFillForegroundColor(HSSFColor.ORANGE.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
                for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
			HSSFCell cell = header.getCell(i);
			cell.setCellStyle(cellStyle);
		}
	}

    public String viewCustomer(DonCustomer selectedCustomer) {
        
        JSFUtils.storeOnSession("selectedCustomer", selectedCustomer);
        
        try {
            return "addCustomerPage?faces-redirect=true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "";
        }
        
    }

    public String addCustomer() {
        return "addCustomerPage?faces-redirect=true&amp;add=true&amp;";
    }

    private IDonCustomerService getCustomerService() {
        return (IDonCustomerService) JndiUtils.getModelEjb("DonCustomerService");
    }

    public DonCustomer getSelectedCustomer() {
        return selectedCustomer;
    }

    public void setSelectedCustomer(DonCustomer selectedCustomer) {
        this.selectedCustomer = selectedCustomer;
    }

    public List<DonCustomer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<DonCustomer> customerList) {
        this.customerList = customerList;
    }

    public List<DonCustomer> getFilteredCustomers() {
        return filteredCustomers;
    }

    public void setFilteredCustomers(List<DonCustomer> filteredCustomers) {
        this.filteredCustomers = filteredCustomers;
    }

    public DonUsers getOnlineUser() {
        return onlineUser;
    }

    public void setOnlineUser(DonUsers onlineUser) {
        this.onlineUser = onlineUser;
    }

    public String[] getProgramms() {
        return programms;
    }

    public void setProgramms(String[] programms) {
        this.programms = programms;
    }

    
}
