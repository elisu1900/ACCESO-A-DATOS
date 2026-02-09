package com.elias.model.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("ALUMNO")
public class Alumno extends Persona {

    @Column(name = "num_expediente")
    private String numExpediente;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<Matricula> matricula;
    public Alumno() {
    }

    public String getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(String numExpediente) {
        this.numExpediente = numExpediente;
    }

    public List<Matricula> getMatricula() {
        return matricula;
    }

    public void setMatricula(List<Matricula> matricula) {
        this.matricula = matricula;
    }


    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(numExpediente, alumno.numExpediente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numExpediente);
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "numExpediente='" + numExpediente + '\'' +
                '}';
    }
}
