package com.mantenimiento.vehicular.mantenimientovehicular.models;


import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_VEHICULOS")
@Getter
@Setter
public class Vehiculo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "PLACA")    
    private String placa;
    @Column(name = "MODELO")    
    private String modelo;
    @Column(name = "COLOR")    
    private String color;
    @Column(name = "MARCA")    
    private String marca;



    //relaciones

    @OneToMany(mappedBy="vehiculo",cascade = CascadeType.REMOVE) //nombre del atributo en la clase B       
    private List<Mantenimiento> mantenimientos;
    
    //auditoria
    @Column(name = "CREATED_DATE")    
    private Calendar createdDate;
    @Column(name = "CREATED_BY")    
    private String createdBy;  

    @Column(name = "UPDATED_DATE")    
    private Calendar updatedDate;
    @Column(name = "UPDATED_BY")    
    private String updatedBy;  

    @PrePersist
    public void prePersist(){
        createdDate = Calendar.getInstance();
        createdBy = "user1";
    }

    @PreUpdate
    public void preUpdate(){
        updatedDate = Calendar.getInstance();
        updatedBy = "user2";
    }
    
}
