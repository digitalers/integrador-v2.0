
package integrador2.mg.models;


public class Titular {
    /* nombre, dni, dirección, teléfono, email*/
    private int idTitular;
    private String dni;
    private String apellido;
    private String nombre;
    private Domicilio domicilio;
    private int telefono;
    private String email;

    public Titular( String dni, String apellido, String nombre, Domicilio domicilio, int telefono, String email) {
        this.dni = dni;
        this.apellido = apellido;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.email = email;
    }

    public int getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(int idTitular) {
        this.idTitular = idTitular;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Titular{" + "idTitular=" + 
                idTitular + ", dni=" + dni +
                ", apellido=" + apellido + ", nombre=" +
                nombre + ", domicilio= barrio " + this.domicilio.getBarrio() + 
                ", telefono=" + telefono + 
                ", email=" + email + '}';
    }

    
public void Mostrar() {
        System.out.println("***** El cliente es " + nombre + ", apellido "
                + apellido +" , DNI N° ° "+ dni+  " , idCliente " + idTitular + " , direccion: Barrio"
                + this.domicilio.getBarrio() + ", teléfono" + telefono + " , email: " + email +  ".");

    }
   
    
}
