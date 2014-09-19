/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.dao.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonProductsDao;
import com.donkiello.model.entity.common.DonProducts;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonProductDao extends AbstractDao implements IDonProductsDao{
    
    public DonProductDao(){
    super();
    }

    public void create(DonProducts t) {
        getEntityManager().persist(t);
    }

    public DonProducts searchById(Object id) {
        return getEntityManager().find(DonProducts.class, id);
    }

    public void update(DonProducts t) {
        getEntityManager().merge(t);
    }

    public void remove(DonProducts t) {
        getEntityManager().merge(t);
    }

    public List<DonProducts> getAll() {
        Query query = getEntityManager().createQuery("SELECT c FROM DonProducts ");
        List<DonProducts> products = query.getResultList();
        return products;
    }
    
}
