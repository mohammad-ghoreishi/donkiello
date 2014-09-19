/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.dao.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonHobbiesDao;
import com.donkiello.model.entity.common.DonHobbies;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonHobbiesDao extends AbstractDao implements IDonHobbiesDao{
    
    public DonHobbiesDao(){
    super();
    }

    public void create(DonHobbies t) {
        getEntityManager().persist(t);
    }

    public DonHobbies searchById(Object id) {
        return getEntityManager().find(DonHobbies.class, id);
    }

    public void update(DonHobbies t) {
        getEntityManager().merge(t);
    }

    public void remove(DonHobbies t) {
        getEntityManager().merge(t);
    }

    public List<DonHobbies> getAll() {
        Query query = getEntityManager().createQuery("SELECT c FROM DonHobbies ");
        List<DonHobbies> hobbies = query.getResultList();
        return hobbies;
    }
    
}
