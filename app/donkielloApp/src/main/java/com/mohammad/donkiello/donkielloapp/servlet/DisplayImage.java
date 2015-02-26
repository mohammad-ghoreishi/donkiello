/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohammad.donkiello.donkielloapp.servlet;

import com.donkiello.model.entity.common.DonCustomer;
import com.donkiello.model.entity.common.DonPersonal;
import com.donkiello.model.service.common.IDonCustomerService;
import com.donkiello.model.service.common.IDonPersonalService;
import com.donkiello.utility.JndiUtils;
import java.io.IOException;
import java.io.Serializable;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mohammad
 */
public class DisplayImage extends HttpServlet implements Serializable {

    private static final long serialVersionUID = 4593558495041379082L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String type = request.getParameter("type").trim();
            String id = request.getParameter("pid").trim();
            if (type.equalsIgnoreCase("pps")) {
                IDonPersonalService personalService = (IDonPersonalService) JndiUtils.getModelEjb("DonPersonalService");
                DonPersonal personal = personalService.searchById(Integer.parseInt(id));
                response.reset();
                response.setContentType("image/jpeg");
                response.getOutputStream().write(personal.getDon361passportScan());
                response.flushBuffer();
            } else if (type.equalsIgnoreCase("bcs")) {
                IDonPersonalService personalService = (IDonPersonalService) JndiUtils.getModelEjb("DonPersonalService");
                DonPersonal personal = personalService.searchById(Integer.parseInt(id));
                response.reset();
                response.setContentType("image/jpeg");
                response.getOutputStream().write(personal.getDon361birthCertScan());
                response.flushBuffer();
            }  else if (type.equalsIgnoreCase("ps")) {
                IDonCustomerService customerService = (IDonCustomerService) JndiUtils.getModelEjb("DonCustomerService");
                DonCustomer customer = customerService.searchById(Integer.parseInt(id));
                response.reset();
                response.setContentType("image/jpeg");
                response.getOutputStream().write(customer.getDon360image());
                response.flushBuffer();
            }
        } catch (Exception e) {
            System.out.println("exception in servlet\nparameters are null");
            System.out.println(e.getMessage());
        }
    }
}
