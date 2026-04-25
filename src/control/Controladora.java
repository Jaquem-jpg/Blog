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
		System.out.println("Blog creado exitosamente con el  código: " + codigo);
		return codigo;
	}
	
	
	// Borrar un Blog 
	public boolean borrarBlog(int codigoBlog) {
		if (blogs.remove(codigoBlog) != null) {
			System.out.println("Blog " + codigoBlog + "eliminado");
			return true;
		} else {
			System.out.println("No se encontró el blog con el código: " + codigoBlog);
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
	
	
	
	// Crear  la publicación de un blog especifico 
	
	public  void crearPublicacion(int codigoBlog, String titulo, String texto, String creador) {
		Blog blog = blogs.get(codigoBlog);
		if(blog != null) {
			blog.crearPublicacion(titulo, texto, creador);
			System.out.println("Publicación creada en el blog: " + codigoBlog);
		} else {
			System.out.println(" Error, No existe el blog con  el código: " + codigoBlog);
		}
	}
	
	
	// Obtener lista de publicaciones de un blog 
	public Map<Integer, String> obtenerPublicacionesDeBlog(int codigoBlog){
		Blog blog = blogs.get(codigoBlog);
		if(blog != null) {
			return blog.getTitulosPublicacionesNumerados();
		} else {
			System.out.println(" Error, No existe el blog con el código: " + codigoBlog);
            return new HashMap<>();
		}
	}
	
	
	//Obtener una publicación completa
	public String obtenerPublicacion(int codigoBlog, int codigoPublicacion) {
		Blog blog = blogs.get(codigoBlog);
		 if( blog != null) {
			 return blog.getResumenPublicacion(codigoPublicacion);
		 } else {
			 return " Error, No existe el blog con el código: " + codigoBlog;
		 }
	} 
	
	
	
	// Agregar comentario a una publicación
	public void agregarComentario(int codigoBlog, int codigoPublicacion, String email, String ip, String texto) {
		Blog blog = blogs.get(codigoBlog);
		if(blog != null) {
			blog.agregarComentarioAPublicacion(codigoPublicacion, email, ip, texto);
            System.out.println(" Comentario agregado a la publicación " + codigoPublicacion);
		} else {
			System.out.println("Error, No existe el blog con el código: " + codigoBlog);
		}
	}
	
	
	// Borrar el comentario de una publicación
	public boolean borrarComentario(int codigoBlog, int codigoPublicacion, int posicionComentario) {
		Blog blog = blogs.get(codigoBlog);
		if (blog != null) {
			boolean borrado = blog.borrarComentarioDePublicacion(codigoPublicacion, posicionComentario);
			if(borrado) {
				System.out.println(" Comentario borrado exitosamente.");
			} else {
				System.out.println(" No se pudo logro borrar el comentario.");
			}
			return borrado;
		} else {
			System.out.println(" Error, No existe el blog con código:  " + codigoBlog);
            return false;
		}
	}
	


     // Métodos auxiliares
     
	public int getCantidadBlogs() {
		return blogs.size();
	}
	
	
	
	public boolean existeBlog(int codigoBlog) {
        return blogs.containsKey(codigoBlog);
    }
	

	
}
