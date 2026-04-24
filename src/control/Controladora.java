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
     *  Método para crear un nuevo blog
     * @return el código asignado al blog recién creado
     */
	public int CrearBlog(String nombre, String descripcion) {
		Blog nuevoBlog = new Blog(nombre, descripcion);
		int codigo = contadorCodigoBlog ++;
		blogs.put(codigo, nuevoBlog);
		System.out.println("Blog creado exitosamente con código: " + codigo);
		return codigo;
	}
	
	
	// Borrar un Blog 
	public boolean borrarBlog(int codigoBlog) {
		if (blogs.remove(codigoBlog) != null) {
			System.out.println("Blog " + codigoBlog + "eliminado");
			return true;
		} else {
			System.out.println("No se encontró el blog con código: " + codigoBlog);
			return false;
			
		}
	}
	
	
	
	// Obtener lista de blogs 
	public Map<Integer, String> obtenerBlogs(){
		Map<Integer, String> lista = new HashMap<>();
        for (Map.Entry<Integer, Blog> entry : blogs.entrySet()) {
            lista.put(entry.getKey(), entry.getValue().getNombre());
        }
        return lista;
	}
	
	
	
	
	
     // Métodos auxiliar 
     
	public int getCantidadBlogs() {
		return blogs.size();
	}
	
	
	
	public boolean existeBlog(int codigoBlog) {
        return blogs.containsKey(codigoBlog);
    }
	

	
}
