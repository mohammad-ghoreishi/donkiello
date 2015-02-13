/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.dao.common.inter;

import com.donkiello.model.dao.base.CRUD;
import com.donkiello.model.entity.common.DonUsers;
import com.donkiello.model.exeption.BusinessException;

/**
 *
 * @author Mohammad
 */
public interface IDonUsersDao extends CRUD<DonUsers>{
    public String checkLogin(String username , String password) throws BusinessException;
    public DonUsers getOnlineUser(String name) throws BusinessException;
}
