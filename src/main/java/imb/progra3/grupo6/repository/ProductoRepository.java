package imb.progra3.grupo6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import imb.progra3.grupo6.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
