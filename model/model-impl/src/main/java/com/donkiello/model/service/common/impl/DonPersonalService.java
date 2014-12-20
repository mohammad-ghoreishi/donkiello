/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.service.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonPersonalDao;
import com.donkiello.model.entity.common.DonPersonal;
import com.donkiello.model.exeption.BusinessException;
import com.donkiello.model.service.common.IDonPersonalService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonPersonalService implements IDonPersonalService{
    
    @EJB
    private IDonPersonalDao donPersonalDao;
    
    
    
    public EntityTransaction getTransaction() {
        return ((AbstractDao)donPersonalDao).getEntityManager().getTransaction();
    }

    public void create(DonPersonal t) throws BusinessException {
        donPersonalDao.create(t);
    }

    public DonPersonal searchById(Object id) throws BusinessException {
        return donPersonalDao.searchById(id);
    }

    public void update(DonPersonal t) throws BusinessException {
       donPersonalDao.update(t);
    }

    public void remove(DonPersonal t) throws BusinessException {
        donPersonalDao.remove(t);
    }

    public List<DonPersonal> getAll() throws BusinessException {
        return donPersonalDao.getAll();
    }
    
}
