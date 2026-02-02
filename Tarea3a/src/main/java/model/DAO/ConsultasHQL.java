package model.DAO;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;

import java.util.List;

public class ConsultasHQL {

    public static List<Object[]> primera(Session sesion) {

        String hql = """
        SELECT c.categoria, p.producto
        FROM Productos p
        JOIN p.categoria c
        WHERE p.producto LIKE '%q%'
        ORDER BY c.categoria, p.producto
        """;

        return sesion.createQuery(hql, Object[].class).getResultList();
    }

}
