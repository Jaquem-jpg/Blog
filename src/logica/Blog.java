package logica;

//Imports necesarios
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Blog {
	private static int contarCodigo = 1;
	private int codigo;
	private String nombre;
	private String descripcion;
	private LocalDateTime FechaCreacion;
	private List<Publicacion> publicaciones;
	
	//Construcor 
	public Blog(String nombre, String descripcion){
			this.codigo = contarCodigo++;
			this.nombre = nombre;
			this.descripcion = descripcion;
			this.FechaCreacion = LocalDateTime.now();
			this.publicaciones = new ArrayList<>();
	}	
	
	
	//Getters y Setters
	public int getCodigo(){
		return codigo;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public LocalDateTime getFechaCreacion() {
		return FechaCreacion;
	}
	
	
	//Métodos
	
	public void crearPublicacion(String titulo, String texto, String creador) {
		Publicacion nuevaPublicacion = new Publicacion(titulo, texto, creador);
		publicaciones.add(nuevaPublicacion);
	}
	
	
	public String getResumenPublicacion(int codigo) {
		for (Publicacion pub : publicaciones) {
			if(pub.getCodigo() == codigo) {
				return pub.mostrarConComentarios();
			}
		}
		return 	"Publicación no encontrada.";
	}
	
	 public Map<Integer, String> getTitulosPublicacionesNumerados() {
	        Map<Integer, String> titulos = new HashMap<>();
	        for (Publicacion pub : publicaciones) {
	            titulos.put(pub.getCodigo(), pub.getTitulo());
	        }
	        return titulos;
	    }
	 
	 
	   public void agregarComentarioAPublicacion(int codigoPub, String email, String ip, String texto) {
	        for (Publicacion pub : publicaciones) {
	            if (pub.getCodigo() == codigoPub) {
	                pub.agregarComentario(email, ip, texto);
	                return;
	            }
	        }
	        System.out.println("Publicación no encontrada.");
	    }
	   
	   
	   
	   public boolean borrarComentarioDePublicacion(int codigoPub, int posicion) {
	        for (Publicacion pub : publicaciones) {
	            if (pub.getCodigo() == codigoPub) {
	                return pub.eliminarComentario(posicion);
	            }
	        }
	        System.out.println("Publicación no encontrada.");
	        return false;
	    }
	
	
}
