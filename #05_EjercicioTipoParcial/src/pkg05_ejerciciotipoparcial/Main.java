package pkg05_ejerciciotipoparcial;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Facundo Fernandez
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        ComparadorAlfabetico comparadorTitulo = new ComparadorAlfabetico();
        ComparadorLibroAutor comparadorLibAutor = new ComparadorLibroAutor();
        ComparadorPorArea comparadorArea = new ComparadorPorArea();
        List<Libro> listaLibros = new ArrayList<>();
        List<Ilustracion> listaIlustracion = new ArrayList<>();
        List<Revista> listaRevista = new ArrayList<>();
        int opcion;

        do {
            System.out.println("==== Menu de opciones ====");
            System.out.println("1. Agregar publicaciones.");
            System.out.println("2. Mostrar publicaciones.");
            System.out.println("3. Publicaciones legibles.");
            System.out.println("4. Ordenar las publicaciones por año de publicacion.");
            System.out.println("5. Ordenar alfabéticamente las publicaciones por título.");
            System.out.println("6. Ordenar los libros por nombre del autor.");
            System.out.println("7. Ordenar las ilustraciones por su área.");
            System.out.println("8. Mostrar todas las publicaciones agrupadas por tipo.");
            System.out.println("9. Mostrar el libro más antiguo y el más reciente de la colección.");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("1. Libro\n2. Revista\n3. Ilustracion");
                    System.out.println("Opcion: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Titulo: ");
                    String titulo = sc.nextLine();
                    System.out.println("Año publicacion: ");
                    int anioPublicacion = sc.nextInt();
                    sc.nextLine();
                    switch (tipo) {
                        case 1:
                            System.out.println("Autor: ");
                            String autor = sc.nextLine();

                            String genero;
                            boolean generoValido = false;
                            String[] generosValidos = {"Ficcion", "NoFiccion", "Ciencia", "Historia"};
                            do {
                                System.out.println("Genero (Ficcion | NoFiccion | Ciencia | Historia)");
                                genero = sc.nextLine();
                                for (String g : generosValidos) {
                                    if (g.equalsIgnoreCase(genero)) {
                                        generoValido = true;
                                        break;
                                    }
                                }
                                if (!generoValido) {
                                    System.out.println("Genero invalido.");
                                }
                            } while (!generoValido);
                            Libro libro = new Libro(autor, genero, titulo, anioPublicacion);
                            biblioteca.agregarPublicacion(libro);
                            break;
                        case 2:
                            System.out.println("Numero edicion: ");
                            int numeroEdicion = sc.nextInt();
                            Revista revista = new Revista(numeroEdicion, titulo, anioPublicacion);
                            biblioteca.agregarPublicacion(revista);
                            break;
                        case 3:
                            System.out.println("Ilustrador: ");
                            String nombreIlustrador = sc.nextLine();
                            System.out.println("Ancho: ");
                            int ancho = sc.nextInt();
                            System.out.println("Alto: ");
                            int alto = sc.nextInt();
                            Ilustracion ilustracion = new Ilustracion(nombreIlustrador, ancho, alto, titulo, anioPublicacion);
                            biblioteca.agregarPublicacion(ilustracion);
                            break;
                        default:
                            System.out.println("Opcion no valida");
                    }
                    break;
                case 2:
                    biblioteca.mostrarPublicaciones();
                    break;
                case 3:
                    biblioteca.leerPublicaciones();
                    break;
                case 4:
                    Collections.sort(biblioteca.getPublicaciones());
                    Collections.reverse(biblioteca.getPublicaciones());
                    System.out.println("Publicaciones ordenadas por año publicacion: ");
                    for (Publicacion p : biblioteca.getPublicaciones()) {
                        System.out.println(p);
                    }
                    break;
                case 5:
                    Collections.sort(biblioteca.getPublicaciones(), comparadorTitulo);
                    System.out.println("Publicaciones ordenadas por titulo alfabeticamente: ");
                    for (Publicacion p : biblioteca.getPublicaciones()) {
                        System.out.println(p);
                    }
                    break;
                case 6:
                    listaLibros.clear();
                    for (Publicacion p : biblioteca.getPublicaciones()) {
                        if (p instanceof Libro) {
                            listaLibros.add((Libro) p);
                        }
                    }
                    Collections.sort(listaLibros, comparadorLibAutor);
                    System.out.println("Libros ordenados por nombre de autor: ");
                    for (Libro libro : listaLibros) {
                        System.out.println(libro);
                    }
                    break;
                case 7:
                    listaIlustracion.clear();
                    for (Publicacion p : biblioteca.getPublicaciones()) {
                        if (p instanceof Ilustracion) {
                            listaIlustracion.add((Ilustracion) p);
                        }
                    }
                    Collections.sort(listaIlustracion, comparadorArea);
                    for (Ilustracion ilustracion : listaIlustracion) {
                        System.out.println(ilustracion);
                    }
                    break;
                case 8:
                    listaLibros.clear();
                    listaRevista.clear();
                    listaIlustracion.clear();

                    for (Publicacion p : biblioteca.getPublicaciones()) {
                        if (p instanceof Libro) {
                            listaLibros.add((Libro) p);
                        } else if (p instanceof Revista) {
                            listaRevista.add((Revista) p);
                        } else if (p instanceof Ilustracion) {
                            listaIlustracion.add((Ilustracion) p);
                        }
                    }

                    System.out.println("Libros: ");
                    for (int i = 0; i < listaLibros.size(); i++) {
                        System.out.println((i + 1) + ". " + listaLibros.get(i));
                    }
                    System.out.println("Revistas: ");
                    for (int i = 0; i < listaRevista.size(); i++) {
                        System.out.println((i + 1) + ". " + listaRevista.get(i));
                    }
                    System.out.println("Ilustraciones: ");
                    for (int i = 0; i < listaIlustracion.size(); i++) {
                        System.out.println((i + 1) + ". " + listaIlustracion.get(i));
                    }
                    break;
                case 9:
                    listaLibros.clear();
                    for (Publicacion p : biblioteca.getPublicaciones()) {
                        if (p instanceof Libro) {
                            listaLibros.add((Libro) p);
                        }
                    }
                    if (listaLibros.isEmpty()) {
                        System.out.println("No hay libros en la biblioteca.");
                    } else {
                        Libro libroMasAntiguo = Collections.min(listaLibros);
                        Libro libroMasReciente = Collections.max(listaLibros);
                        System.out.println("Libro mas antiguo: ");
                        System.out.println(libroMasAntiguo);
                        System.out.println("Libro mas reciente: ");
                        System.out.println(libroMasReciente);
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        } while (opcion != 0);
        sc.close();
    }
}
