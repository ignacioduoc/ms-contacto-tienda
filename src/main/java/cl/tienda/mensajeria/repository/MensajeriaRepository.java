package cl.tienda.mensajeria.repository;

import cl.tienda.mensajeria.model.Mensajeria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeriaRepository extends JpaRepository <Mensajeria,Long>{
    
}
