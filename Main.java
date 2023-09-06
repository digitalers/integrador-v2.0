import clases.Asignatura;
import clases.Carrera;
import clases.Estudiante;
import clases.Matricula;
import dbConnection.AsignaturaDB;
import dbConnection.CarreraDB;
import dbConnection.EstudianteDB;
import dbConnection.MatriculaDB;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        EstudianteDB estudianteDB = new EstudianteDB();
        CarreraDB carreraDB = new CarreraDB();
        AsignaturaDB asignaturaDB = new AsignaturaDB();
        MatriculaDB matriculaDB = new MatriculaDB();
        ArrayList<Carrera> carrerasTotales = carreraDB.buscarCarreras();
        ArrayList<Estudiante> estudiantes = estudianteDB.buscarEstudiantes();

        int opcion;
        Scanner scanner = new Scanner(System.in);
        int ultimoEstudiante = estudiantes.get(estudiantes.size()-1).getIdEstudiante();
        do {
            System.out.print("1- Dar de alta un estudiante \n" +
                    "2- Matricular un estudiante \n" +
                    "3- Mostrar los datos de los estudiantes\n" +
                    "4- Modificar los datos de un estudiante \n" +
                    "5- Eliminar un estudiante \n" +
                    "6- Salir \n" +
                    "Ingrese su opcion: "
            );
            opcion = Integer.parseInt(scanner.next());

            if (opcion == 1) {
                ultimoEstudiante += 1;

                System.out.print("Ingrese el dni del es: ");
                int dni = Integer.parseInt(scanner.next());
                System.out.print("Ingrese el nombre del estudiante: ");
                String nombre = scanner.next();
                System.out.print("Ingrese el apellido del estudiante: ");
                String apellido = scanner.next();
                System.out.print("Ingrese la direccion del estudiante: ");
                String direccion = scanner.next();
                System.out.print("Ingrese el telefono del estudiante: ");
                String telefono = scanner.next();
                Carrera carreraestudiante = null;

                int cont = 0;
                for (Carrera carrera : carrerasTotales) {
                    cont += 1;
                    System.out.println(cont + "-" + carrera.getNombre());
                }
                System.out.print("Ingrese el numero de la carrera que cursa: ");
                int selCarrera = Integer.parseInt(scanner.next());

                if (selCarrera != 0) {
                    carreraestudiante = carrerasTotales.get(selCarrera - 1);
                    System.out.println();
                }
                Matricula matricula = new Matricula(0,"no matriculado");
                Estudiante estudiante = new Estudiante(nombre,apellido,dni,direccion,telefono,ultimoEstudiante,carreraestudiante,carreraestudiante.getSede(),new Date(),0,matricula);
                estudianteDB.registrarEstudiante(estudiante);
                estudiantes.add(estudiante);


                System.out.println(estudiantes);
            } else if (opcion == 2){

                System.out.println(estudiantes);
                System.out.println("PARA MATRICULAR EL ESTUDIANTE DEBE ESTAR DADO DE ALTA CON LA OPCION 1 y SIN MATRICULA ACTIVA");
                System.out.print("Ingrese el id del estudiante a matricular: ");
                int id =Integer.parseInt(scanner.next());
                boolean existe = false;
                for (Estudiante estudiante:estudiantes){
                    if(estudiante.getIdEstudiante() == id && estudiante.getMatricula().getIdMatricula() == 0) {
                        int selMateria = -1;
                        ArrayList<Asignatura> asignaturasCarrera = asignaturaDB.buscarAsignaturasCarrera(estudiante.getCarrera());

                        ArrayList<Asignatura> materiasestudiante = new ArrayList<>();
                        existe = true;
                        while (selMateria != 0) {
                            asignaturaDB.mostrarAsignaturas(asignaturasCarrera);
                            System.out.println("0-Salir");
                            System.out.print("Ingrese el numero de la materia que desea cursar: ");
                            selMateria = Integer.parseInt(scanner.next());
                                if (selMateria != 0) {
                                    for(Asignatura asignatura : asignaturasCarrera){
                                        if(asignatura.getIdAsignatura() == selMateria && !(materiasestudiante.contains(asignatura))){
                                            materiasestudiante.add(asignatura);
                                        }
                                    }

                            }
                            }
                        Matricula matricula = new Matricula(id, "Activa", estudiante.getCarrera().getSede(), materiasestudiante, new Date());
                        matriculaDB.matricularEstudiante(matricula, id);
                        estudiante.setMatricula(matricula);
                        System.out.println("El estudiante se matriculó correctamente");
                        System.out.println(matricula);
                        break;
                        }

                    }
                if(!existe){
                    System.out.println("El estudiante no existe o ya está matriculado");
                }


            } else if (opcion == 3) {
                System.out.println("SE MUESTRAN LO DATOS PRINCIPALES DE LOS ESTUDIANTES");
                System.out.println("=".repeat(150));
                System.out.println(estudiantes);
                System.out.println("=".repeat(150));

            } else if (opcion == 4) {
                //MODIFICACION DE LA DIRECCION DEL ESTUDIANTE A MODO DE EJEMPLO, SE PODRÍA EXTENDER PARA MODIFICAR MAS CAMPOS
                System.out.println(estudiantes);
                System.out.print("Ingrese el id del estudiante a modificar: ");
                int id =Integer.parseInt(scanner.next());
                for (Estudiante estudiante:estudiantes) {
                    if (estudiante.getIdEstudiante() == (id)){
                        System.out.print("Ingrese la nueva direccion: ");
                        String direccion = scanner.next();
                        estudianteDB.modificarEstudiante(id,direccion);
                        System.out.println("Direccion modificada correctamente");
                    }
                }

            } else if (opcion == 5) {

                System.out.println(estudiantes);
                System.out.print("Ingrese el id del estudiante que desea eliminar: ");
                int id =Integer.parseInt(scanner.next());
                for (Estudiante estudiante:estudiantes) {
                    if (estudiante.getIdEstudiante() == (id)){
                        estudianteDB.eliminarEstudiante(id);
                        System.out.println("estudiante eliminado correctamente");
                    }
                }
                System.out.println(estudiantes);
            }


        }while (opcion != 6);
    }
}
