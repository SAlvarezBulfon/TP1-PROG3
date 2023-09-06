package com.sophialvarez.trabajoPractico1.entities;

import jakarta.persistence.*;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Cliente extends BaseEntidad{

    private String nombre;

    private String apellido;

    private String telefono;

    private String email;

    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void addPedido(Pedido pedido1) {
        pedidos.add(pedido1);
    }
}