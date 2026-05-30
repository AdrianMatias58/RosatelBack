package com.rosalte.spring.api_rosatel.modules.model.orden;

import com.rosalte.spring.api_rosatel.modules.model.producto.PaquetesModel;
import com.rosalte.spring.api_rosatel.modules.model.producto.ProductosModel;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "detalle_pedido")
public class DetallePedidoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private PedidosModel pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductosModel producto;

    @ManyToOne
    @JoinColumn(name = "id_paquete")
    private PaquetesModel paquete;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal igv;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public PedidosModel getPedido() { return pedido; }
    public void setPedido(PedidosModel pedido) { this.pedido = pedido; }
    public ProductosModel getProducto() { return producto; }
    public void setProducto(ProductosModel producto) { this.producto = producto; }
    public PaquetesModel getPaquete() { return paquete; }
    public void setPaquete(PaquetesModel paquete) { this.paquete = paquete; }
    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }
    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
    public BigDecimal getIgv() { return igv; }
    public void setIgv(BigDecimal igv) { this.igv = igv; }
    public LocalDateTime getFechaPago() { return fechaPago; }
    public void setFechaPago(LocalDateTime fechaPago) { this.fechaPago = fechaPago; }
}