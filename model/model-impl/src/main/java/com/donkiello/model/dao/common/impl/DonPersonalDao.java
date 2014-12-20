/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.dao.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonPersonalDao;
import com.donkiello.model.entity.common.DonPersonal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonPersonalDao extends AbstractDao implements IDonPersonalDao{
     
    public DonPersonalDao(){
    super();
    }

    public void create(DonPersonal t) {
        getEntityManager().persist(t);
    }

    public DonPersonal searchById(Object id) {
        return getEntityManager().find(DonPersonal.class, id);
    }

    public void update(DonPersonal t) {
        getEntityManager().merge(t);
    }

    public void remove(DonPersonal t) {
        t.setDeleted(Short.valueOf("1"));
        getEntityManager().merge(t);
    }

    public List<DonPersonal> getAll() {
        Query query = getEntityManager().createQuery("SELECT c FROM DonPersonal c WHERE c.deleted = 0  ");
        List<DonPersonal> personal = query.getResultList();
        return personal;
    }
    
}
