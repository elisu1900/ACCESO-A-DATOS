package com.elias.model.dao;

import com.elias.Util.HibernateUtil;
import com.elias.model.entity.Profesor;
import org.hibernate.Session;

import java.util.List;

public class ProfesorDaoImpl extends CommonDaoImpl<Profesor> implements ProfesorDaoInt{
    Session sesion;
    protected ProfesorDaoImpl(Session session) {
        super(session);
        this.sesion = session;
    }
    public ProfesorDaoImpl(){
        this(HibernateUtil.getSession());
    }

    @Override
    public Profesor showProfesorMasHoras() {
        String hql = """
                SELECT p
                FROM Profesor p
                JOIN p.cursos c
                Where c.horas = (SELECT MAX(c.horas) FROM Curso)
                """;
        return sesion.createQuery(hql, Profesor.class).setMaxResults(1)
                .getSingleResult();
    }
}
