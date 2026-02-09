package com.elias.model.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@DiscriminatorValue("PROFESOR")
public class Profesor extends Persona {

    @Column
    private String especialidad;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Curso> cursos;

    public Profesor() {
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Profesor profesor = (Profesor) o;
        return Objects.equals(especialidad, profesor.especialidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), especialidad);
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "especialidad='" + especialidad + '\'' +
                '}';
    }
}
