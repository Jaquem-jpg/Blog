package prueba;

import control.Controladora;
import java.util.Map;
import java.util.Scanner;

public class Main {
	private static Controladora controlador = new Controladora();
	private static Scanner scanner = new Scanner(System.in);
	private static Integer blogActual = null;   // Código del blog con el que se está trabajando

	public static void main(String[] args) {
		System.out.println("=== SISTEMA DE BLOGS DE INTERNET ===");
		
		// métodos para los datos iniciales
		inicializarDatosDePrueba();
		
		mostrarMenuPrincipal();
		
	}
	
	// ====================== Datos iniciales ==================================
	private static void inicializarDatosDePrueba() {
		// Creamos 2 blogs 
	    int blog1 = controlador.crearBlog("Blog de Tecnología", 
	                                     "Tutoriales y noticias de programación");
	    
	    int blog2 = controlador.crearBlog("Blog de Viajes", 
	                                     "Experiencias y recomendaciones alrededor del mundo");

	    // Agregamos 2 publicaciones 
	    controlador.crearPublicacion(blog1, "Java 21 - Novedades", 
	                                "Java 21 ahora trae records, pattern matching y muchas más características!!!", 
	                                "Carl Johnson");
	    
	    controlador.crearPublicacion(blog1, "Inteligencia Artificial en 2026", 
	                                "El estado actual de la IA y sus aplicaciones en el día a día.", 
	                                "Tony Laguna");

	    controlador.crearPublicacion(blog2, "Mi viaje a El Salvador", 
	                                "Una experiencia inolvidable en San Salvador y sus alrededores.", 
	                                "Jaquem Obando");
	    
	    controlador.crearPublicacion(blog2, "Consejos para viajar barato", 
	                                "¿Cómo ahorrar en tus próximas vacaciones sin sacrificar calidad?", 
	                                "Luisito Comunica");

	    // Agregamos 2 comentarios a cada Publicación
	    System.out.println("\nAgregando comentarios de prueba...");

	   
	    controlador.agregarComentario(blog1, 1, "juan.Guillen23@hotmail.com", "192.168.1.10", 
	                                 "Excelente artículo! Me sirvió mucho lo de los records.");
	    
	    controlador.agregarComentario(blog1, 1, "CarlosBlanco2026@email.com", "192.168.1.15", 
	                                 "Gracias por la información, muy claro todo.");

	   
	    controlador.agregarComentario(blog1, 2, "Laura2023@hotmail.com", "192.168.1.20", 
	                                 "Muy interesante el tema de IA. ¿Recomiendas algún curso para aprender sobre IA?");

	    controlador.agregarComentario(blog1, 2, "FranlinChanDías@hotmail.com", "192.168.1.25", 
	                                 "Buen resumen, lo compartiré con mis compañeros de clase.");

	    
	    controlador.agregarComentario(blog2, 1, "Messi@email.com", "192.168.1.30", 
	                                 "Qué bonito San Salvador! Yo estuve el año pasado, gran experiencia.");

	    controlador.agregarComentario(blog2, 1, "Pelé@email.com", "192.168.1.35", 
	                                 "Gracias por compartir tu experiencia Jaquem!");

	    controlador.agregarComentario(blog2, 2, "ArayaVlogs@email.com", "192.168.1.40", 
	                                 "Excelentes consejos! Definitivamente voy a aplicar lo de viajar en temporada baja.");

	    controlador.agregarComentario(blog2, 2, "daniela.castro@email.com", "192.168.1.45", 
	                                 "Muy útil el artículo. ¿Algún tip extra para vuelos baratos?");

	    System.out.println(" Datos de prueba inicializados correctamente.\n");
		
	}
	
	// ====================== Menú Principal =================================
	private static void mostrarMenuPrincipal() {
		while (true) {
			System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Administracion de Blogs");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opcion: ");
            
            int opcion = leerEntero();
            
            switch (opcion) {
            case 1: 
            	menuAdministracionBlogs();
            	break;
            case 2:
            	System.out.println("¡Gracias por usar el Sistema de Blogs!");
                scanner.close();
                return;
            default:
            	System.out.println("Opción inválida. Intente de nuevo.");
            
            }
		}
	}
	
	private static int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor ingrese un número válido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static String leerTexto() {
        scanner.nextLine();
        return scanner.nextLine().trim();
    }

	
	
}
