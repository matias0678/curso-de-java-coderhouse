package matiaskarlen.preEntrega2.service;

import jakarta.persistence.EntityNotFoundException;
import matiaskarlen.preEntrega2.model.Cliente;
import matiaskarlen.preEntrega2.model.Producto;
import matiaskarlen.preEntrega2.model.ProductosVendidos;
import matiaskarlen.preEntrega2.model.Venta;
import matiaskarlen.preEntrega2.repository.ClienteRepository;
import matiaskarlen.preEntrega2.repository.ProductoRepository;
import matiaskarlen.preEntrega2.repository.ProductosVendidosRepository;
import matiaskarlen.preEntrega2.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProductosVendidosRepository productosVendidosRepository;


    public Venta crearVenta(Long clienteId, Long productoId, int cantidad) {
        //busca si existe el cliente con ese id y el producto
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Venta venta = new Venta();
        //obtengo la fecha en que hizo la venta
        venta.setFechaVenta(LocalDate.now());
        //calculo el total de la venta
        venta.setMontoTotal(producto.getPrecio() * cantidad);
        venta.setCliente(cliente);
        venta = ventaRepository.save(venta);

        
        ProductosVendidos productosVendidos = new ProductosVendidos();
        productosVendidos.setVenta(venta);
        productosVendidos.setProducto(producto);
        productosVendidos.setCantidad(cantidad);
        productosVendidosRepository.save(productosVendidos);

        List<ProductosVendidos> productosVendidosList = new ArrayList<>();
        productosVendidosList.add(productosVendidos);
        venta.setProductosVendidos(productosVendidosList);

        return ventaRepository.save(venta);
    }

    public Optional<Venta> buscarVentaById(Long idVenta) {
        return ventaRepository.findById(idVenta);
    }

    public List<Venta> listarVentas() {
        return ventaRepository.findAll();
    }

}
