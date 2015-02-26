/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.service.common;

import com.donkiello.model.entity.common.DonCustomer;
import com.donkiello.model.exeption.BusinessException;
import com.donkiello.model.service.base.IService;
import javax.ejb.Remote;

/**
 *
 * @author Mohammad
 */
@Remote
public interface IDonCustomerService extends IService<DonCustomer>{
    public void insertPhoto(byte[] image , int pid) throws BusinessException;
}
