package Repositorios;

import Principal.Factura;
import Principal.Factura;
import java.util.ArrayList;

public class FacturaRepository implements CrudRepository<Factura, String> {

    static ArrayList<Factura> facturas;

    public FacturaRepository() {
        facturas = facturas == null ? new ArrayList<>() : facturas;
    }

    @Override
    public void create(Factura factura) {
        if(!facturas.contains(factura)) {
            facturas.add(factura);
        }
    }

    @Override
    public Factura read(String id) {
        return facturas.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null);
    }

    public ArrayList<Factura> readAll() {
        return facturas;
    }

    @Override
    public void update(Factura factura) {
        if(!facturas.contains(factura)) {
            facturas.set(facturas.indexOf(factura), factura);
        }
    }

    @Override
    public void delete(String id) {
        facturas.remove(facturas.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null));
    }
}
