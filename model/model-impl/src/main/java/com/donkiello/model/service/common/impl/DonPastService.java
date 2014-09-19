/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.service.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonPastDao;
import com.donkiello.model.entity.common.DonPast;
import com.donkiello.model.exeption.BusinessException;
import com.donkiello.model.service.common.inter.IDonPastService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonPastService implements IDonPastService{
    
    @EJB
    private IDonPastDao pastDao;

    public EntityTransaction getTransaction() {
        return ((AbstractDao)pastDao).getEntityManager().getTransaction();
    }

    public void create(DonPast t) throws BusinessException {
        pastDao.create(t);
    }

    public DonPast searchById(Object id) throws BusinessException {
        return pastDao.searchById(id);
    }

    public void update(DonPast t) throws BusinessException {
        pastDao.create(t);
    }

    public void remove(DonPast t) throws BusinessException {
        pastDao.remove(t);
    }

    public List<DonPast> getAll() throws BusinessException {
        return pastDao.getAll();
    }
    
}
