package imb.progra3.grupo6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import imb.progra3.grupo6.entity.DetalleCarrito;
import imb.progra3.grupo6.service.IDetalleCarritoService;

import java.util.List;

@RestController
@RequestMapping("/detallesCarrito")
public class DetalleCarritoController {

    @Autowired
    private IDetalleCarritoService detalleCarritoService;

    @GetMapping
    public List<DetalleCarrito> getAll() {
        return detalleCarritoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleCarrito> getById(@PathVariable Long id) {
        DetalleCarrito detalleCarrito = detalleCarritoService.getById(id);
        if (detalleCarrito != null) {
            return ResponseEntity.ok(detalleCarrito);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public DetalleCarrito save(@RequestBody DetalleCarrito detalleCarrito) {
        return detalleCarritoService.save(detalleCarrito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleCarrito> update(@PathVariable Long id, @RequestBody DetalleCarrito detalleCarrito) {
        if (detalleCarritoService.exists(id)) {
            detalleCarrito.setId(id);
            return ResponseEntity.ok(detalleCarritoService.save(detalleCarrito));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (detalleCarritoService.exists(id)) {
            detalleCarritoService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
