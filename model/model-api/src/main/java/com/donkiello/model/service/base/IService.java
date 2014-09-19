package com.donkiello.model.service.base;

import java.util.List;
import com.donkiello.model.exeption.BusinessException;
import javax.persistence.EntityTransaction;

public interface IService<T> {
	
    public EntityTransaction getTransaction();
    public void create(T t) throws BusinessException;
    public T searchById(Object id) throws BusinessException;
    public void update(T t) throws BusinessException;
    public void remove(T t) throws BusinessException;
    public List<T> getAll() throws BusinessException;
}