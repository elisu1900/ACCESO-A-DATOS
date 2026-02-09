package model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String empresa;

    @Column
    private String contacto;

    // CORRECCIÓN: Usar camelCase y @Column para mapear al nombre de la BD
    @Column(name = "cargo_contacto")
    private String cargoContacto;

    @Column
    private String direccion;

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

    @Column
    private String web;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Productos> productos;


    public Proveedor(Integer id, String empresa, String contacto, String cargoContacto, String direccion, String region, String cp, String pais, String telefono, String fax, String web) {
        this.id = id;
        this.empresa = empresa;
        this.contacto = contacto;
        this.cargoContacto = cargoContacto;
        this.direccion = direccion;
        this.region = region;
        this.cp = cp;
        this.pais = pais;
        this.telefono = telefono;
        this.fax = fax;
        this.web = web;
    }

    public Proveedor() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor proveedor = (Proveedor) o;
        return Objects.equals(id, proveedor.id) &&
                Objects.equals(empresa, proveedor.empresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, empresa);
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", empresa='" + empresa + '\'' +
                ", contacto='" + contacto + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}