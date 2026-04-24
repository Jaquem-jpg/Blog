package control;


//Imports necesarios
import logica.Blog;
import java.util.HashMap;
import java.util.Map;


/**
 * Clase Controladora del sistema de Blogs.
 * Administra múltiples blogs y expone todas las funcionalidades al usuario.
 */
public class Controladora {
	private static int contadorCodigoBlog = 1;
	private Map<Integer, Blog > blogs; //Código del blog 
	
	/**
     * Constructor 
     */
	public Controladora() {
		this.blogs = new HashMap<>();
	}

	
	/**
     * 1. Función para crear un nuevo blog
     * @return el código asignado al blog recién creado
     */
	public int CrearBlog(String nombre, String descripcion) {
		Blog nuevoBlog = new Blog(nombre, descripcion);
		int codigo = contadorCodigoBlog ++;
		blogs.put(codigo, nuevoBlog);
		System.out.println("Blog creado exitosamente con código: " + codigo);
		return codigo;
	}
	
	/**
     * Método que devuelve cuántos blogs hay actualmente
     */
	public int getCantidadBlogs() {
		return blogs.size();
	}
	
	
}
