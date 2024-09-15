package matiaskarlen.preEntrega2.service;

import matiaskarlen.preEntrega2.model.Producto;
import matiaskarlen.preEntrega2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> buscarProductoById(Long idProducto) {
        return productoRepository.findById(idProducto);
    }

    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public Producto actualizarProducto(Producto producto) {
        // 1. Check if product exists (optional but recommended)
        Optional<Producto> existingProduct = productoRepository.findById(producto.getId());

        if (!existingProduct.isPresent()) {
            throw new NoSuchElementException("Producto con ID " + producto.getId() + " no encontrado");
        }

        // 2. Update product details (assuming all fields are updatable)
        producto.setNombre(producto.getNombre()); // Update specific fields as needed
        producto.setPrecio(producto.getPrecio());
        producto.setStock(producto.getStock());
        // ... update other attributes

        // 3. Save the updated product
        return productoRepository.save(producto);
    }

}
