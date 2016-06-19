package com.ibcs.base.exception;

/**
 * Created by hossaindoula<hossaindoula@gmail.com> 6/7/2016.
 */
public class HibernateRuntimeException extends RuntimeException {
    public HibernateRuntimeException() {
        super();
    }
    public HibernateRuntimeException(String s) {
        super(s);
    }
    public HibernateRuntimeException(String s, Throwable throwable) {
        super(s, throwable);
    }
    public HibernateRuntimeException(Throwable throwable) {
        super(throwable);
    }
}
