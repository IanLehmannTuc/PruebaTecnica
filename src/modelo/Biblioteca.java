package modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Biblioteca {
	//se crea una sola instancia biblioteca con singleton
	private static Biblioteca bibliotecaSingleton;
	
	public static Biblioteca obtenerInstancia(ArrayList<Libro> libros) {
		
        if (bibliotecaSingleton == null) {
        	bibliotecaSingleton = new Biblioteca(libros);
        }
        
        return bibliotecaSingleton;
    }
	
	private ArrayList<Libro> libroDisponibles = new ArrayList<>();;
	private ArrayList<Libro> libroPrestados = new ArrayList<>();;

	private Biblioteca(ArrayList<Libro> libros) {
		for(Libro libro : libros) {
			if(libro.getEstado() == "Disponible") {
				this.libroDisponibles.add(libro);
			}
			else {
				this.libroPrestados.add(libro);
			}
		}
	}
	
	public void agregarLibro(Libro libro) {
		if(libro.getEstado() == "Disponible") {
			this.libroDisponibles.add(libro);
		}
		else {
			this.libroPrestados.add(libro);
		}
	}
	
	//compara los valores de la instancia recibida y cada instancia de la array del  los libros disponibles
	public Libro prestarLibro(Libro libro) {
		for(Libro libroBilioteca : getLibroDisponible()) {
			if(libro.getAñoPublicacion() == libroBilioteca.getAñoPublicacion() &&
					libro.getNumPaginas() == libroBilioteca.getNumPaginas() &&
					Objects.equals(libro.getAutor(), libroBilioteca.getAutor()) &&
					Objects.equals(libro.getGenero(), libroBilioteca.getGenero()) &&
					Objects.equals(libro.getTitulo(), libroBilioteca.getTitulo()) &&
					libroBilioteca.getEstado() == "Disponible"
					) {
				this.libroDisponibles.remove(libroBilioteca);
				libroBilioteca.prestarLibro();
				this.libroPrestados.add(libroBilioteca);
				return libroBilioteca;
				}
			}
		return null;
	}
	
	//compara los valores de la instancia recibida y cada instancia de la array del  los libros prestados
	public Libro devolverLibro(Libro libro) {
		for(Libro libroBilioteca : getLibroPrestados()) {
			if(libro.getAñoPublicacion() == libroBilioteca.getAñoPublicacion() &&
					libro.getNumPaginas() == libroBilioteca.getNumPaginas() &&
					Objects.equals(libro.getAutor(), libroBilioteca.getAutor()) &&
					Objects.equals(libro.getGenero(), libroBilioteca.getGenero()) &&
					Objects.equals(libro.getTitulo(), libroBilioteca.getTitulo()) &&
					libroBilioteca.getEstado() == "Prestado"
					) {
				this.libroPrestados.remove(libroBilioteca);
				libroBilioteca.devolverLibro();
				this.libroDisponibles.add(libroBilioteca);
				return libroBilioteca;
				}
			}
		return null;
	}
	
	public ArrayList<Libro> getLibroDisponible(){
		return this.libroDisponibles;
	}

	public ArrayList<Libro> getLibroPrestados(){
		return this.libroPrestados;
	}
}
