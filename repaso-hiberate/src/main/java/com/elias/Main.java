package com.elias;

import com.elias.model.dao.AlumnoDaoImpl;
import com.elias.model.dao.CursoDaoImpl;
import com.elias.model.dao.ProfesorDaoImpl;
import com.elias.model.entity.Alumno;
import com.elias.model.entity.Curso;
import com.elias.model.entity.Profesor;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=".repeat(60));
        System.out.println("INICIANDO PRUEBAS DE DAOs");
        System.out.println("=".repeat(60));

        // Inicializar DAOs
        AlumnoDaoImpl alumnoDAO = new AlumnoDaoImpl();
        CursoDaoImpl cursoDAO = new CursoDaoImpl();
        ProfesorDaoImpl profesorDAO = new ProfesorDaoImpl();

        // ==========================================
        // 1. PRUEBA: Mostrar todos los cursos con su profesor
        // ==========================================
        System.out.println("\n1️⃣ CURSOS CON PROFESOR:");
        System.out.println("-".repeat(60));
        try {
            List<Curso> cursosConProfesor = cursoDAO.showWithProfesor();
            if (cursosConProfesor.isEmpty()) {
                System.out.println("❌ No se encontraron cursos");
            } else {
                cursosConProfesor.forEach(curso -> {
                    System.out.println("📚 Curso: " + curso.getNombre() +
                            " | Horas: " + curso.getHoras() +
                            " | Profesor: " +
                            (curso.getProfesor() != null ?
                                    curso.getProfesor().getNombre() : "Sin profesor"));
                });
            }
        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        // ==========================================
        // 2. PRUEBA: Alumnos matriculados en un curso
        // ==========================================
        System.out.println("\n2️⃣ ALUMNOS DEL CURSO 'Java':");
        System.out.println("-".repeat(60));
        try {
            List<Alumno> alumnosCurso = alumnoDAO.searchByCurso("Java");
            if (alumnosCurso.isEmpty()) {
                System.out.println("❌ No hay alumnos en este curso");
            } else {
                alumnosCurso.forEach(alumno -> {
                    System.out.println("👨‍🎓 Alumno: " + alumno.getNombre() +
                            " | Expediente: " + alumno.getNumExpediente());
                });
            }
        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        // ==========================================
        // 3. PRUEBA: Nota media de un alumno
        // ==========================================
        System.out.println("\n3️⃣ NOTA MEDIA DEL ALUMNO 'Ana Torres':");
        System.out.println("-".repeat(60));
        try {
            BigDecimal notaMedia = alumnoDAO.seacrhNotaByAlumno("Ana Torres");
            if (notaMedia != null) {
                System.out.printf("📊 Nota media: %.2f%n", notaMedia);
            } else {
                System.out.println("❌ El alumno no tiene matrículas");
            }
        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        // ==========================================
        // 4. PRUEBA: Cursos con nota media > 7
        // ==========================================
        System.out.println("\n4️⃣ CURSOS CON NOTA MEDIA > 7:");
        System.out.println("-".repeat(60));
        try {
            List<Curso> cursosNotaAlta = cursoDAO.getCursosConNotaMediaMayorQue(7.0);
            if (cursosNotaAlta.isEmpty()) {
                System.out.println("❌ No hay cursos con nota media > 7");
            } else {
                cursosNotaAlta.forEach(curso -> {
                    System.out.println("🌟 Curso: " + curso.getNombre() +
                            " | ID: " + curso.getId());
                });
            }
        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        // ==========================================
        // 5. PRUEBA: Profesor que imparte más horas
        // ==========================================
        System.out.println("\n5️⃣ PROFESOR CON MÁS HORAS:");
        System.out.println("-".repeat(60));
        try {
            Profesor profesorMasHoras = profesorDAO.showProfesorMasHoras();
            if (profesorMasHoras != null) {
                System.out.println("🏆 Profesor: " + profesorMasHoras.getNombre() +
                        " | Especialidad: " + profesorMasHoras.getEspecialidad());
            } else {
                System.out.println("❌ No se encontró ningún profesor");
            }
        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        // ==========================================
        // PRUEBAS CRUD BÁSICO
        // ==========================================
        System.out.println("\n" + "=".repeat(60));
        System.out.println("PRUEBAS CRUD BÁSICO");
        System.out.println("=".repeat(60));

        // ==========================================
        // 6. PRUEBA: Buscar alumno por ID
        // ==========================================
        System.out.println("\n6️⃣ BUSCAR ALUMNO POR ID (ID=1):");
        System.out.println("-".repeat(60));
        try {
            Alumno alumno = alumnoDAO.searchBy(1);
            if (alumno != null) {
                System.out.println("✅ Alumno encontrado:");
                System.out.println("   Nombre: " + alumno.getNombre());
                System.out.println("   Email: " + alumno.getEmail());
                System.out.println("   Expediente: " + alumno.getNumExpediente());
            } else {
                System.out.println("❌ Alumno no encontrado");
            }
        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        // ==========================================
        // 7. PRUEBA: Listar todos los cursos
        // ==========================================
        System.out.println("\n7️⃣ LISTAR TODOS LOS CURSOS:");
        System.out.println("-".repeat(60));
        try {
            List<Curso> todosCursos = cursoDAO.searchAll();
            if (todosCursos.isEmpty()) {
                System.out.println("❌ No hay cursos en la BD");
            } else {
                System.out.println("Total cursos: " + todosCursos.size());
                todosCursos.forEach(curso -> {
                    System.out.println("   - " + curso.getNombre() +
                            " (" + curso.getHoras() + "h)");
                });
            }
        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        // ==========================================
        // 8. PRUEBA: Actualizar email de alumno
        // ==========================================
        System.out.println("\n8️⃣ ACTUALIZAR EMAIL DE ALUMNO (ID=1):");
        System.out.println("-".repeat(60));
        try {
            Alumno alumno = alumnoDAO.searchBy(1);
            if (alumno != null) {
                String emailAntiguo = alumno.getEmail();
                alumno.setEmail("nuevo.email@test.com");
                alumnoDAO.update(alumno);
                System.out.println("✅ Email actualizado:");
                System.out.println("   Anterior: " + emailAntiguo);
                System.out.println("   Nuevo: " + alumno.getEmail());

                // Revertir cambio
                alumno.setEmail(emailAntiguo);
                alumnoDAO.update(alumno);
                System.out.println("✅ Email restaurado");
            }
        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        // ==========================================
        // 9. PRUEBA: Insertar nuevo alumno
        // ==========================================
        System.out.println("\n9️⃣ INSERTAR NUEVO ALUMNO:");
        System.out.println("-".repeat(60));
        try {
            Alumno nuevoAlumno = new Alumno();
            nuevoAlumno.setNombre("Pedro García");
            nuevoAlumno.setEmail("pedro@correo.com");
            nuevoAlumno.setNumExpediente("EXP999");
            nuevoAlumno.setTipoPersona("ALUMNO");

            alumnoDAO.insert(nuevoAlumno);
            System.out.println("✅ Alumno insertado:");
            System.out.println("   Nombre: " + nuevoAlumno.getNombre());
            System.out.println("   ID asignado: " + nuevoAlumno.getId());

            // Eliminar para no alterar BD
            if (nuevoAlumno.getId() != null) {
                alumnoDAO.delete(nuevoAlumno);
                System.out.println("✅ Alumno eliminado (limpieza)");
            }
        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        // ==========================================
        // 10. PRUEBA: Listar todos los alumnos
        // ==========================================
        System.out.println("\n🔟 LISTAR TODOS LOS ALUMNOS:");
        System.out.println("-".repeat(60));
        try {
            List<Alumno> todosAlumnos = alumnoDAO.searchAll();
            if (todosAlumnos.isEmpty()) {
                System.out.println("❌ No hay alumnos en la BD");
            } else {
                System.out.println("Total alumnos: " + todosAlumnos.size());
                todosAlumnos.forEach(alumno -> {
                    System.out.println("   - " + alumno.getNombre() +
                            " (Exp: " + alumno.getNumExpediente() + ")");
                });
            }
        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }

        // ==========================================
        // FINALIZAR
        // ==========================================
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ PRUEBAS COMPLETADAS");
        System.out.println("=".repeat(60));
    }
}