package matiaskarlen.preEntrega2.service;

import matiaskarlen.preEntrega2.model.ProductosVendidos;
import matiaskarlen.preEntrega2.model.Venta;
import matiaskarlen.preEntrega2.repository.ProductosVendidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosVendidosService {
    @Autowired
    private ProductosVendidosRepository prodVendidosRepository;

    public ProductosVendidos agregarDetalleVenta(ProductosVendidos productosVendidos){
        return prodVendidosRepository.save(productosVendidos);
    }

}
