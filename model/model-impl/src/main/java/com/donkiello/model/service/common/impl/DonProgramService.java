/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.donkiello.model.service.common.impl;

import com.donkiello.model.dao.base.AbstractDao;
import com.donkiello.model.dao.common.inter.IDonProgramDao;
import com.donkiello.model.entity.common.DonProgram;
import com.donkiello.model.exeption.BusinessException;
import com.donkiello.model.service.common.inter.IDonProgramService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityTransaction;

/**
 *
 * @author Mohammad
 */
@Stateless
public class DonProgramService implements IDonProgramService{
    
    @EJB
    private IDonProgramDao programDao;

    public EntityTransaction getTransaction() {
        return ((AbstractDao)programDao).getEntityManager().getTransaction();
    }

    public void create(DonProgram t) throws BusinessException {
        programDao.create(t);
    }

    public DonProgram searchById(Object id) throws BusinessException {
        return programDao.searchById(id);
    }

    public void update(DonProgram t) throws BusinessException {
        programDao.update(t);
    }

    public void remove(DonProgram t) throws BusinessException {
        programDao.remove(t);
    }

    public List<DonProgram> getAll() throws BusinessException {
        return programDao.getAll();
    }
    
}
