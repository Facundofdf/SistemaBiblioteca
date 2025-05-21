package pkg05_ejerciciotipoparcial;

import java.util.Comparator;

/**
 *
 * @author Facundo Fernandez
 */
public class ComparadorPorArea implements Comparator<Ilustracion>{

    @Override
    public int compare(Ilustracion i1, Ilustracion i2) {
        return Integer.compare(i1.calcularArea(), i2.calcularArea());
    }
    
}
