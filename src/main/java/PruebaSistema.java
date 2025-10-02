import java.util.List;
import java.util.ArrayList;

public class PruebaSistema {

    public static void main(String[] args) {
        System.out.println("====== INICIO DE PRUEBA DEL SISTEMA UFRO ======");

        // Paso 1: Inicialización de datos
        List<Alumno> alumnosIniciales = crearAlumnos();
        Curso cursoPOO = crearCurso("Programación Orientada a Objetos", "INF-340");

        // Paso 2: Ejecución de las pruebas
        probarEncapsulamiento(alumnosIniciales.get(2));
        inscribirAlumnos(cursoPOO, alumnosIniciales);
        probarPertenencia(cursoPOO, 1003, 9999);
        mostrarCursoCompleto(cursoPOO, "4. Visualizar el inicio del Curso");
        gestionMatricula(cursoPOO, 1004, 9999);
        mostrarCursoCompleto(cursoPOO, "6. Visualizar despues de la Eliminación");

        System.out.println("====== FIN DE PRUEBA DEL SISTEMA UFRO =====");
    }

    private static List<Alumno> crearAlumnos() {
        System.out.println("\n--- 1. Creacion de Alumnos ---");
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("11.111.111-1", "Ana", "Pérez", "Ingeniería Civil Informática", 1001));
        alumnos.add(new Alumno("12.222.222-2", "Benjamín", "Flores", "Ingeniería Civil Informática", 1002));
        alumnos.add(new Alumno("13.333.333-3", "Carla", "Gómez", "Kinesiología", 1003));
        alumnos.add(new Alumno("14.444.444-4", "David", "Muñoz", "Derecho", 1004));
        alumnos.add(new Alumno("15.555.555-5", "Elena", "Rojas", "Ingeniería Civil Informática", 1005));

        return alumnos;
    }

    private static Curso crearCurso(String nombre, String codigo) {
        System.out.println("\n--- 2. Creacion del Curso ---");
        return new Curso(nombre, codigo);
    }

    private static void probarEncapsulamiento(Alumno alumno) {
        System.out.println("\n--- 3. Prueba de Encapsulamiento ---");
        System.out.println("Alumno antes: " + alumno.toString());

        alumno.setCarrera("Medicina");
        System.out.println("Alumno después (Cambio de Carrera): " + alumno.toString());
    }

    private static void inscribirAlumnos(Curso curso, List<Alumno> alumnos) {
        System.out.println("\n--- 4. Inscripcion de Alumnos y Prueba de Duplicados ---");
        for (Alumno alumno : alumnos) {
            curso.agregarAlumno(alumno);
        }
        curso.agregarAlumno(alumnos.get(0));
    }

    private static void probarPertenencia(Curso curso, int matriculaExistente, int matriculaInexistente) {
        System.out.println("\n--- 5. Verificacion de pertenencia ---");
        System.out.println("¿Pertenece el Alumno " + matriculaExistente + " al curso? " + curso.perteneceAlumno(matriculaExistente));
        System.out.println("¿Pertenece el Alumno " + matriculaInexistente + " al curso? " + curso.perteneceAlumno(matriculaInexistente));
    }

    private static void gestionMatricula(Curso curso, int matriculaAEliminar, int matriculaFallida) {
        System.out.println("\n--- 6. Eliminar Alumnos ---");

        boolean eliminado = curso.eliminarAlumno(matriculaAEliminar);
        System.out.println("Resultado de eliminar alumno " + matriculaAEliminar + ": " + (eliminado ? "Éxito." : "Fallo."));

        // Intento de eliminar un alumno que no existe
        boolean eliminadoFallido = curso.eliminarAlumno(matriculaFallida);
        System.out.println("Resultado de eliminar alumno " + matriculaFallida + ": " + (eliminadoFallido ? "Éxito." : "Fallo."));
    }

    private static void mostrarCursoCompleto(Curso curso, String titulo) {
        System.out.println("\n--- " + titulo + " ---");
        System.out.println(curso.toString());
    }
}