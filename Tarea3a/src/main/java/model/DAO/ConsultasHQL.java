package model.DAO;

import jakarta.persistence.EntityManager;
import org.hibernate.Session;

import java.time.LocalDate;
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

    public static List<Object[]> segunda(Session sesion) {
        String hql = """
                SELECT p.id, c.pais, p.fechaPedido
                FROM Pedidos p
                JOIN p.cliente c
                WHERE p.fechaPedido BETWEEN :fechaInicio AND :fechaFin
                ORDER BY p.fechaPedido, p.id
                """;

        return sesion.createQuery(hql, Object[].class)
                .setParameter("fechaInicio", LocalDate.of(1997, 5, 1))
                .setParameter("fechaFin", LocalDate.of(1997, 5, 31))
                .getResultList();

    }

    public static List<Object[]> tercera(Session sesion) {
        String hql = """
                SELECT d.pedido.id, p.fechaPedido, d.cantidad, pr.producto, d.precioUnidad
                FROM Pedidos p
                JOIN p.detalles d 
                JOIN d.producto pr
                WHERE p.id IN (10285,10298)
                ORDER BY p.id, p.fechaPedido
                """;
        return sesion.createQuery(hql, Object[].class).getResultList();
    }

    public static List<Object[]> cuarta(Session sesion) {
        String hql = """
                SELECT year(p.fechaPedido) año, month(p.fechaPedido) mes, SUM(d.cantidad * d.precioUnidad * (1 - d.descuento)) total
                FROM Pedidos p
                JOIN p.detalles d
                GROUP BY 1,2
                ORDER BY 3
                """;
        return sesion.createQuery(hql, Object[].class).getResultList();
    }

    public static List<Object[]> quinta(Session sesion) {
        String hql = """
                FROM Pedidos p
                WHERE empleado.id = (SELECT id FROM Empleados e WHERE e.nombre = 'Nancy')                
                """;
        return sesion.createQuery(hql, Object[].class).getResultList();
    }

    public static List<Object[]> sexta(Session sesion) {
        String hql = """
                FROM Pedidos p
                Where empleado.id = (Select id From Empleados e Where e.nombre = "ANTON")
                """;
        return sesion.createQuery(hql, Object[].class).getResultList();
    }

    public static List<Object[]> septima(Session sesion) {
        String hql = """
                SELECT p.categoria, COUNT(p.id),AVG(p.precioUnidad) as precioMedio
                FROM Productos p
                LEFT JOIN p.categoria
                GROUP BY p.categoria
                """;
        return sesion.createQuery(hql, Object[].class).getResultList();
    }

    public static List<Object[]> octava(Session sesion) {
        String hql = """
                SELECT DISTINCT d.pedido.id
                FROM Detalles d
                WHERE d.producto.id IN (
                SELECT pr.id
                FROM Productos pr
                WHERE pr.categoria.id IN (2,3))
                GROUP BY 1
                """;

        return sesion.createQuery(hql, Object[].class).getResultList();
    }

    public static List<Object[]> novena(Session sesion) {
        String hql = """
                SELECT DISTINCT c.empresa
                FROM Clientes c
                JOIN c.pedidos p
                JOIN p.detalles d
                JOIN d.producto pr
                WHERE p.fechaPedido BETWEEN :fechaInicio AND :fechaFin
                AND pr.producto LIKE '%queso%'
                """;
        return sesion.createQuery(hql, Object[].class)
                .setParameter("fechaInicio", LocalDate.of(1997,07,01))
                .setParameter("fechaFin", LocalDate.of(1997,07,31))
                .getResultList();

    }
}
