package pkg05_ejerciciotipoparcial;

/**
 *
 * @author Facundo Fernandez
 */
public class Revista extends Publicacion implements Leer {

    private int numeroEdicion;

    public Revista(int numeroEdicion, String titulo, int anioPublicacion) {
        super(titulo, anioPublicacion);
        this.numeroEdicion = numeroEdicion;
    }

    @Override
    public void leer() {
        System.out.println("Leyendo " + getTitulo());
    }

    @Override
    public String toString() {
        return "Revista: " + getTitulo()
                + ", Año publicacion: " + getAnioPublicacion()
                + ", Numero edicion: " + numeroEdicion;
    }
}
