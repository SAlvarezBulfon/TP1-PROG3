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


    public void mostrarPedido(){
        System.out.println("---------------------------");
        System.out.println("Cliente: ");
        System.out.println("---------------------------");
        System.out.println("Nombre: " +  cliente.getNombre());
        System.out.println("Apellido: " +  cliente.getApellido());
        System.out.println("Telefono: " +  cliente.getTelefono());
        System.out.println("Email: " +  cliente.getEmail());
        System.out.println("Domicilio:  " + this.calle + " " + this.numero + ", " + this.localidad );
        cliente.mostrarPedidosCliente();
        System.out.println("---------------------------");
        System.out.println("Pedidos del Domicilio: ");
        System.out.println("---------------------------");
        for (Pedido p: pedidos) {
            System.out.println("    Pedido n°" + p.getId());
            System.out.println("    Fecha: " + p.getFecha());
            System.out.println("    Estado: " +p.getEstado());
            System.out.println("    ---------------------------");
            System.out.println("    Detalles pedidos: ");
            System.out.println("    ---------------------------");
           p.mostrarDetallesPedido();
           p.mostrarFactura();

        }
    }
}