package com.sophialvarez.trabajoPractico1.entities;

import com.sophialvarez.trabajoPractico1.enums.TipoProducto;
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

    public void mostrarProducto(){
        System.out.println("    ------------------------");
        System.out.println("    Producto: ");
        System.out.println("    ------------------------");
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
        System.out.println("    ---------------------------");

    }

}