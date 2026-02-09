package com.elias.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class CommonDaoImpl<T> implements CommonDaoInt<T> {

    private Class<T> entityClass;
    private Session session;

    @SuppressWarnings("unchecked")
    protected CommonDaoImpl(Session session) {
        setEntityClass((Class<T>) ((ParameterizedType)
                this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]);
        this.session = session;
    }

    public void insert(final T paramT) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.persist(paramT);  // ← Cambiado de save
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    public void update(final T paramT) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.merge(paramT);  // ← merge es mejor que saveOrUpdate
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    public void delete(final T paramT) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.remove(paramT);  // ← Cambiado de delete
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> searchAll() {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List<T> result = session.createQuery(
                    "FROM " + entityClass.getName(),
                    entityClass
            ).list();
            tx.commit();
            return result;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        }
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
}