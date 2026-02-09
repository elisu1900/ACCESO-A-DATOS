package model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "productos")
public class Productos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String producto;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categorias categoria;

    @Column(name = "cantidad_por_unidad")
    private String cantidadPorUnidad;

    @Column(name = "precio_unidad")
    private BigDecimal precioUnidad;

    @Column(name = "unidades_existencia")
    private Short unidadesExistencias;

    @Column(name = "unidades_pedido")
    private Short unidadesPedido;

    @Column(name = "nivel_nuevo_pedido")
    private Integer nivelNuevoPedido;

    @Column
    private Boolean suspendido;

    @Column
    private String notas;

    @Column
    private BigDecimal iva;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Detalles> detalles;

    public Productos(Integer id, String producto, Proveedor proveedor, Categorias categoria, String cantidadPorUnidad, BigDecimal precioUnidad, Short unidadesExistencias, Short unidadesPedido, Integer nivelNuevoPedido, Boolean suspendido, String notas, BigDecimal iva) {
        this.id = id;
        this.producto = producto;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.cantidadPorUnidad = cantidadPorUnidad;
        this.precioUnidad = precioUnidad;
        this.unidadesExistencias = unidadesExistencias;
        this.unidadesPedido = unidadesPedido;
        this.nivelNuevoPedido = nivelNuevoPedido;
        this.suspendido = suspendido;
        this.notas = notas;
        this.iva = iva;
    }

    public Productos(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public String getCantidadPorUnidad() {
        return cantidadPorUnidad;
    }

    public void setCantidadPorUnidad(String cantidadPorUnidad) {
        this.cantidadPorUnidad = cantidadPorUnidad;
    }

    public BigDecimal getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(BigDecimal precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Short getUnidadesExistencias() {
        return unidadesExistencias;
    }

    public void setUnidadesExistencias(Short unidadesExistencias) {
        this.unidadesExistencias = unidadesExistencias;
    }

    public Short getUnidadesPedido() {
        return unidadesPedido;
    }

    public void setUnidadesPedido(Short unidadesPedido) {
        this.unidadesPedido = unidadesPedido;
    }

    public Integer getNivelNuevoPedido() {
        return nivelNuevoPedido;
    }

    public void setNivelNuevoPedido(Integer nivelNuevoPedido) {
        this.nivelNuevoPedido = nivelNuevoPedido;
    }

    public Boolean getSuspendido() {
        return suspendido;
    }

    public void setSuspendido(Boolean suspendido) {
        this.suspendido = suspendido;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public List<Detalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalles> detalles) {
        this.detalles = detalles;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Productos productos = (Productos) o;
        return Objects.equals(id, productos.id) &&
                Objects.equals(producto, productos.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, producto);
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id=" + id +
                ", producto='" + producto + '\'' +
                ", precioUnidad=" + precioUnidad +
                ", unidadesExistencias=" + unidadesExistencias +
                '}';
    }
}