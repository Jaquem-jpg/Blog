package prueba;

import logica.Blog;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Crear un blog
        Blog miBlog = new Blog("Mi Blog Tech", "Blog sobre tecnología y programación");
        
        // Crear publicaciones
        miBlog.crearPublicacion("Java 21", "Java 21 trae nuevas features...", "Carlos");
        miBlog.crearPublicacion("Python vs Java", "Comparativa entre Python y Java...", "Ana");
        
        // Mostrar títulos de publicaciones
        System.out.println("=== Títulos de publicaciones ===");
        Map<Integer, String> titulos = miBlog.getTitulosPublicacionesNumerados();
        for (Map.Entry<Integer, String> entry : titulos.entrySet()) {
            System.out.println("Código " + entry.getKey() + ": " + entry.getValue());
        }
        
        // Agregar comentarios
        miBlog.agregarComentarioAPublicacion(1, "juan@email.com", "192.168.1.1", "Muy buen artículo!");
        miBlog.agregarComentarioAPublicacion(1, "maria@email.com", "192.168.1.2", "Gracias por la info");
        
        // Mostrar resumen de publicación
        System.out.println("\n=== Resumen Publicación Código 1 ===");
        System.out.println(miBlog.getResumenPublicacion(1));
        
        // Borrar un comentario
        boolean borrado = miBlog.borrarComentarioDePublicacion(1, 0);
        System.out.println("Comentario borrado: " + borrado);
        
        // Mostrar publicación después de borrar
        System.out.println("\n=== Después de borrar comentario ===");
        System.out.println(miBlog.getResumenPublicacion(1));
    }
}
