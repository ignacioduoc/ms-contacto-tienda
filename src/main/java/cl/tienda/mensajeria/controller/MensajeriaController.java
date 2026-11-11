package cl.tienda.mensajeria.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cl.tienda.mensajeria.model.Mensajeria;
import cl.tienda.mensajeria.service.MensajeriaService;

@RestController 

@RequestMapping ("/api/contactos")
@CrossOrigin(origins = "http://localhost:5173")
public class MensajeriaController {
 
    private final MensajeriaService service;

    public MensajeriaController(MensajeriaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Mensajeria> guardar(
        @RequestBody Mensajeria contacto){

            Mensajeria guardado = service.guardar(contacto);

            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(guardado);
    }

    @GetMapping 
    public List<Mensajeria> listar(){
        return  service.listar();
    }

}
