package com.sophialvarez.trabajoPractico1.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetallesPedido extends BaseEntidad{

    private int cantidad;

    private Double subtotal;

    @ManyToOne()
    @JoinColumn(name = "producto_id")
    private Producto producto;



}