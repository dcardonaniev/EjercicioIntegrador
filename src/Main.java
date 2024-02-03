import Principal.Cliente;
import Principal.Factura;
import Principal.Producto;
import Repositorios.ClienteRepository;
import Repositorios.FacturaRepository;
import Repositorios.ProductoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ClienteRepository repositorioClientes;
    static ProductoRepository repositorioProductos;
    static FacturaRepository repositorioFacturas;

    public static void main(String[] args) {
        repositorioClientes = new ClienteRepository();
        repositorioProductos = new ProductoRepository();
        repositorioFacturas = new FacturaRepository();

        Cliente cliente1 = new Cliente(
                "1001",
                "David",
                "Cardona"
        ), cliente2 = new Cliente(
                "1002",
                "David",
                "Madrid"
        ), cliente3 = new Cliente(
                "1003",
                "Batman",
                "Test"
        );

        repositorioClientes.create(cliente1);
        repositorioClientes.create(cliente2);
        repositorioClientes.create(cliente3);

        System.out.println("================= CLIENTES =================");
        repositorioClientes.readAll().forEach(System.out::println);

        System.out.println("\n================= ELIMINADO CLIENTE =================");
        repositorioClientes.delete("1001");
        repositorioClientes.readAll().forEach(System.out::println);

        Scanner S = new Scanner(System.in);
        String inputDni = S.nextLine();

        Cliente clienteBuscado = repositorioClientes.read(inputDni);
        System.out.println("\n================= INFO CLIENTE =================");
        System.out.println(clienteBuscado != null ? clienteBuscado : "Principal.Cliente no existente.");

        Producto producto1 = new Producto(
                1,
                "Manzana",
                1,
                10
        ), producto2 = new Producto(
                2,
                "Pera",
                2,
                15
        );

        Factura factura1 = new Factura(
                "1",
                cliente1,
                new ArrayList<>(List.of(producto1, producto2))
        );

        repositorioFacturas.create(factura1);
        System.out.println("\n================= INFO FACTURAS =================");
        repositorioFacturas.readAll().forEach(System.out::println);
    }
}

