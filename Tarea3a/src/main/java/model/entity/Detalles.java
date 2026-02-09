package model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "detalles")
public class Detalles implements Serializable {

    @EmbeddedId
    private DetallesId id;

    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_id")
    private Pedidos pedido;

    @ManyToOne
    @MapsId("productoId")
    @JoinColumn(name = "producto_id")
    private Productos producto;

    @Column(name = "precio_unidad")
    private BigDecimal precioUnidad;

    @Column(columnDefinition = "SMALLINT")
    private Short cantidad;

    @Column
    private Double descuento;

    public Detalles(DetallesId id, Pedidos pedido, Productos producto, BigDecimal precioUnidad, Short cantidad, Double descuento) {
        this.id = id;
        this.pedido = pedido;
        this.producto = producto;
        this.precioUnidad = precioUnidad;
        this.cantidad = cantidad;
        this.descuento = descuento;
    }

    public Detalles() {
    }

    public DetallesId getId() {
        return id;
    }

    public void setId(DetallesId id) {
        this.id = id;
    }

    public Pedidos getPedido() {
        return pedido;
    }

    public void setPedido(Pedidos pedido) {
        this.pedido = pedido;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public BigDecimal getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(BigDecimal precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Detalles detalles = (Detalles) o;
        return Objects.equals(id, detalles.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Detalles{" +
                "id=" + id +
                ", producto=" + (producto != null ? producto.getProducto() : "null") +
                ", cantidad=" + cantidad +
                ", precioUnidad=" + precioUnidad +
                ", descuento=" + descuento +
                '}';
    }
}