package com.mantenimiento.vehicular.mantenimientovehicular.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mantenimiento.vehicular.mantenimientovehicular.dto.NewVehiculoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.VehiculoDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.dto.VehiculoListDTO;
import com.mantenimiento.vehicular.mantenimientovehicular.exceptions.NoContentException;
import com.mantenimiento.vehicular.mantenimientovehicular.exceptions.ResourceNotFoundException;
import com.mantenimiento.vehicular.mantenimientovehicular.models.Vehiculo;
import com.mantenimiento.vehicular.mantenimientovehicular.repositories.VehiculoRepository;
import com.mantenimiento.vehicular.mantenimientovehicular.services.VehiculoService;


@Service
public class VehiculoServiceImpl implements VehiculoService {
    
    final ModelMapper modelMapper;
    final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository repository, ModelMapper mapper){
        this.vehiculoRepository = repository;
        this.modelMapper = mapper;
    }

    @Override
    @Transactional
    public VehiculoDTO create(NewVehiculoDTO vehiculoDTO) {
        Vehiculo vehiculo = modelMapper.map(vehiculoDTO, Vehiculo.class);
        vehiculoRepository.save(vehiculo);        
        return modelMapper.map(vehiculo, VehiculoDTO.class); 
    }

    @Override
    @Transactional(readOnly = true)
    public VehiculoDTO retrieve(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("Vehiculo not found"));
        return modelMapper.map(vehiculo, VehiculoDTO.class);
    }

    @Override
    @Transactional
    public VehiculoDTO update(VehiculoDTO vehiculoDTO, Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Vehiculo not found"));        
              
        Vehiculo vehiculoUpdated = modelMapper.map(vehiculoDTO, Vehiculo.class);
        //Keeping values
        vehiculoUpdated.setCreatedBy(vehiculo.getCreatedBy());
        vehiculoUpdated.setCreatedDate(vehiculo.getCreatedDate());
        vehiculoRepository.save(vehiculoUpdated);   
        return modelMapper.map(vehiculoUpdated, VehiculoDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Vehiculo vehiculo = vehiculoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Vehiculo not found"));        
        vehiculoRepository.deleteById(vehiculo.getId());        
    }

    @Override
    @Transactional(readOnly = true)
    //paginacion
    public List<VehiculoListDTO> list(int page, int size, String sort) {
        Pageable pageable = sort == null || sort.isEmpty() ? 
                    PageRequest.of(page, size) 
                :   PageRequest.of(page, size,  Sort.by(sort));

        Page<Vehiculo> vehiculos = vehiculoRepository.findAll(pageable);
        if(vehiculos.isEmpty()) throw new NoContentException("Vehiculo is empty");
        return vehiculos.stream().map(vehiculo -> modelMapper.map(vehiculo, VehiculoListDTO.class))
            .collect(Collectors.toList());        
    }

    @Override
    public long count() {        
        return vehiculoRepository.count();
    }
    
}
