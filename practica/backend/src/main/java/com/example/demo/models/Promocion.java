package com.example.demo.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.TemporalType;

@Data
@Entity
@Table(name = "promocion")
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Guayaquil")
    private Date fecha_inicio;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "America/Guayaquil")
    private Date fecha_fin;

    @OneToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
}
