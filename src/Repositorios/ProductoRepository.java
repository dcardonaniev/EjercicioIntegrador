package Repositorios;

import Principal.Producto;
import java.util.ArrayList;

public class ProductoRepository implements CrudRepository<Producto, Integer> {

    static ArrayList<Producto> productos;

    public ProductoRepository() {
        productos = productos == null ? new ArrayList<>() : productos;
    }

    @Override
    public void create(Producto producto) {
        if(!productos.contains(producto)) {
            productos.add(producto);
        }
    }

    @Override
    public Producto read(Integer codigo) {
        return productos.stream().filter(x -> x.getCodigo() == codigo).findFirst().orElse(null);
    }

    public ArrayList<Producto> readAll() {
        return productos;
    }

    @Override
    public void update(Producto producto) {
        if(!productos.contains(producto)) {
            productos.set(productos.indexOf(producto), producto);
        }
    }

    @Override
    public void delete(Integer codigo) {
        productos.remove(productos.stream().filter(x -> x.getCodigo() == codigo).findFirst().orElse(null));
    }
}
