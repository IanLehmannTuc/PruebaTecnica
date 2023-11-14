package modelo;

import java.util.ArrayList;

public class Persona {

	private String nombre;
	private int edad;
	private ArrayList<Libro> libroPrestados = new ArrayList<>();;
	
	public Persona(String nombre, int edad, ArrayList<Libro> librosPrestados) {
		this.nombre = nombre;
		this.edad = edad;
		this.libroPrestados = librosPrestados;
	}
	
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public ArrayList<Libro> getLibroPrestados() {
	    return libroPrestados;
	}

	public void tomarLibros(Biblioteca biblioteca, Libro libro) {
		if(biblioteca.prestarLibro(libro) != null) {
			this.libroPrestados.add(libro);
			System.out.println("Pediste Prestado el libro " + libro.getTitulo());
		}
		else {
			System.out.println("El libro " + libro.getTitulo() + " no esta disponible");
		}
	}
	
	public void devolverLibro(Biblioteca biblioteca, Libro libro) {
		if(biblioteca.devolverLibro(libro) != null) {
			this.libroPrestados.remove(libro);
			System.out.println("Devolviste el libro " + libro.getTitulo());
		}
		else {
			System.out.println("El libro " + libro.getTitulo() + " no esta prestado");
		}
	}
	
}
