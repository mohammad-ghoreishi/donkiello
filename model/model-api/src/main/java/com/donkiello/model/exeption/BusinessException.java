package com.donkiello.model.exeption;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BusinessException(Throwable cause) {
        super(cause);
    }

}