/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.donkiello.model.dao.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonCustomerDao;
import com.donkiello.model.entity.base.BaseEntity;
import com.donkiello.model.entity.common.DonCustomer;
import com.donkiello.model.exeption.BusinessException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonCustomerDao extends AbstractDao implements IDonCustomerDao {

    public DonCustomerDao() {
        super();
    }

    public void create(DonCustomer t) {
        getEntityManager().persist(t);
    }

    public DonCustomer searchById(Object id) {
        return getEntityManager().find(DonCustomer.class, id);
    }

    public void update(DonCustomer t) {
        getEntityManager().merge(t);
    }

    public void remove(DonCustomer t) {
        try {
            t.setDeleted(BaseEntity.DELETE_YES);
            getEntityManager().merge(t);
        } catch (Exception e) {
            System.out.println("exception\n" + e.getMessage());
        }

    }

    public List<DonCustomer> getAll() {
        Query query = getEntityManager().createQuery("SELECT c FROM DonCustomer c WHERE c.deleted = 0");
        List<DonCustomer> customers = query.getResultList();
        return customers;
    }

}
