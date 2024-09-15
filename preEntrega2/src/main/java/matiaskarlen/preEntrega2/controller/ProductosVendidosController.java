package matiaskarlen.preEntrega2.controller;

import matiaskarlen.preEntrega2.model.ProductosVendidos;
import matiaskarlen.preEntrega2.service.ProductosVendidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/venta/detalle")
public class ProductosVendidosController {
    @Autowired
    private ProductosVendidosService productosVendidosService;

    @PostMapping("/agregar")
    public ResponseEntity<?> agregarDetalleVenta(@RequestBody ProductosVendidos productosVendidos) {
        try {
            ProductosVendidos detalleVenta = productosVendidosService.agregarDetalleVenta(productosVendidos);
            return ResponseEntity.created(URI.create("")).body(detalleVenta);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
