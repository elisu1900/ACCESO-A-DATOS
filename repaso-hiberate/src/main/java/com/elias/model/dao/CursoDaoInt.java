package com.elias.model.dao;

import com.elias.model.entity.Curso;

import java.util.List;

public interface CursoDaoInt {

    List<Curso> showWithProfesor();

    List<Curso> getCursosConNotaMediaMayorQue(Double notaMinima);
}
