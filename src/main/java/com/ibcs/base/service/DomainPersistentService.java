package com.ibcs.base.service;

import com.ibcs.base.view.form.dto.ModelForm;

import java.io.Serializable;
import java.util.List;

/**
 * * @author Mohammed Hossain Doula<hossain.doula@ibcs-primax.com>
 * Created by hossain.doula on 5/15/2016.
 */

public interface DomainPersistentService <T, PK extends Serializable> {

    boolean save(T o);

    boolean delete(T o);

    boolean update(T o);

    List<T> findAll();

    T get(PK id);

    ModelForm getModel();

}

