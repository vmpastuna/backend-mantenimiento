package com.mantenimiento.vehicular.mantenimientovehicular.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mantenimiento.vehicular.mantenimientovehicular.dto.NewRepuestoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.RepuestoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.exceptions.NoContentException;
import com.mantenimiento.vehicular.mantenimientovehicular.exceptions.ResourceNotFoundException;
import com.mantenimiento.vehicular.mantenimientovehicular.models.Mantenimiento;
import com.mantenimiento.vehicular.mantenimientovehicular.models.Repuesto;
import com.mantenimiento.vehicular.mantenimientovehicular.models.Vehiculo;
import com.mantenimiento.vehicular.mantenimientovehicular.repositories.MantenimientoRepository;
import com.mantenimiento.vehicular.mantenimientovehicular.repositories.RepuestoRepository;
import com.mantenimiento.vehicular.mantenimientovehicular.repositories.VehiculoRepository;
import com.mantenimiento.vehicular.mantenimientovehicular.services.RepuestoService;

@Service
public class RepuestoServiceImpl implements RepuestoService {

    final ModelMapper modelMapper;
    final RepuestoRepository repuestoRepository;
    final MantenimientoRepository manteniRepository;
    final VehiculoRepository vehiculoRepository;

    public RepuestoServiceImpl(RepuestoRepository rep, MantenimientoRepository manteni, VehiculoRepository veh,
            ModelMapper mapper) {
        this.modelMapper = mapper;
        this.repuestoRepository = rep;
        this.manteniRepository = manteni;
        this.vehiculoRepository = veh;
    }

    @Override
    @Transactional
    public List<RepuestoDTO> create(Long idVehiculo, Long idManteni, List<NewRepuestoDTO> repuestoC) {
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo)
                .orElseThrow(() -> new ResourceNotFoundException("Vehiculo not found"));
        Mantenimiento mantenimiento = manteniRepository.findById(idManteni)
                .orElseThrow(() -> new ResourceNotFoundException("Mantenimiento not found"));
        mantenimiento.setVehiculo(vehiculo);
        List<RepuestoDTO> result = new ArrayList<RepuestoDTO>();
        
        repuestoC.forEach(op -> {
            Repuesto repuesto = modelMapper.map(op, Repuesto.class);
            //repuesto.setMantenimiento(mantenimiento);
            //epuestoRepository.save(repuesto);
            result.add(modelMapper.map(repuesto, RepuestoDTO.class));
         });
        
        
        /*for (NewRepuestoDTO op : repuestoC) {
            Repuesto repuesto = modelMapper.map(op, Repuesto.class);
            repuesto.setMantenimiento(mantenimiento);
            repuestoRepository.save(repuesto);
            result.add(modelMapper.map(repuesto, RepuestoDTO.class));
        }
        */
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RepuestoDTO> list(Long idVehiculo, Long idManteni) {
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo)
                .orElseThrow(() -> new ResourceNotFoundException("Vehiculo not found"));
        Mantenimiento mantenimiento = manteniRepository.findById(idManteni)
                .orElseThrow(() -> new ResourceNotFoundException("Mantenimiento not found"));
        mantenimiento.setVehiculo(vehiculo);
        if (mantenimiento.getRepuestos().isEmpty())
            throw new NoContentException("Repuesto is empty");
        return mantenimiento.getRepuestos().stream().map(op -> modelMapper.map(op, RepuestoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void remove(Long idVehiculo, Long idManteni) {
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo)
                .orElseThrow(() -> new ResourceNotFoundException("Vehiculo not found"));
        Mantenimiento mantenimiento = manteniRepository.findById(idManteni)
                .orElseThrow(() -> new ResourceNotFoundException("Mantenimiento not found"));
        mantenimiento.setVehiculo(vehiculo);
        if (mantenimiento.getRepuestos().isEmpty())
            throw new NoContentException("Repuestos is empty");
        mantenimiento.getRepuestos().forEach(op -> {
            repuestoRepository.delete(op);
        });
    }

}
