package pkg05_ejerciciotipoparcial;

/**
 *
 * @author Facundo Fernandez
 */
public class Ilustracion extends Publicacion {

    private String nombreIlustrador;
    private int ancho;
    private int alto;

    public Ilustracion(String nombreIlustrador, int ancho, int alto, String titulo, int anioPublicacion) {
        super(titulo, anioPublicacion);
        this.nombreIlustrador = nombreIlustrador;
        this.ancho = ancho;
        this.alto = alto;
    }
    
    public int calcularArea(){
        int area = ancho * alto;
        return area;
    }

    @Override
    public String toString() {
        return "Ilustracion: " + getTitulo()
                + ", Año publicacion: " + getAnioPublicacion()
                + ", Nombre ilustrador: " + nombreIlustrador
                + ", Ancho: " + ancho
                + ", Alto: " + alto;
    }
}
