package matiaskarlen.preEntrega2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="ventas")
@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="fecha")
    private String fechaVenta;

//    @Column(name="fecha")
//    private String fecha;

    @Column(name="monto_total")
    private double montoTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente_id")
    @JsonIgnore
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductosVendidos> productosVendidos;

    public Venta() {
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = String.valueOf(fechaVenta);
    }

    public long getId() {
        return id;
    }

//    public String getFecha() {
//        return fecha;
//    }
//
//    public void setFecha(String fecha) {
//        this.fecha = fecha;
//    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProductosVendidos> getProductosVendidos() {return productosVendidos;}

    public void setProductosVendidos(List<ProductosVendidos> productosVendidos) {this.productosVendidos = productosVendidos;}


}
