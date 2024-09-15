package matiaskarlen.preEntrega2.controller;

import matiaskarlen.preEntrega2.model.Cliente;
import matiaskarlen.preEntrega2.model.Producto;
import matiaskarlen.preEntrega2.model.Venta;
import matiaskarlen.preEntrega2.service.VentaService;
import matiaskarlen.preEntrega2.model.ProductosVendidos;
import matiaskarlen.preEntrega2.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/venta")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @GetMapping("/listar")
    public ResponseEntity<List<Venta>> listarVentas() {
        List<Venta> ventas = ventaService.listarVentas();
        return ResponseEntity.ok(ventas);
    }

    @GetMapping(value="/buscar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getVentaById(@PathVariable(name="id") Long id) {
        Optional<Venta> venta = ventaService.buscarVentaById(id);
        if(venta.isPresent()) {
            return ResponseEntity.ok(venta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value="/crear/{clienteId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Venta agregarVenta(@PathVariable Long clienteId, @RequestBody ProductosVendidos  productosVendidos) {

        return ventaService.crearVenta(clienteId, productosVendidos.getProducto().getId(), productosVendidos.getCantidad());

    }
}
