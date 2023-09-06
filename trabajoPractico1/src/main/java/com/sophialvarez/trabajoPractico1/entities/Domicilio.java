package com.sophialvarez.trabajoPractico1.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Domicilio extends BaseEntidad {

    private String calle;

    private String numero;

    private String localidad;

    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "domicilio_id")
    @Builder.Default
    private List<Pedido> pedidos  = new ArrayList<>();

    public void addPedido(Pedido pedido1) {
        pedidos.add(pedido1);
    }
}