package matiaskarlen.preEntrega2.repository;

import matiaskarlen.preEntrega2.model.ProductosVendidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosVendidosRepository extends JpaRepository<ProductosVendidos, Long> {
}
