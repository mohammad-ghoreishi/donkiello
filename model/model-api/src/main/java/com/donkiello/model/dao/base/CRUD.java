package com.donkiello.model.dao.base;

import java.math.BigDecimal;
import java.util.List;

public interface CRUD<T> {  
	
    public void create(T t);
    public T searchById(Object id);
    public void update(T t);
    public void remove(T t);
    public List<T> getAll();
}
