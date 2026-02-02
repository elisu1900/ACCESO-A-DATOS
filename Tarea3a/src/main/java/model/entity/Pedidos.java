package model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
public class Pedidos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleados empleado;

    @Column(name = "fecha_pedido")
    private LocalDate fechaPedido;

    @Column(name = "fecha_entrega")
    private LocalDate fechaEntrega;

    @Column(name = "fecha_envio")
    private LocalDate fechaEnvio;

    @ManyToOne
    @JoinColumn(name = "envio_id")
    private Envios envio;

    @Column
    private BigDecimal cargo;

    @Column(name = "destinatario")
    private String destinatario;

    @Column(name = "direccion_destinatario")
    private String direccionDestinatario;

    @Column(name = "ciudad_destinatario")
    private String ciudadDestinatario;

    @Column(name = "region_destinatario")
    private String regionDestino;

    @Column(name = "cp_destinatario")
    private String cpDestino;

    @Column(name = "pais_destinatario")
    private String paisDestino;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Detalles> detalles;

    public Pedidos(Integer id, Clientes cliente, Empleados empleado, LocalDate fechaPedido, LocalDate fechaEntrega, LocalDate fechaEnvio, Envios envio, BigDecimal cargo, String destinatario, String direccionDestinatario, String ciudadDestinatario, String regionDestino, String cpDestino, String paisDestino) {
        this.id = id;
        this.cliente = cliente;
        this.empleado = empleado;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.fechaEnvio = fechaEnvio;
        this.envio = envio;
        this.cargo = cargo;
        this.destinatario = destinatario;
        this.direccionDestinatario = direccionDestinatario;
        this.ciudadDestinatario = ciudadDestinatario;
        this.regionDestino = regionDestino;
        this.cpDestino = cpDestino;
        this.paisDestino = paisDestino;
    }

    public Pedidos() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public LocalDate getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(LocalDate fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Envios getEnvio() {
        return envio;
    }

    public void setEnvio(Envios envio) {
        this.envio = envio;
    }

    public BigDecimal getCargo() {
        return cargo;
    }

    public void setCargo(BigDecimal cargo) {
        this.cargo = cargo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDireccionDestinatario() {
        return direccionDestinatario;
    }

    public void setDireccionDestinatario(String direccionDestinatario) {
        this.direccionDestinatario = direccionDestinatario;
    }

    public String getCiudadDestinatario() {
        return ciudadDestinatario;
    }

    public void setCiudadDestinatario(String ciudadDestinatario) {
        this.ciudadDestinatario = ciudadDestinatario;
    }

    public String getRegionDestino() {
        return regionDestino;
    }

    public void setRegionDestino(String regionDestino) {
        this.regionDestino = regionDestino;
    }

    public String getCpDestino() {
        return cpDestino;
    }

    public void setCpDestino(String cpDestino) {
        this.cpDestino = cpDestino;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
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
        Pedidos pedidos = (Pedidos) o;
        return Objects.equals(id, pedidos.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "id=" + id +
                ", cliente=" + (cliente != null ? cliente.getEmpresa() : "null") +
                ", empleado=" + (empleado != null ? empleado.getNombre() : "null") +
                ", fechaPedido=" + fechaPedido +
                ", cargo=" + cargo +
                '}';
    }
}
