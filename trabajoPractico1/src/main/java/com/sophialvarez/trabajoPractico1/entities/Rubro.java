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
public class Rubro extends BaseEntidad {

    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubro_id")
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();


    public void addProductos(Producto p){
        productos.add(p);
    }


    public void mostrarRubro(){
        System.out.println("---------------------------");
        System.out.println("Rubro: ");
        System.out.println("---------------------------");
        System.out.println("Denominación: " + this.denominacion);
        System.out.println("    ------------------------");
        System.out.println("    Productos: ");
        System.out.println("    ------------------------");
        for (Producto producto: productos) {
            System.out.println("       Producto n°" + producto.getId());
            System.out.println("       Tipo: " + producto.getTipo());
            System.out.println("       Tiempo Estimado de cocina: " + producto.getTiempoEstimadoCocina());
            System.out.println("       Denominación: " + producto.getDenominacion());
            System.out.println("       Precio de venta: " + producto.getPrecioVenta());
            System.out.println("       Precio de compra: " + producto.getPrecioCompra());
            System.out.println("       Stock actual: " + producto.getStockActual());
            System.out.println("       Stock mínimo: " + producto.getStockMinimo());
            System.out.println("       Unidad de medida: " + producto.getUnidadMedida());
            System.out.println("       Foto: " + producto.getFoto());
            System.out.println("       Receta: " + producto.getReceta());
            System.out.println("       ------------------------");
        }
    }
}

