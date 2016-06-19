package com.ibcs.util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;

import org.hibernate.id.IdentifierGenerator;

public class IdGenerator implements IdentifierGenerator {

    public int generateCustomId() {
        Random random = new Random();
        return random.nextInt(100);
    }

    public Serializable generate(SessionImplementor si, Object o) throws HibernateException {
        Calendar calendar = Calendar.getInstance();
        return this.generateCustomId() + "_" + calendar.get(Calendar.YEAR);
    }
}
