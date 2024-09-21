package imb.progra3.grupo6.repository;

import imb.progra3.grupo6.entity.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	 // Método mágico para buscar clientes cuyo apellido empiece con una letra
    List<Cliente> findByApellidoStartingWith(String letra);
}
