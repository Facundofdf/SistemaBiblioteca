package pkg05_ejerciciotipoparcial;

import java.util.Comparator;

/**
 *
 * @author Facundo Fernandez
 */
public class ComparadorAlfabetico implements Comparator<Publicacion>{

    @Override
    public int compare(Publicacion p1, Publicacion p2) {
        return p1.getTitulo().compareToIgnoreCase(p2.getTitulo());
    }
    
}
