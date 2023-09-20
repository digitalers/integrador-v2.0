
package integrador2.mg.models;

public class Domicilio {
   /* calle, altura, barrio, ciudad, provincia, cp*/
    private String calle;
    private int altura;
    private String barrio;
    private String ciudad;
    private String provincia;
    private String codigoPostal;

    public Domicilio(String calle, int altura, String barrio, String ciudad, String provincia, String codigoPostal) {
        this.calle = calle;
        this.altura = altura;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "calle=" + calle +
                ", altura=" + altura + ", barrio="
                + barrio + ", ciudad=" + ciudad + 
                ", provincia=" + provincia + 
                ", codigoPostal=" + codigoPostal + '}';
    }
    
    
    
}
