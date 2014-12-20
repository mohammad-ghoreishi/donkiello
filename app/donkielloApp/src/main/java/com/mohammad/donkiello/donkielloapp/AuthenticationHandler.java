/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohammad.donkiello.donkielloapp;

import com.donkiello.model.entity.common.DonUsers;
import com.donkiello.model.service.common.IDonCustomerService;
import com.donkiello.model.service.common.IDonPersonalService;
import com.donkiello.model.service.common.IDonUsersService;
import com.donkiello.utility.JSFUtils;
import com.donkiello.utility.JndiUtils;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Mohammad
 */
@ManagedBean(name = "login")
@SessionScoped
public class AuthenticationHandler implements Serializable {

    private IDonCustomerService customerService;
    private String userName;
    private String password;
    private IDonUsersService donUsersService;
    private DonUsers onlineUser;
    private List<DonUsers> dus;
    private IDonPersonalService donPersonalService;
    private DonUsers user;
    private String salam;
    public AuthenticationHandler() {
        user = new DonUsers();
        
        donUsersService = getDonUsersService();
//        System.out.println("before get service");
//        customerService = (IDonCustomerService) JndiUtils.getModelEjb("DonCustomerService");
//        System.out.println("after get service");
//        customerService.getAll();
//        System.out.println("after get all");
//         donUsersService.create(user);
    }

    public String authenticate() {
        try {

            System.out.println("authenticate");
            dus = donUsersService.getAll();
//        System.out.println(dus.get(0).getName());
            if (userName == null || userName.length() < 1 || password == null || password.length() < 1) {
                System.out.println("not entered");
                JSFUtils.addFacesErrorMessage("Authentication Failed!", "Please Enter needed Values");
                password = "";
                return "";
            } else {
                String name = donUsersService.checkLogin(userName, password);
                if (name == null) {
                    JSFUtils.addFacesErrorMessage("Authentication Failed!", "Incorrect User name or Password");
                    password = "";
                    System.out.println("authenticate null");
                    return "";
                } else {
                    System.out.println(name);
                    return "firstPage";
                }

            }
        } catch (Exception e) {
            System.out.println("exeption");
            System.out.println(e.getMessage() + " " + e.getCause());
            return "";
        }
//        return "";
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private IDonUsersService getDonUsersService() {
        return (IDonUsersService) JndiUtils.getModelEjb("DonUsersService");
    }

}
