package model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "empleados")
public class Empleados implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String apellidos;

    @Column
    private String nombre;

    @Column
    private String cargo;

    @Column
    private String tratamiento;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "fecha_contratacion")
    private LocalDate fechaContratacion;

    @Column
    private String direccion;

    @Column
    private String ciudad;

    @Column
    private String region;

    @Column
    private String cp;

    @Column
    private String pais;

    @Column(name = "telefono_domicilio")
    private String telefonoDomicilio;

    @Column
    private String extension;

    @Column
    private String notas;

    @ManyToOne
    @JoinColumn(name = "jefe_id")
    private Empleados jefe;

    @OneToMany(mappedBy = "jefe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Empleados> subordinados;

    // AÑADIDO: Relación con Pedidos
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedidos> pedidos;

    public Empleados(Integer id, String apellidos, String nombre, String cargo, String tratamiento, LocalDate fechaNacimiento, LocalDate fechaContratacion, String direccion, String ciudad, String region, String cp, String pais, String telefonoDomicilio, String extension, String notas, Empleados jefe) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.cargo = cargo;
        this.tratamiento = tratamiento;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.region = region;
        this.cp = cp;
        this.pais = pais;
        this.telefonoDomicilio = telefonoDomicilio;
        this.extension = extension;
        this.notas = notas;
        this.jefe = jefe;
    }

    public Empleados() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefonoDomicilio() {
        return telefonoDomicilio;
    }

    public void setTelefonoDomicilio(String telefonoDomicilio) {
        this.telefonoDomicilio = telefonoDomicilio;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Empleados getJefe() {
        return jefe;
    }

    public void setJefe(Empleados jefe) {
        this.jefe = jefe;
    }

    public List<Empleados> getSubordinados() {
        return subordinados;
    }

    public void setSubordinados(List<Empleados> subordinados) {
        this.subordinados = subordinados;
    }

    public List<Pedidos> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedidos> pedidos) {
        this.pedidos = pedidos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Empleados empleados = (Empleados) o;
        return Objects.equals(id, empleados.id) &&
                Objects.equals(apellidos, empleados.apellidos) &&
                Objects.equals(nombre, empleados.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, apellidos, nombre);
    }

    @Override
    public String toString() {
        return "Empleados{" +
                "id=" + id +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}