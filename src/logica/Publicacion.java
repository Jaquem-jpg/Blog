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

    public Publicacion(String titulo, String texto, String creador) {
        this.codigo = contadorCodigo++;
        this.titulo = titulo;
        this.creador = creador;
        this.fechaPublicacion = LocalDateTime.now();
        this.texto = texto;
        this.consecutivo = 0;
        this.comentarios = new ArrayList<>();
    }

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

    public void agregarComentario(String email, String ip, String texto) {
        Comentario comentario = new Comentario(email, ip, texto);
        comentarios.add(comentario);
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public boolean eliminarComentario(int posicion) {
        if (posicion >= 0 && posicion < comentarios.size()) {
            comentarios.remove(posicion);
            return true;
        }
        return false;
    }

    public String mostrarConComentarios() {
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        sb.append("Publicación #").append(codigo).append("\n");
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("Creador: ").append(creador).append("\n");
        sb.append("Fecha: ").append(fechaPublicacion.format(formatter)).append("\n");
        sb.append("Texto: ").append(texto).append("\n");
        sb.append("Comentarios:\n");
        if (comentarios.isEmpty()) {
            sb.append("  Sin comentarios.\n");
        } else {
            for (int i = 0; i < comentarios.size(); i++) {
                sb.append("  ").append(i).append(": ").append(comentarios.get(i).toString()).append("\n");
            }
        }
        return sb.toString();
    }
}