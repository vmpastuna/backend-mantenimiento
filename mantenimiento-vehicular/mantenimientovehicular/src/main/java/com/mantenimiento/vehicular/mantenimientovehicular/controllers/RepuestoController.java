package com.mantenimiento.vehicular.mantenimientovehicular.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantenimiento.vehicular.mantenimientovehicular.dto.NewRepuestoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.RepuestoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.services.RepuestoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/vehiculos")
public class RepuestoController {

     
    final RepuestoService service;

    public RepuestoController(RepuestoService srv){
        this.service = srv;
    }

    /* ================ CREATE ================ */
    @Secured({"ROLE_GERENTE"})
    @PostMapping("/{id}/repuestos")
    public ResponseEntity<RepuestoDTO> create(@PathVariable("id") Long id, @Valid @RequestBody NewRepuestoDTO repuestoDTO){
        RepuestoDTO repuesDTO = service.create(id, repuestoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(repuesDTO);        
    }

    


    /* ================ DELETE ================ */
    @Secured({"ROLE_GERENTE"})
    @DeleteMapping("/{idVehi}/repuestos/{id}")
    public ResponseEntity<Void> delete(@PathVariable("idVehi") Long idVehi, @PathVariable("id") Long id){
        service.delete(idVehi, id);
        return ResponseEntity.noContent().build();
    }

    /* ================ LIST ================ */
    @Secured({"ROLE_GERENTE", "ROLE_CLIENTE"})
    @GetMapping("/{id}/repuestos")
    public ResponseEntity<List<RepuestoDTO>> list(@PathVariable("id") Long id){
        List<RepuestoDTO> repuestos = service.list(id);
        return ResponseEntity.ok().body(repuestos);        
    }


}
