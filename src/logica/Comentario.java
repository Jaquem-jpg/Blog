package logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Comentario {
    private LocalDateTime fechaCreacion;
    private String emailAutor;
    private String ip;
    private String texto;

    public Comentario(String emailAutor, String ip, String texto) {
        this.fechaCreacion = LocalDateTime.now();
        this.emailAutor = emailAutor;
        this.ip = ip;
        this.texto = texto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEmailAutor() {
        return emailAutor;
    }

    public String getIp() {
        return ip;
    }

    public String getTexto() {
        return texto;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format("[%s] %s (%s): %s", 
            fechaCreacion.format(formatter), emailAutor, ip, texto);
    }
}