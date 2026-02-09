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
        List<Object[]> resultados = ConsultasHQL.novena(session);
        session.getTransaction().commit();

        for (Object[] fila : resultados) {
            for (int i = 0; i < fila.length; i++) {
                System.out.println(fila[i]);
            }
        }

        session.close();
        HibernateUtil.getSession().close();
    }
}
