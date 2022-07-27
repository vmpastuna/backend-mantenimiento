package com.mantenimiento.vehicular.mantenimientovehicular.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mantenimiento.vehicular.mantenimientovehicular.dto.MantenimientoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.MantenimientoVehiculoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.NewMantenimientoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.exceptions.NoContentException;
import com.mantenimiento.vehicular.mantenimientovehicular.exceptions.ResourceNotFoundException;
import com.mantenimiento.vehicular.mantenimientovehicular.models.Mantenimiento;
import com.mantenimiento.vehicular.mantenimientovehicular.models.Vehiculo;
import com.mantenimiento.vehicular.mantenimientovehicular.repositories.MantenimientoRepository;
import com.mantenimiento.vehicular.mantenimientovehicular.repositories.VehiculoRepository;
import com.mantenimiento.vehicular.mantenimientovehicular.services.MantenimientoService;

@Service
public class MantenimientoServiceImpl  implements MantenimientoService{
    
    final ModelMapper modelMapper;
    final MantenimientoRepository manteniRepository;
    final VehiculoRepository vehiculoRepository;

    public MantenimientoServiceImpl(MantenimientoRepository manteni, VehiculoRepository veh, ModelMapper mapper)
    {
        this.modelMapper = mapper;
        this.manteniRepository= manteni;
        this.vehiculoRepository = veh;
    }


    @Override
    @Transactional
    public MantenimientoDTO create(Long idVehiculo, NewMantenimientoDTO manteniDTOs) {
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo)
            .orElseThrow(()-> new ResourceNotFoundException("Vehiculo not found"));
        Mantenimiento mantenimiento = modelMapper.map(manteniDTOs, Mantenimiento.class);    
        mantenimiento.setVehiculo(vehiculo);
        manteniRepository.save(mantenimiento);
        return modelMapper.map(mantenimiento, MantenimientoDTO.class); 
    }

    @Override
    @Transactional(readOnly=true)
    public MantenimientoVehiculoDTO retrieve(Long idVehiculo, Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo)
            .orElseThrow(()-> new ResourceNotFoundException("Vehiculo not found"));
        Mantenimiento mantenimiento = manteniRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Mantenimiento not found"));
        mantenimiento.setVehiculo(vehiculo);
        return modelMapper.map(mantenimiento, MantenimientoVehiculoDTO.class);
    }

    @Override
    @Transactional
    public MantenimientoVehiculoDTO update(MantenimientoDTO manteniDTO, Long idVehiculo, Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo)
        .orElseThrow(()-> new ResourceNotFoundException("Vehiculo not found"));
        Mantenimiento mantenimiento = manteniRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Mantenimiento not found"));
        mantenimiento = modelMapper.map(manteniDTO, Mantenimiento.class);
        mantenimiento.setVehiculo(vehiculo);
        manteniRepository.save(mantenimiento);       
        return modelMapper.map(mantenimiento, MantenimientoVehiculoDTO.class);
    }


    @Override
    @Transactional
    public void delete(Long idvehiculo, Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(idvehiculo)
        .orElseThrow(()-> new ResourceNotFoundException("Vehiculo not found"));
        Mantenimiento mantenimiento = manteniRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Mantenimiento not found"));
        mantenimiento.setVehiculo(vehiculo);
        manteniRepository.deleteById(mantenimiento.getId());  
    }

    @Override
    @Transactional(readOnly=true)
    public List<MantenimientoDTO> list(Long idVehiculo) {
        Vehiculo vehiculo = vehiculoRepository.findById(idVehiculo)
            .orElseThrow(()-> new ResourceNotFoundException("Vehiculo not found"));
        List<Mantenimiento> mantenimientos = manteniRepository.findByVehiculo(vehiculo);
        if(mantenimientos.isEmpty()) throw new NoContentException("Mantenimiento is empty");
        //Lambda ->
        return mantenimientos.stream().map(mant -> modelMapper.map(mant, MantenimientoDTO.class) )
            .collect(Collectors.toList());
    }


}
