package com.elias.model.dao;

import com.elias.Util.HibernateUtil;
import com.elias.model.entity.Alumno;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.util.List;

public class AlumnoDaoImpl extends CommonDaoImpl<Alumno> implements AlumnoDaoInt {

    private Session sesion;

    protected AlumnoDaoImpl(Session session) {
        super(session);
        this.sesion = session;
    }

    public AlumnoDaoImpl() {
        this(HibernateUtil.getSession());
    }

    @Override
    public Alumno searchBy(Integer id) {
        return sesion.createQuery(
                        "FROM Alumno a WHERE a.id = :id",
                        Alumno.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Alumno> searchByCurso(String nombreCurso) {
        String hql = """
                SELECT a
                FROM Alumno a
                JOIN a.matricula m
                JOIN m.curso c
                Where c.nombre = :nombreCurso
                """;

        return sesion.createQuery(hql, Alumno.class)
                .setParameter("nombreCurso", nombreCurso)
                .getResultList();
    }

    @Override
    public BigDecimal seacrhNotaByAlumno(String nombre) {
        String hql = """
                SELECT AVG(m.nota)
                FROM Matricula m
                WHERE m.alumno.nombre = :nombre
                """;

        return sesion.createQuery(hql, BigDecimal.class)
                .setParameter("nombre", nombre).uniqueResult();
    }
}
