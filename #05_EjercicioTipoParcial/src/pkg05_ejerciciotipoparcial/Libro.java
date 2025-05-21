package pkg05_ejerciciotipoparcial;

/**
 *
 * @author Facundo Fernandez
 */
public class Libro extends Publicacion implements Leer {

    private String autor;

    public String getAutor() {
        return autor;
    }
    private String genero; //Ficcion, noFiccion, Ciencia, Historia.

    public Libro(String autor, String genero, String titulo, int anioPublicacion) {
        super(titulo, anioPublicacion);
        this.autor = autor;
        this.genero = genero;
    }

    @Override
    public void leer() {
        System.out.println("Leyendo " + getTitulo());
    }

    @Override
    public String toString() {
        return "Libro: " + getTitulo()
                + ", Año publicacion: " + getAnioPublicacion()
                + ", Autor: " + autor
                + ", Genero: " + genero;
    }
}
