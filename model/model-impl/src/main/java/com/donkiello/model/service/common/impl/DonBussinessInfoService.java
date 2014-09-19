/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.service.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonBussinessInfoDao;
import com.donkiello.model.entity.common.DonBussinessInfo;
import com.donkiello.model.exeption.BusinessException;
import com.donkiello.model.service.common.inter.IDonBussinessInfoService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonBussinessInfoService implements IDonBussinessInfoService{
    
    @EJB
    private IDonBussinessInfoDao bussinessInfoDao;

    public EntityTransaction getTransaction() {
        return ((AbstractDao)bussinessInfoDao).getEntityManager().getTransaction();
    }

    public void create(DonBussinessInfo t) throws BusinessException {
        bussinessInfoDao.create(t);
    }

    public DonBussinessInfo searchById(Object id) throws BusinessException {
        return bussinessInfoDao.searchById(id);
    }

    public void update(DonBussinessInfo t) throws BusinessException {
        bussinessInfoDao.update(t);
    }

    public void remove(DonBussinessInfo t) throws BusinessException {
        bussinessInfoDao.remove(t);
    }

    public List<DonBussinessInfo> getAll() throws BusinessException {
        return bussinessInfoDao.getAll();
    }
    
}
