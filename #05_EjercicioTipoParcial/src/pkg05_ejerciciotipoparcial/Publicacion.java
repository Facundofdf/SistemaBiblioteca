package pkg05_ejerciciotipoparcial;

import java.util.Objects;

/**
 *
 * @author Facundo Fernandez
 */
public abstract class Publicacion implements Comparable<Publicacion>{

    private String titulo;
    private int anioPublicacion;

    public Publicacion(String titulo, int anioPublicacion) {
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }
    
    @Override
    public int compareTo(Publicacion x){
        return Integer.compare(this.anioPublicacion, x.getAnioPublicacion());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Publicacion)) {
            return false;
        }
        Publicacion that = (Publicacion) o;
        return anioPublicacion == that.anioPublicacion && titulo.equalsIgnoreCase(that.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo.toLowerCase(), anioPublicacion);
    }

    //@Override
    //public abstract String toString();
}
