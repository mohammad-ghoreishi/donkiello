/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.service.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonCustomerDao;
import com.donkiello.model.entity.common.DonCustomer;
import com.donkiello.model.exeption.BusinessException;
import com.donkiello.model.service.common.inter.IDonCustomerService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonCustomerService implements IDonCustomerService{
    
    @EJB
    private IDonCustomerDao customerDao;

    public EntityTransaction getTransaction() {
        return ((AbstractDao)customerDao).getEntityManager().getTransaction();
    }

    public void create(DonCustomer t) throws BusinessException {
        customerDao.create(t);
    }

    public DonCustomer searchById(Object id) throws BusinessException {
        return customerDao.searchById(id);
    }

    public void update(DonCustomer t) throws BusinessException {
        customerDao.update(t);
    }

    public void remove(DonCustomer t) throws BusinessException {
        customerDao.remove(t);
    }

    public List<DonCustomer> getAll() throws BusinessException {
        return customerDao.getAll();
    }
    
}
