package com.mantenimiento.vehicular.mantenimientovehicular.models;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_REPUESTOS")
@Getter
@Setter
public class Repuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "CANTIDAD")
    private short cantidad;

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
    //relaciones
    @ManyToOne
    @JoinColumn(name="VEHICULO_ID", nullable=false)
    private Vehiculo vehiculo;

    


}
