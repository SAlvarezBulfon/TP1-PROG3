package com.sophialvarez.trabajoPractico1.entities;

import com.sophialvarez.trabajoPractico1.enums.Estado;
import com.sophialvarez.trabajoPractico1.enums.FormaPago;
import com.sophialvarez.trabajoPractico1.enums.TipoEnvio;
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
public class Pedido extends BaseEntidad{

    private String fecha;

    private Estado estado;

    private String horaEstimadaEntrega;
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    private Double total;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallesPedido> detallesPedidos = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    public void addDetallePedido(DetallesPedido detallePedido1) {
        detallesPedidos.add(detallePedido1);
    }


    public void mostrarDetallesPedido(){
        for (DetallesPedido dp: detallesPedidos) {
            System.out.println("    Detalle del pedido n°" + dp.getId());
            System.out.println("    Cantidad:" + dp.getCantidad());
            System.out.println("    Subtotal:" + dp.getSubtotal());
            dp.mostrarProducto();
        }
    }

    public void mostrarFactura(){
        System.out.println("    ------------------------");
        System.out.println("    Factura: ");
        System.out.println("    ------------------------");
        System.out.println("        Fecha: " + factura.getFecha());
        System.out.println("        Numero: " + factura.getNumero());
        System.out.println("        Descuento: " + factura.getDescuento());
        System.out.println("        Forma de pago: " + factura.getFormaPago());
        System.out.println("        Total: " + factura.getTotal());
    }
}