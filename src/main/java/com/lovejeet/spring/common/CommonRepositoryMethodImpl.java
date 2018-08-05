package com.lovejeet.spring.common;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.GenericTypeResolver;

public abstract class CommonRepositoryMethodImpl<T, ID> implements CommonRepositoryMethod<T, ID> {

    @Autowired
    private SessionUtility sessionUtility;

    /** For the child classes who will be extending this class
     * @return */
    protected Session getSession() {
        return sessionUtility.getSession();
    }

    @SuppressWarnings("unchecked")
    private Class<T> genericClass = (Class<T>) (GenericTypeResolver.resolveTypeArguments(getClass(),
            CommonRepositoryMethodImpl.class))[0];

    public T save(T object) {
        this.getSession().save(object);
        return object;
    }

    @SuppressWarnings("unchecked")
    public T getById(ID id) {
        return (T) this.getSession().get(genericClass, (Serializable) id);
    }

    @SuppressWarnings("unchecked")
    public List<T> fetchAll() {
        return this.getSession().createCriteria(genericClass).list();
    }

    @SuppressWarnings("unchecked")
    public List<T> fetchAll(Integer... ids) {
        return this.getSession().createCriteria(genericClass).add(Restrictions.in("id", ids)).list();
    }

    public int count() {
        return ((Number) this.getSession().createCriteria(genericClass).setProjection(Projections.rowCount())
                .uniqueResult()).intValue();
    }

    public void update(T object) {
        this.getSession().update(object);
    }

    public void delete(T obj) {
        this.getSession().delete(obj);
    }

}
