/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.service.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonUsersDao;
import com.donkiello.model.entity.common.DonUsers;
import com.donkiello.model.exeption.BusinessException;
import com.donkiello.model.service.common.IDonUsersService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonUsersService implements IDonUsersService{
    
    @EJB
    private IDonUsersDao donUsersService;

    public EntityTransaction getTransaction() {
        return ((AbstractDao)donUsersService).getEntityManager().getTransaction();
    }

    public void create(DonUsers t) throws BusinessException {
        donUsersService.create(t);
    }

    public DonUsers searchById(Object id) throws BusinessException {
        return donUsersService.searchById(id);
    }

    public void update(DonUsers t) throws BusinessException {
        donUsersService.update(t);
    }

    public void remove(DonUsers t) throws BusinessException {
        donUsersService.remove(t);
    }

    public List<DonUsers> getAll() throws BusinessException {
        return donUsersService.getAll();
    }

    public String checkLogin(String username, String password) throws BusinessException{
        return donUsersService.checkLogin(username, password);
    }
    
}
