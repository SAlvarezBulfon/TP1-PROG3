package com.sophialvarez.trabajoPractico1;

import com.sophialvarez.trabajoPractico1.entities.*;
import com.sophialvarez.trabajoPractico1.enums.Estado;
import com.sophialvarez.trabajoPractico1.enums.FormaPago;
import com.sophialvarez.trabajoPractico1.enums.TipoEnvio;
import com.sophialvarez.trabajoPractico1.enums.TipoProducto;
import com.sophialvarez.trabajoPractico1.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrabajoPractico1Application {

	public static void main(String[] args) {
		SpringApplication.run(TrabajoPractico1Application.class, args);
	}

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DomicilioRepository domicilioRepository;

	@Autowired
	ProductoRepository productoRepository;


	@Bean
	CommandLineRunner init(){
		return args -> {
			Rubro rubro1 = Rubro.builder()
					.denominacion("Bebida")
					.build();

			Producto producto1 = Producto.builder()
					.denominacion("Bebida")
					.foto("CocaCola.png")
					.tipo(TipoProducto.INSUMO)
					.precioCompra(100.0)
					.precioVenta(150.0)
					.receta(".")
					.stockActual(40)
					.stockMinimo(5)
					.tiempoEstimadoCocina(0)
					.unidadMedida("litros")
					.build();

			Producto producto2 = Producto.builder()
					.denominacion("Bebida")
					.foto("Fanta.png")
					.tipo(TipoProducto.INSUMO)
					.precioCompra(90.0)
					.precioVenta(120.0)
					.receta(".")
					.stockActual(40)
					.stockMinimo(5)
					.tiempoEstimadoCocina(0)
					.unidadMedida("litros")
					.build();
			rubro1.addProductos(producto1);
			rubro1.addProductos(producto2);
			rubroRepository.save(rubro1);



			DetallesPedido detallePedido1 = DetallesPedido.builder()
					.cantidad(1)
					.producto(producto1)
					.subtotal(150.0)
					.build();

			DetallesPedido detallePedido2 = DetallesPedido.builder()
					.cantidad(2)
					.producto(producto1)
					.subtotal(300.0)
					.build();

			Pedido pedido1 = Pedido.builder()
					.fecha("05/09/2023")
					.total(150.0)
					.estado(Estado.PREPARACION)
					.horaEstimadaEntrega("10:54")
					.tipoEnvio(TipoEnvio.RETIRA)
					.build();
			pedido1.addDetallePedido(detallePedido1);
			pedido1.addDetallePedido(detallePedido2);


			Factura factura = Factura.builder()
					.numero(1)
					.formaPago(FormaPago.EFECTIVO)
					.descuento(0.0)
					.total(150)
					.fecha("05/09/2023")
					.build();
			pedido1.setFactura(factura);
			pedidoRepository.save(pedido1);

			Cliente cliente = Cliente.builder()
					.nombre("Sophia")
					.apellido("Alvarez")
					.email("sophialvarez@gmail.com")
					.telefono("1234567897")
					.build();
			cliente.addPedido(pedido1);

			clienteRepository.save(cliente);

			Usuario usuario = Usuario.builder()
					.nombre("Sophia")
					.password("1234")
					.rol("usuario1")
					.build();
			usuario.addPedido(pedido1);

			usuarioRepository.save(usuario);

			Domicilio domicilio = Domicilio.builder()
					.calle("Suipacha")
					.numero("1233")
					.localidad("Las Heras")
					.build();
			domicilio.addPedido(pedido1);
			domicilio.setCliente(cliente);
			domicilioRepository.save(domicilio);

			domicilio.mostrarPedido();
			usuario.mostrarUsuarioYPedidos();
			rubro1.mostrarRubro();
		};
	}
}


