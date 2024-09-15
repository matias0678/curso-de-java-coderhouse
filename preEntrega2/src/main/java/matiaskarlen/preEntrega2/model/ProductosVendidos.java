package matiaskarlen.preEntrega2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="productos_vendidos")
@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class ProductosVendidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="cantidad")
    private int cantidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="producto_id")
    private Producto producto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="venta_id")
    @JsonIgnore
    private Venta venta;

    public ProductosVendidos() {
    }

    public ProductosVendidos(long id, int cantidad, Producto producto, Venta venta) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.venta = venta;
    }

    public long getId() {
        return id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductosVendidos that = (ProductosVendidos) o;
        return id == that.id && cantidad == that.cantidad && Objects.equals(producto, that.producto) && Objects.equals(venta, that.venta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidad, producto, venta);
    }


}