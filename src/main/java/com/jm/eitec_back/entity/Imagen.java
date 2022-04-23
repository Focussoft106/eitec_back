package com.jm.eitec_back.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name="Imagen")
@Data
public class Imagen  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idi;

    private String ruta;

    @ManyToOne
    @JoinColumn(name="caja_id", nullable=false)
    @JsonIgnore
    private Caja caja;
}