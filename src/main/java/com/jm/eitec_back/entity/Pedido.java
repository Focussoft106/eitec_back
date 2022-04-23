package com.jm.eitec_back.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="Pedido")
@Data
public class Pedido  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idp;
    private String cliente;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private Boolean tipoPago;
    private Boolean estado;
    private Double total;
    private String direccion;
    private String telefono;

    @ManyToMany(fetch=FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name="DetallePedido",
            joinColumns=@JoinColumn(name="idp",referencedColumnName ="idp"),
            inverseJoinColumns=@JoinColumn(name="idc",referencedColumnName ="idc"))
    private List<Caja> cajas;

    @Transient
    private Long usuarioId;


    public void agregar(Caja nuevo) {
        if(cajas == null)
            cajas = new ArrayList<Caja>();
        cajas.add(nuevo);
    }

}