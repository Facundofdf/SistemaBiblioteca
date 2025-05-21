package pkg05_ejerciciotipoparcial;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Facundo Fernandez
 */
public class Biblioteca {

    private List<Publicacion> publicaciones;

    public Biblioteca() {
        publicaciones = new ArrayList<>();
    }

    public void agregarPublicacion(Publicacion p) {
        if (publicaciones.contains(p)) {
            System.out.println("Ya existe una publicacion con ese titulo.");
        } else {
            publicaciones.add(p);
            System.out.println("Publicacion agregada correctamente.");
        }
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public void mostrarPublicaciones() {
        if (publicaciones.isEmpty()) {
            System.out.println("No hay publicaciones registradas.");
        } else {
            System.out.println("Listado de publicaciones: ");
            for (Publicacion p : publicaciones) {
                System.out.println(p);
            }
        }
    }

    public void leerPublicaciones() {
        if (publicaciones.isEmpty()) {
            System.out.println("No hay publicaciones para leer.");
        } else {
            for (Publicacion p : publicaciones) {
                if (p instanceof Leer) {
                    ((Leer) p).leer();
                } else {
                    System.out.println("La publicacion " + p.getTitulo() + " no es legible.");
                }

            }
        }
    }
}
