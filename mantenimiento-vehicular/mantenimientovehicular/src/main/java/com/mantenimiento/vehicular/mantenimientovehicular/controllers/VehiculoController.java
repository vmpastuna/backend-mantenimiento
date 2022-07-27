package com.mantenimiento.vehicular.mantenimientovehicular.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mantenimiento.vehicular.mantenimientovehicular.dto.NewVehiculoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.VehiculoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.VehiculoListDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.services.VehiculoService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    
    private final VehiculoService service;

    public VehiculoController(VehiculoService srv){
        this.service =srv;
    }
    
    /* ================ CREATE ================ */
    /**
     * @param examDTO
     * @return
     */
    @PostMapping()
    public ResponseEntity<VehiculoDTO> create(@Valid @RequestBody NewVehiculoDTO vehiculoDTO){
        VehiculoDTO result = service.create(vehiculoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);        
    }

    /* ================ RETRIEVE ================ */
    @GetMapping("/{id}")
    public ResponseEntity<VehiculoDTO> retrive(@PathVariable("id") Long id){
        VehiculoDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    /* ================ UPDATE ================ */
    @PutMapping("/{id}")
    public ResponseEntity<VehiculoDTO> update(@RequestBody VehiculoDTO vehiculoDTO, @PathVariable("id") Long id){
     VehiculoDTO result = service.update(vehiculoDTO, id);
        return ResponseEntity.ok().body(result);
    }

    /* ================ DELETE ================ */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /* ================ LIST ================ */
    @GetMapping("/{page}/{size}")
    public ResponseEntity<List<VehiculoListDTO>> list(@PathVariable("page") int page, 
        @PathVariable("size") int size,
        @RequestParam(name = "sort", required = false) String sort){
        List<VehiculoListDTO> result  = service.list(page, size, sort);
        return ResponseEntity.ok().body(result);        
    }

     /* ================ COUNT ================ */
     @GetMapping("/count")
     public ResponseEntity<Long> count(){
         long result = service.count();
         return ResponseEntity.ok().body(result);        
     }


}
