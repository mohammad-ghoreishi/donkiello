/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.service.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonBussinessDao;
import com.donkiello.model.entity.common.DonBussiness;
import com.donkiello.model.exeption.BusinessException;
import com.donkiello.model.service.common.inter.IDonBussinessService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonBussinessService implements IDonBussinessService{
    
    @EJB
    private IDonBussinessDao bussinessDao;

    public EntityTransaction getTransaction() {
        return ((AbstractDao)bussinessDao).getEntityManager().getTransaction();
    }

    public void create(DonBussiness t) throws BusinessException {
        bussinessDao.create(t);
    }

    public DonBussiness searchById(Object id) throws BusinessException {
        return bussinessDao.searchById(id);
    }

    public void update(DonBussiness t) throws BusinessException {
        bussinessDao.update(t);
    }

    public void remove(DonBussiness t) throws BusinessException {
        bussinessDao.remove(t);
    }

    public List<DonBussiness> getAll() throws BusinessException {
        return bussinessDao.getAll();
    }
    
}
