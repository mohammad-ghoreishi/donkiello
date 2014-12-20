/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.dao.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonPastDao;
import com.donkiello.model.entity.common.DonPast;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonPastDao extends AbstractDao implements IDonPastDao{
    
    public DonPastDao(){
    super();
    }

    public void create(DonPast t) {
        getEntityManager().persist(t);
    }

    public DonPast searchById(Object id) {
        return getEntityManager().find(DonPast.class, id);
    }

    public void update(DonPast t) {
        getEntityManager().merge(t);
    }

    public void remove(DonPast t) {
        t.setDeleted(Short.valueOf("1"));
        getEntityManager().merge(t);
    }

    public List<DonPast> getAll() {
        Query query = getEntityManager().createQuery("SELECT c FROM DonPast c WHERE c.deleted = 0 ");
        List<DonPast> bussinesses = query.getResultList();
        return bussinesses;
    }
    
}
