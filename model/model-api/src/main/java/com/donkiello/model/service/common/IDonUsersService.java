/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.service.common;

import com.donkiello.model.entity.common.DonUsers;
import com.donkiello.model.exeption.BusinessException;
import com.donkiello.model.service.base.IService;
import javax.ejb.Remote;

/**
 *
 * @author Mohammad
 */
@Remote
public interface IDonUsersService extends IService<DonUsers>{
    public String checkLogin(String username , String password) throws BusinessException;
    public DonUsers getOnlineUser(String name) throws BusinessException;
    
}
