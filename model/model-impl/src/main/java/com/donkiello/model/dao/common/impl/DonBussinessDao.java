/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.dao.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonBussinessDao;
import com.donkiello.model.entity.common.DonBussiness;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonBussinessDao extends AbstractDao implements IDonBussinessDao{

    public DonBussinessDao(){
    super();
    }
    
    public void create(DonBussiness t) {
        getEntityManager().persist(t);
    }

    public DonBussiness searchById(Object id) {
        return getEntityManager().find(DonBussiness.class, id);
    }

    public void update(DonBussiness t) {
        getEntityManager().merge(t);
    }

    public void remove(DonBussiness t) {
        t.setDeleted(Short.valueOf("1"));
        getEntityManager().merge(t);
    }

    public List<DonBussiness> getAll() {
        Query query = getEntityManager().createQuery("SELECT c FROM DonBussiness c WHERE c.deleted = 0");
        List<DonBussiness> bussinesses = query.getResultList();
        return bussinesses;
    }
    
}
