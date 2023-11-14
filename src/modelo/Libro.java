package modelo;

public class Libro {

	private String titulo;
	private String autor;
	private int añoPublicacion;
	private String genero;
	private int numPaginas;
	private EstadoLibro estado;
	
	public Libro(String titulo, String autor, int añoPublicacion, String genero, int numPaginas) {
		this.titulo = titulo;
		this.autor = autor;
		this.añoPublicacion = añoPublicacion;
		this.genero = genero;
		this.numPaginas = numPaginas;
		this.estado = EstadoLibro.Disponible;
	}
	
	public Libro(String titulo, String autor, int añoPublicacion, String genero, int numPaginas, EstadoLibro estado) {
		this.titulo = titulo;
		this.autor = autor;
		this.añoPublicacion = añoPublicacion;
		this.genero = genero;
		this.numPaginas = numPaginas;
		this.estado = estado;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getAñoPublicacion() {
		return añoPublicacion;
	}
	
	public void setAñoPublicacion(int añoPublicacion) {
		this.añoPublicacion = añoPublicacion;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	
	public String getEstado() {
		return String.valueOf(estado);
	}
	
	public void prestarLibro() {
		this.estado = EstadoLibro.Prestado;
	}
	
	public void devolverLibro() {
		this.estado = EstadoLibro.Disponible;
	}
	
	
	
}
