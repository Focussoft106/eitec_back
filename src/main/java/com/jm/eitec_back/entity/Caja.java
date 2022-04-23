package com.jm.eitec_back.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Entity
@Table(name="Caja")
@Data
public class Caja  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idc;
    private String nombre;
    private Double precio;
    private Integer cantidad;
    private String descripcion;

    @OneToMany(mappedBy="caja")
    private List<Imagen> imagenes;

    @ManyToMany(mappedBy = "cajas")
    @JsonIgnore
    private List<Pedido> pedidos;
}