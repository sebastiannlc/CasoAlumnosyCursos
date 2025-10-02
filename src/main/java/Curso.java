import java.util.ArrayList;
import java.util.List;

public class Curso {

    private final String nombre;
    private final String codigo;
    private final List<Alumno> alumnos;

    public Curso(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.alumnos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public boolean agregarAlumno(Alumno alumno) {
        if (alumno == null) {
            System.err.println("Error: No se puede agregar un alumno nulo.");
            return false;
        }
        if (perteneceAlumno(alumno.getMatricula())) {
            System.out.println("Advertencia: El alumno con matrícula " + alumno.getMatricula() + " ya está en el curso.");
            return false;
        }
        return alumnos.add(alumno);
    }

    public boolean eliminarAlumno(int matricula) {
        return alumnos.removeIf(a -> a.getMatricula() == matricula);
    }

    public boolean perteneceAlumno(int matricula) {
        for (Alumno alumno : alumnos) {
            if (alumno.getMatricula() == matricula) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("== Detalle del Curso ==\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Código: ").append(codigo).append("\n");
        sb.append("Total Alumnos: ").append(alumnos.size()).append("\n");
        sb.append("--------------------------\n");

        if (alumnos.isEmpty()) {
            sb.append("No hay alumnos inscritos en este curso.\n");
        } else {
            for (Alumno alumno : alumnos) {
                sb.append(" -> ").append(alumno.toString()).append("\n");
            }
        }
        sb.append("=========================\n");
        return sb.toString();
    }
}