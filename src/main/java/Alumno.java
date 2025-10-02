public class Alumno {

    private String nombre;
    private String apellido;
    private final String rut;
    private String carrera;
    private int matricula;

    public Alumno(String rut, String nombre, String apellido, String carrera, int matricula) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
        this.matricula = matricula;
    }

    public Alumno() {
        this.rut = "";
        this.nombre = "";
        this.apellido = "";
        this.carrera = "No Asignada";
        this.matricula = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRut() {
        return rut;
    }

    public String getCarrera() {
        return carrera;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Alumno {" +
                "RUT='" + rut + '\'' +
                ", Nombre Completo='" + nombre + " " + apellido + '\'' +
                ", Matrícula=" + matricula +
                ", Carrera='" + carrera + '\'' +
                '}';
    }
}