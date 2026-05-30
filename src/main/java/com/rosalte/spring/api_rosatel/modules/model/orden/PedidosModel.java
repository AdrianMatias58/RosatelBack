package com.rosalte.spring.api_rosatel.modules.model.orden;
import com.rosalte.spring.api_rosatel.modules.model.usuario.ClientesModel;
import com.rosalte.spring.api_rosatel.modules.model.usuario.DireccionesModel;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class PedidosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private ClientesModel cliente;

    @ManyToOne
    @JoinColumn(name = "id_direccion", nullable = false)
    private DireccionesModel direccion;

    @ManyToOne
    @JoinColumn(name = "id_cupon")
    private CuponesModel cupon;

    @Column(name = "cod_pedido", nullable = false, unique = true, length = 10)
    private String codPedido;

    @Column(name = "metodo_pago", nullable = false, length = 12)
    private String metodoPago;

    @Column(nullable = false, length = 10)
    private String estado;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Column(name = "fecha_entrega", nullable = false)
    private LocalDate fechaEntrega;

    @Column(name = "horario_entrega", nullable = false, length = 30)
    private String horarioEntrega;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ClientesModel getCliente() { return cliente; }
    public void setCliente(ClientesModel cliente) { this.cliente = cliente; }
    public DireccionesModel getDireccion() { return direccion; }
    public void setDireccion(DireccionesModel direccion) { this.direccion = direccion; }
    public CuponesModel getCupon() { return cupon; }
    public void setCupon(CuponesModel cupon) { this.cupon = cupon; }
    public String getCodPedido() { return codPedido; }
    public void setCodPedido(String codPedido) { this.codPedido = codPedido; }
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
    public LocalDate getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(LocalDate fechaEntrega) { this.fechaEntrega = fechaEntrega; }
    public String getHorarioEntrega() { return horarioEntrega; }
    public void setHorarioEntrega(String horarioEntrega) { this.horarioEntrega = horarioEntrega; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}