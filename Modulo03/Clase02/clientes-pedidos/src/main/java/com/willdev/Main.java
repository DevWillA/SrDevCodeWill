package com.willdev;

public class Main {
    public static void main(String[] args) {

        var clientes = new GestionClientes();
        clientes.registrarCliente("1", "William");
        clientes.registrarCliente("2", "Yuly");
        clientes.registrarCliente("3", "Patricia");


        var pedidos = new GestionPedidos(clientes);
        try {
            pedidos.crearPedido("1", "Laptop", 2);
            pedidos.crearPedido("2", "Mouse", 1);
            pedidos.crearPedido("3", "Teclado", 1);
        } catch (PedidoInvalidoException e) {
            System.err.println("Error al gestionar el pedido" +e.getMessage());
        }

        System.out.println("Gracias por usar nuestro servicio");
    }
}