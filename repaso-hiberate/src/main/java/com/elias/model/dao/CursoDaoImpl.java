package com.elias.model.dao;

import com.elias.Util.HibernateUtil;
import com.elias.model.entity.Curso;
import org.hibernate.Session;

import java.util.List;

public class CursoDaoImpl extends CommonDaoImpl<Curso> implements CursoDaoInt{

    private Session sesion;

    protected CursoDaoImpl(Session session) {
        super(session);
        this.sesion = session;
    }

    public CursoDaoImpl(){
        this(HibernateUtil.getSession());
    }

    @Override
    public List<Curso> showWithProfesor() {

        String hql = """
                SELECT c
                FROM Curso c
                JOIN FETCH c.profesor 
                """;
        return sesion.createQuery(hql,Curso.class).getResultList();
    }

    @Override
    public List<Curso> getCursosConNotaMediaMayorQue(Double notaMinima) {
        String hql = """
            SELECT m.curso
            FROM Matricula m
            GROUP BY m.curso
            HAVING AVG(m.nota) > :notaMinima
            """;
        return sesion.createQuery(hql, Curso.class)
                .setParameter("notaMinima", notaMinima)
                .getResultList();
    }
}
