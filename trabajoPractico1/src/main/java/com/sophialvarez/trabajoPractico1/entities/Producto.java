package com.sophialvarez.trabajoPractico1.entities;

import com.sophialvarez.trabajoPractico1.enums.TipoProducto;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto extends BaseEntidad{

    private TipoProducto tipo;

    private int tiempoEstimadoCocina;

    private String denominacion;

    private Double precioVenta;

    private Double precioCompra;

    private int stockActual;

    private int stockMinimo;

    private String unidadMedida;

    private String foto;

    private String receta;
}