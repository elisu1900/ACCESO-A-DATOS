package model.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "envios")
public class Envios implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String empresa;
    
    @Column
    private String telefono;

    // AÑADIDO: Relación con Pedidos
    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pedidos> pedidos;

    public Envios(Integer id, String empresa, String telefono) {
        this.id = id;
        this.empresa = empresa;
        this.telefono = telefono;
    }

    public Envios(){}

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        Envios envios = (Envios) o;
        return Objects.equals(id, envios.id) && 
               Objects.equals(empresa, envios.empresa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, empresa);
    }

    @Override
    public String toString() {
        return "Envios{" +
                "id=" + id +
                ", empresa='" + empresa + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
