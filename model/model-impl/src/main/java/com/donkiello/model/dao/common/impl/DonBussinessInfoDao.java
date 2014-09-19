/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.dao.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonBussinessInfoDao;
import com.donkiello.model.entity.common.DonBussinessInfo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonBussinessInfoDao extends AbstractDao implements IDonBussinessInfoDao{

    
    public DonBussinessInfoDao (){
    super();
    }
    
    public void create(DonBussinessInfo t) {
        getEntityManager().persist(t);
    }

    public DonBussinessInfo searchById(Object id) {
        return getEntityManager().find(DonBussinessInfo.class, id);
    }

    public void update(DonBussinessInfo t) {
         getEntityManager().merge(t);
    }

    public void remove(DonBussinessInfo t) {
        getEntityManager().merge(t);
    }

    public List<DonBussinessInfo> getAll() {
        Query query = getEntityManager().createQuery("SELECT c FROM DonBussinessInfo ");
        List<DonBussinessInfo> bussinessInfos = query.getResultList();
        return bussinessInfos;
    }
    
}
