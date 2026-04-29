package logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private static int contadorCodigo = 1;
    private int codigo;
    private String titulo;
    private String creador;
    private LocalDateTime fechaPublicacion;
    private String texto;
    private int consecutivo;
    private List<Comentario> comentarios;


    // Constructor
    public Publicacion(String titulo, String texto, String creador) {
        this.codigo = contadorCodigo++;
        this.titulo = titulo;
        this.creador = creador;
        this.fechaPublicacion = LocalDateTime.now();
        this.texto = texto;
        this.consecutivo = 0;
        this.comentarios = new ArrayList<>();
    }

    // Gettes y Setters 

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }


    // Métodos de la clase Publicacion
    
    public void agregarComentario(String email, String ip, String texto) {
        Comentario comentario = new Comentario(email, ip, texto);
        comentarios.add(comentario);
    }

    public List<Comentario> getComentarios() {
        return new ArrayList<>(comentarios);  //Así devolvemos una copia.
    }

    /**
     * Elimina el comentario en la posición indicada.
     * 
     * @param posicion índice del comentario a eliminar 
     * @throws IndexOutOfBoundsException si la posición es negativa o 
     *         mayor o igual al tamaño de la lista de comentarios
     */
    public void eliminarComentario(int posicion) {
        if (posicion < 0 || posicion >= comentarios.size()) {
            throw new IndexOutOfBoundsException(
                "Posicion invalida: " + posicion + 
                ". Debe estar entre 0 y " + (comentarios.size() - 1)
            );
        }
        
        comentarios.remove(posicion);
    }
    
    
    
    public String mostrarConComentarios() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Publicación #%d%n", codigo));
        sb.append(String.format("Título: %s%n", titulo));
        sb.append(String.format("Creador: %s%n", creador));
        sb.append(String.format("Fecha: %s%n", fechaPublicacion.format(formatter)));
        sb.append(String.format("Texto: %s%n", texto));
        sb.append("Comentarios:\n");

        if (comentarios.isEmpty()) {
            sb.append(" Sin comentarios.\n");
        } else {
            for (int i = 0; i < comentarios.size(); i++) {
                sb.append(String.format(" %d: %s%n", i, comentarios.get(i)));
            }
        }

        return sb.toString();
    }
    
    
}