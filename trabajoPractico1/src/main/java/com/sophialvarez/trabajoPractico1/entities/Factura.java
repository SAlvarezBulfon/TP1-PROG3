package com.sophialvarez.trabajoPractico1.entities;

import com.sophialvarez.trabajoPractico1.enums.FormaPago;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Factura extends BaseEntidad {

    private String fecha;

    private int numero;

    private Double descuento;

    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    private int total;
}