/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.dao.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonEducationalInfoDao;
import com.donkiello.model.entity.common.DonEducationalInfo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonEducationalInfoDao extends AbstractDao implements IDonEducationalInfoDao{

    
    public DonEducationalInfoDao(){
    super();
    }
    
    public void create(DonEducationalInfo t) {
        getEntityManager().persist(t);
    }

    public DonEducationalInfo searchById(Object id) {
        return getEntityManager().find(DonEducationalInfo.class, id);
    }

    public void update(DonEducationalInfo t) {
        getEntityManager().merge(t);
    }

    public void remove(DonEducationalInfo t) {
        getEntityManager().merge(t);
    }

    public List<DonEducationalInfo> getAll() {
        Query query = getEntityManager().createQuery("SELECT c FROM DonEducationalInfo ");
        List<DonEducationalInfo> educationalInfos = query.getResultList();
        return educationalInfos;
    }
    
}
