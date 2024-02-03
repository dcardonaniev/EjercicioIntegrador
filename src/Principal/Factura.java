package Principal;

import java.util.ArrayList;

public class Factura {
    String id;
    Cliente cliente;
    ArrayList<Producto> productos;
    double costoTotal;

    public Factura(String id, Cliente cliente, ArrayList<Producto> productos) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
        this.costoTotal = calcularCostoTotal();
    }

    public double calcularCostoTotal() {
        double costo = 0;

        for(Producto producto : this.productos) {
            costo += (producto.costo * producto.cantidad);
        }

        return costo;
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    @Override
    public String toString() {
        return "Principal.Factura{" +
                "cliente=" + cliente +
                ", productos=" + productos +
                ", costoTotal=" + costoTotal +
                '}';
    }
}