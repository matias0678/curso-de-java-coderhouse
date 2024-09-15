package matiaskarlen.preEntrega2.controller;

import matiaskarlen.preEntrega2.model.Producto;
import matiaskarlen.preEntrega2.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping(value="/listar")
    public ResponseEntity<List<Producto>> listarProductos() {
        List<Producto> productos = productoService.listarProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping(value="/buscar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getProductoById(@PathVariable(name="id") Long id) {
        Optional<Producto> producto = productoService.buscarProductoById(id);
        if(producto.isPresent()) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value="/agregar", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> agregarProducto(@RequestBody Producto producto) {
        if (producto.getNombre() == null || producto.getStock() == 0 || producto.getPrecio() == 0) {
            return ResponseEntity.internalServerError().body("Error datos faltante en la solicitud");
        }
        try {
            Producto productoGuardado = productoService.crearProducto(producto);
            return ResponseEntity.created(URI.create("")).body(productoGuardado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @DeleteMapping(value="/eliminar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id) {
        try {
            productoService.eliminarProducto(id);
            return ResponseEntity.ok("Producto eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
        }
    }

    @PutMapping(value="/cambiar", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto) {
        try {
            Producto productoActualizado = productoService.actualizarProducto(producto);
            return ResponseEntity.created(URI.create("")).body(productoActualizado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
