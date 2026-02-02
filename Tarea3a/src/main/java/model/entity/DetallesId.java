package model.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DetallesId implements Serializable {

    @Column(name = "pedido_id")
    private Integer pedidoId;

    @Column(name = "producto_id")
    private Integer productoId;

    public DetallesId() {}

    public DetallesId(Integer pedidoId, Integer productoId) {
        this.pedidoId = pedidoId;
        this.productoId = productoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetallesId)) return false;
        DetallesId that = (DetallesId) o;
        return Objects.equals(pedidoId, that.pedidoId)
                && Objects.equals(productoId, that.productoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidoId, productoId);
    }
}
