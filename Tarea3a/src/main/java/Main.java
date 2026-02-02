import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.DAO.ConsultasHQL;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Object[]> resultados = ConsultasHQL.primera(session);
        session.getTransaction().commit();

        for (Object[] fila : resultados) {
            System.out.println(
                    "Categoria: " + fila[0] +
                            " | Producto: " + fila[1]
            );
        }

        session.close();
        HibernateUtil.getSession().close();
    }
}
