/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.service.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonHobbiesDao;
import com.donkiello.model.entity.common.DonHobbies;
import com.donkiello.model.exeption.BusinessException;
import com.donkiello.model.service.common.inter.IDonHobbiesService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonHobbiesService implements IDonHobbiesService{

    @EJB
    private IDonHobbiesDao hobbiesDao;
    
    public EntityTransaction getTransaction() {
        return ((AbstractDao)hobbiesDao).getEntityManager().getTransaction();
    }

    public void create(DonHobbies t) throws BusinessException {
        hobbiesDao.create(t);
    }

    public DonHobbies searchById(Object id) throws BusinessException {
        return hobbiesDao.searchById(id);
    }

    public void update(DonHobbies t) throws BusinessException {
        hobbiesDao.update(t);
    }

    public void remove(DonHobbies t) throws BusinessException {
        hobbiesDao.remove(t);
    }

    public List<DonHobbies> getAll() throws BusinessException {
        return hobbiesDao.getAll();
    }
    
    
    
}
