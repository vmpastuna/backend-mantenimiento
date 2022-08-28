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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mantenimiento.vehicular.mantenimientovehicular.dto.MantenimientoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.MantenimientoVehiculoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.NewMantenimientoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.services.MantenimientoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/vehiculos")
public class MantenimientoController {

    final MantenimientoService service;

    public MantenimientoController(MantenimientoService srv){
        this.service = srv;
    }

    /* ================ CREATE ================ */
    @Secured({"ROLE_GERENTE"})
    @PostMapping("/{id}/mantenimientos")
    public ResponseEntity<MantenimientoDTO> create(@PathVariable("id") Long id, @Valid @RequestBody NewMantenimientoDTO manteniDTO){
        MantenimientoDTO mantenimientoDTO = service.create(id, manteniDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mantenimientoDTO );        
    }

    /* ================ RETRIEVE ================ */
    @Secured({"ROLE_GERENTE", "ROLE_CLIENTE"})
    @GetMapping("/{idVehiculo}/mantenimientos/{idMantenimiento}")
    public ResponseEntity<MantenimientoVehiculoDTO> retrive(@PathVariable("idVehiculo") Long idVehiculo, @PathVariable("idMantenimiento") Long idMantenimiento){
        MantenimientoVehiculoDTO result = service.retrieve(idVehiculo, idMantenimiento);
        return ResponseEntity.ok().body(result);        
    }

    /* ================ UPDATE ================ */
    @Secured({"ROLE_GERENTE"})
    @PutMapping("/{idVehiculo}/mantenimientos/{id}")
    public ResponseEntity<MantenimientoVehiculoDTO> update(@RequestBody MantenimientoDTO manteniDTO, @PathVariable("idVehiculo") Long idVehiculo, @PathVariable("id") Long id){
        MantenimientoVehiculoDTO result = service.update(manteniDTO, idVehiculo, id);
        return ResponseEntity.ok().body(result);
    }

    /* ================ DELETE ================ */
    @Secured({"ROLE_GERENTE"})
    @DeleteMapping("/{idVehiculo}/mantenimientos/{id}")
    public ResponseEntity<Void> delete(@PathVariable("idVehiculo") Long idVehiculo, @PathVariable("id") Long id){
        service.delete(idVehiculo, id);
        return ResponseEntity.noContent().build();
    }

    /* ================ LIST ================ */
    @Secured({"ROLE_GERENTE", "ROLE_CLIENTE"})
    @GetMapping("/{id}/mantenimientos")
    public ResponseEntity<List<MantenimientoDTO>> list(@PathVariable("id") Long id){
        List<MantenimientoDTO> mantenimientos = service.list(id);
        return ResponseEntity.ok().body(mantenimientos);        
    }
 
}
