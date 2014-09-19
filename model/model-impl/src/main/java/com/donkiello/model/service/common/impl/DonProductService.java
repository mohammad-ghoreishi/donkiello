/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.service.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonProductsDao;
import com.donkiello.model.entity.common.DonProducts;
import com.donkiello.model.exeption.BusinessException;
import com.donkiello.model.service.common.inter.IDonProductsService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonProductService implements IDonProductsService{

    @EJB
    private IDonProductsDao productsDao;
    
    
    public EntityTransaction getTransaction() {
        return ((AbstractDao)productsDao).getEntityManager().getTransaction();
    }

    public void create(DonProducts t) throws BusinessException {
        productsDao.create(t);
    }

    public DonProducts searchById(Object id) throws BusinessException {
        return productsDao.searchById(id);
    }

    public void update(DonProducts t) throws BusinessException {
        productsDao.update(t);
    }

    public void remove(DonProducts t) throws BusinessException {
        productsDao.remove(t);
    }

    public List<DonProducts> getAll() throws BusinessException {
        return productsDao.getAll();
    }
    
    
    
}
