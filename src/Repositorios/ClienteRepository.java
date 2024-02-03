package Repositorios;

import Principal.Cliente;
import java.util.ArrayList;

public class ClienteRepository implements CrudRepository<Cliente, String> {

    static ArrayList<Cliente> clientes;

    public ClienteRepository() {
        clientes = clientes == null ? new ArrayList<>() : clientes;
    }

    @Override
    public void create(Cliente cliente) {
        if(!clientes.contains(cliente)) {
            clientes.add(cliente);
        }
    }

    @Override
    public Cliente read(String dni) {
        return clientes.stream().filter(x -> x.getDni().equals(dni)).findFirst().orElse(null);
    }

    public ArrayList<Cliente> readAll() {
        return clientes;
    }

    @Override
    public void update(Cliente cliente) {
        if(!clientes.contains(cliente)) {
            clientes.set(clientes.indexOf(cliente), cliente);
        }
    }

    @Override
    public void delete(String dni) {
        clientes.remove(clientes.stream().filter(x -> x.getDni().equals(dni)).findFirst().orElse(null));
    }
}
