package inicio;

import java.util.ArrayList;

import modelo.Biblioteca;
import modelo.EstadoLibro;
import modelo.Libro;
import modelo.Persona;

public class Main {

	public static void main(String[] args) {
		
		Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico", 432);
        Libro libro2 = new Libro("El señor de los anillos", "J.R.R. Tolkien", 1954, "Fantasía", 1200, EstadoLibro.Prestado);
        Libro libro3 = new Libro("1984", "George Orwell", 1949, "Ciencia ficción", 328);
        Libro libro4 = new Libro("Orgullo y prejuicio", "Jane Austen", 1813, "Clásico", 416, EstadoLibro.Prestado);
        Libro libro5 = new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", 1997, "Fantasía", 320);
        Libro libro6 = new Libro("Crónica de una muerte anunciada", "Gabriel García Márquez", 1981, "Realismo mágico", 192);

		 ArrayList<Libro> libros = new ArrayList<>();
		 libros.add(libro1);
		 libros.add(libro2);
		 libros.add(libro3);
		 libros.add(libro4);
		 libros.add(libro5);
		 libros.add(libro6);
        
	     ArrayList<Libro> librosPrestados = new ArrayList<Libro>();
	     librosPrestados.add(libro2);
	     
        Persona persona1 = new Persona("Ian Lehmann", 26, librosPrestados);
        Biblioteca biblioteca = Biblioteca.obtenerInstancia(libros);
		
        persona1.tomarLibros(biblioteca, libro5);
        
        System.out.println();
        
        persona1.tomarLibros(biblioteca, libro4);
		
        System.out.println();
        
        System.out.println("La persona: " + persona1.getNombre() + " pidio y tiene los siguientes libros");
		for(Libro libro : persona1.getLibroPrestados()) {
			System.out.println(libro.getTitulo());
		}
		
		System.out.println();
		
		System.out.println("La biblioteca tiene los giguientes libros disponibles: ");
		for(Libro libro : biblioteca.getLibroDisponible()) {
			System.out.println(libro.getTitulo() + " con estado " + libro.getEstado());
		}
		
		System.out.println();
		
		System.out.println("La biblioteca tiene los giguientes libros prestados: ");
		for(Libro libro : biblioteca.getLibroPrestados()) {
			System.out.println(libro.getTitulo() + " con estado " + libro.getEstado());
		}
		
		System.out.println();
		
		persona1.devolverLibro(biblioteca, libro2);
		
		System.out.println();
		
		System.out.println("La biblioteca tiene los giguientes libros disponibles: ");
		for(Libro libro : biblioteca.getLibroDisponible()) {
			System.out.println(libro.getTitulo() + " con estado " + libro.getEstado());
		}
		
		System.out.println();
		
		System.out.println("La biblioteca tiene los giguientes libros prestados: ");
		for(Libro libro : biblioteca.getLibroPrestados()) {
			System.out.println(libro.getTitulo() + " con estado " + libro.getEstado());
		}
	}

}
