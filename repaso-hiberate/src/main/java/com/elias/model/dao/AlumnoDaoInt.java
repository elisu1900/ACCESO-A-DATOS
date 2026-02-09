package com.elias.model.dao;

import com.elias.model.entity.Alumno;

import java.math.BigDecimal;
import java.util.List;

public interface AlumnoDaoInt {

    Alumno searchBy(Integer id);
    List<Alumno> searchByCurso(String nombreCurso);
    BigDecimal seacrhNotaByAlumno(String nombre);
}
