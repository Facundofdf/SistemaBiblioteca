package pkg05_ejerciciotipoparcial;

import java.util.Comparator;

/**
 *
 * @author Facundo Fernandez
 */
public class ComparadorLibroAutor implements Comparator<Libro>{

    @Override
    public int compare(Libro l1, Libro l2) {
        return l1.getAutor().compareToIgnoreCase(l2.getAutor());
    }
    
}
