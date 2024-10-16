package imb.progra3.grupo6.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductoOrdenCompra extends BaseEntity{

  

    @ManyToOne
    @JoinColumn(name = "producto_id")
    @JsonBackReference
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "orden_compra_id")
    @JsonBackReference
    private OrdenCompra ordenCompra;

    // Constructors, getters and setters
    public ProductoOrdenCompra() {}

    public ProductoOrdenCompra(Producto producto, OrdenCompra ordenCompra) {
        this.producto = producto;
        this.ordenCompra = ordenCompra;
    }

    // Getters and Setters
 

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
