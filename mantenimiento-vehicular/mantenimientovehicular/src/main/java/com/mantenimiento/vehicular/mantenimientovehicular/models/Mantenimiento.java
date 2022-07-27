package com.mantenimiento.vehicular.mantenimientovehicular.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_MANTENIMIENTOS")
@Getter
@Setter
public class Mantenimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "FECHA_MANTENIMIENTO")
    private Date fechaMantenimiento;
    @Column(name = "PRECIO")
    private double precio;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "ESTADO")
    private boolean finalizado;

    @ManyToOne
    @JoinColumn(name="VEHICULO_ID", nullable=false)
    private Vehiculo vehiculo;

    @OneToMany(mappedBy = "mantenimiento")
    private List<Repuesto> repuestos;





}
