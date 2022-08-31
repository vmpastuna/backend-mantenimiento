package com.mantenimiento.vehicular.mantenimientovehicular.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mantenimiento.vehicular.mantenimientovehicular.dto.NewRepuestoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.RepuestoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.exceptions.NoContentException;
import com.mantenimiento.vehicular.mantenimientovehicular.exceptions.ResourceNotFoundException;
 import com.mantenimiento.vehicular.mantenimientovehicular.models.Repuesto;
import com.mantenimiento.vehicular.mantenimientovehicular.models.Vehiculo;
 import com.mantenimiento.vehicular.mantenimientovehicular.repositories.RepuestoRepository;
import com.mantenimiento.vehicular.mantenimientovehicular.repositories.VehiculoRepository;
import com.mantenimiento.vehicular.mantenimientovehicular.services.RepuestoService;

@Service
public class RepuestoServiceImpl implements RepuestoService {

    final ModelMapper modelMapper;
    final RepuestoRepository repuestoRepository;
    final VehiculoRepository vehiculoRepository;

    public RepuestoServiceImpl(RepuestoRepository rep, VehiculoRepository veh,ModelMapper mapper) {
        this.modelMapper = mapper;
        this.repuestoRepository = rep;
        this.vehiculoRepository = veh;
    }

    @Override
    @Transactional
    public RepuestoDTO create(Long idVehi, NewRepuestoDTO repuestoDTO) {
        Vehiculo vehiculo = vehiculoRepository.findById(idVehi)
            .orElseThrow(()-> new ResourceNotFoundException("Vehiculo not found"));
        Repuesto repuesto = modelMapper.map(repuestoDTO, Repuesto.class); 
        repuesto.setVehiculo(vehiculo);   
        repuestoRepository.save(repuesto);
        return modelMapper.map(repuesto, RepuestoDTO.class); 
    }

    @Override
    @Transactional
    public void delete(Long idVehi, Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(idVehi)
        .orElseThrow(()-> new ResourceNotFoundException("Vehiculo not found"));
        Repuesto repuesto = repuestoRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Repuesto not found"));
        repuesto.setVehiculo(vehiculo);
        repuestoRepository.deleteById(repuesto.getId());  
    }

    @Override
    @Transactional(readOnly=true)
    public List<RepuestoDTO> list(Long idVehi) {
        Vehiculo vehiculo = vehiculoRepository.findById(idVehi)
            .orElseThrow(()-> new ResourceNotFoundException("Vehiculo not found"));
        List<Repuesto> repuestos = repuestoRepository.findByVehiculo(vehiculo);
        if(repuestos.isEmpty()) throw new NoContentException("Repuesto is empty");
        //Lambda ->
        return repuestos.stream().map(q -> modelMapper.map(q, RepuestoDTO.class) )
            .collect(Collectors.toList());
    }

}
