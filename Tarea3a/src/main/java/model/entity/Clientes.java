package model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "clientes")
public class Clientes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String codigo;

    @Column
    private String empresa;

    @Column
    private String contacto;

    @Column(name = "cargo_contacto")
    private String cargoContacto;

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

    @Column
    private String telefono;

    @Column
    private String fax;

    // AÑADIDO: Relación con Pedidos
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedidos> pedidos;

    public Clientes(Integer id, String codigo, String empresa, String contacto, String cargoContacto, String direccion, String ciudad, String region, String cp, String pais, String telefono, String fax) {
        this.id = id;
        this.codigo = codigo;
        this.empresa = empresa;
        this.contacto = contacto;
        this.cargoContacto = cargoContacto;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.region = region;
        this.cp = cp;
        this.pais = pais;
        this.telefono = telefono;
        this.fax = fax;
    }

    public Clientes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCargoContacto() {
        return cargoContacto;
    }

    public void setCargoContacto(String cargoContacto) {
        this.cargoContacto = cargoContacto;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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
        Clientes clientes = (Clientes) o;
        return Objects.equals(id, clientes.id) &&
                Objects.equals(codigo, clientes.codigo) &&
                Objects.equals(empresa, clientes.empresa);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, empresa);
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", empresa='" + empresa + '\'' +
                ", contacto='" + contacto + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}