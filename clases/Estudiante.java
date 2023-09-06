package clases;

import java.util.Date;

public class Estudiante extends Persona {
    private int idEstudiante;
    private Carrera carrera;
    private String universidad;
    private Date fechaIngreso;
    private float promedio;
    private Matricula matricula;

    private boolean activo;

    public Estudiante() {

    }


    public Estudiante(String nombre, String apellido, int dni, String direccion, String telefono, int idEstudiante, Carrera carrera, String universidad, Date fechaIngreso, float promedio, Matricula matricula) {
        super(nombre, apellido, dni, direccion, telefono);
        this.idEstudiante = idEstudiante;
        this.carrera = carrera;
        this.universidad = universidad;
        this.fechaIngreso = fechaIngreso;
        this.promedio = promedio;
        this.matricula = matricula;
        this.activo = true;
    }

    public Estudiante(int id, String nombre) {
        super(nombre);
        this.idEstudiante = id;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }


    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        if (isActivo()){
            return "idEstudiante: " + idEstudiante +
                    ", Nombre: " + getNombre() +
                    ", Apellido: " + getApellido() +
                    ",Matricula: " + matricula.getEstado() +
                    ", DNI: " + getDni() +
                    ", Direccion: " + getDireccion() +
                    ", carrera: " + carrera.getNombre() +
                    ", universidad: '" + universidad + '\'' +
                    ", promedio: " + promedio +
                     '\n' +
                    "-".repeat(150)+
                    '\n';
        }
        else {
            return "";
        }

    }




}

