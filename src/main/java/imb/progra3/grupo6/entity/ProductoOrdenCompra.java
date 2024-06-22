package imb.progra3.grupo6.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
public class ProductoOrdenCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "orden_compra_id")
    private OrdenCompra ordenCompra;

    // Constructors, getters and setters
    public ProductoOrdenCompra() {}

    public ProductoOrdenCompra(Producto producto, OrdenCompra ordenCompra) {
        this.producto = producto;
        this.ordenCompra = ordenCompra;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }
}
