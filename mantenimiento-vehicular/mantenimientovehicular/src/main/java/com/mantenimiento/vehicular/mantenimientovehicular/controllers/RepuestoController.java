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
    @PostMapping("/{id}/mantenimientos/{idManteni}/repuestos")
    public ResponseEntity<List<RepuestoDTO>> create(@PathVariable("id") Long id, @PathVariable("idManteni") Long idManteni, @Valid @RequestBody List<NewRepuestoDTO> repuestosDTO){
        List<RepuestoDTO> repuestoDTOs = service.create(id, idManteni, repuestosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(repuestoDTOs);        
    }

    /* ================ DELETE ================ */
    @Secured({"ROLE_GERENTE"})
    @DeleteMapping("/{id}/mantenimientos/{idManteni}/repuestos")
    public ResponseEntity<List<RepuestoDTO>> delete(@PathVariable("id") Long id, @PathVariable("idManteni") Long idManteni){
        service.remove(id, idManteni);
        return ResponseEntity.noContent().build();
    }

    /* ================ LIST ================ */
    @Secured({"ROLE_GERENTE", "ROLE_CLIENTE"})
    @GetMapping("/{id}/mantenimientos/{idManteni}/repuestos")
    public ResponseEntity<List<RepuestoDTO>> list(@PathVariable("id") Long id, @PathVariable("idManteni") Long idManteni){
        List<RepuestoDTO> repuestoDTOs = service.list(id, idManteni);
        return ResponseEntity.status(HttpStatus.OK).body(repuestoDTOs);        
    }

}
