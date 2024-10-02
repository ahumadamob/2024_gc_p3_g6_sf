package imb.progra3.grupo6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import imb.progra3.grupo6.entity.OrdenCompra;
import java.util.List;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long>{
     List<OrdenCompra> findByMetodoDePago(String metodoDePago);
}
