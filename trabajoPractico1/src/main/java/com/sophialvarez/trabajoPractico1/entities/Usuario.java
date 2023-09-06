package com.sophialvarez.trabajoPractico1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario extends BaseEntidad{

    private String nombre;

    private String password;

    private String rol;

    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void addPedido(Pedido pedido1) {
        pedidos.add(pedido1);
    }




    public void mostrarUsuarioYPedidos() {
        System.out.println("---------------------------");
        System.out.println("Usuario: ");
        System.out.println("---------------------------");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Contraseña: " + this.password);
        System.out.println("Rol: " + this.rol);
        for (Pedido p : pedidos) {
            System.out.println(" ---------------------------");
            System.out.println(" Pedidos del Usuario: ");
            System.out.println(" ---------------------------");
            System.out.println("        Pedido n°" + p.getId());
            System.out.println("        Fecha: " + p.getFecha());
            System.out.println("        Estado: " + p.getEstado());
            System.out.println("    ---------------------------");
            System.out.println("    Detalles pedidos: ");
            System.out.println("    ---------------------------");
            p.mostrarDetallesPedido();
            p.mostrarFactura();
        }
    }

}