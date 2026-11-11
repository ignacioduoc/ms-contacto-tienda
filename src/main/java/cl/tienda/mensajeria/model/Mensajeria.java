package cl.tienda.mensajeria.model;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;;

@Data
@Entity
@Table(name = "contacto")

public class Mensajeria {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_completo", nullable = false, length = 150)
    private String nombreCompleto;

    @Column(nullable = false, length = 150)
    private String correo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String mensaje;

    //estado inicial del mensaje de contacto
    @Column (name = "estado", nullable = false, length = 20)
    private String estado = "PENDIENTE";
    
    //Vincula el atributo java con la columna fecha_creacion de MySQL
    @Column (name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    //Asigna automaticamente la fecha y hora antes de insertar el contacto
    @PrePersist
    protected void asignarFechaCreacion(){
        this.fechaCreacion = LocalDateTime.now();
    }
}
