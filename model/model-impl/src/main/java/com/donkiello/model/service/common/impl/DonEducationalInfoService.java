/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.service.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonEducationalInfoDao;
import com.donkiello.model.entity.common.DonEducationalInfo;
import com.donkiello.model.exeption.BusinessException;
import com.donkiello.model.service.common.inter.IDonEducationalInfoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonEducationalInfoService implements IDonEducationalInfoService{
    
    @EJB
    private IDonEducationalInfoDao educationalInfoDao;

    public EntityTransaction getTransaction() {
        return ((AbstractDao)educationalInfoDao).getEntityManager().getTransaction();
    }

    public void create(DonEducationalInfo t) throws BusinessException {
        educationalInfoDao.create(t);
    }

    public DonEducationalInfo searchById(Object id) throws BusinessException {
        return educationalInfoDao.searchById(id);
    }

    public void update(DonEducationalInfo t) throws BusinessException {
        educationalInfoDao.update(t);
    }

    public void remove(DonEducationalInfo t) throws BusinessException {
        educationalInfoDao.remove(t);
    }

    public List<DonEducationalInfo> getAll() throws BusinessException {
        return educationalInfoDao.getAll();
    }
    
    
}
