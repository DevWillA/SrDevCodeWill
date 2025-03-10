package com.willdev;

import org.apache.logging.log4j.LogManager;

public class Main {
    public static void main(String[] args) {

        var log =  LogManager.getLogger(Main.class);

        log.info("Iniciando la aplicacion");

        var clientes = new GestionClientes();
        log.debug("Creando clientes 1");
        clientes.registrarCliente("1", "William");
        log.info("Cliente 1 registrado");
        log.debug("Creando clientes 2");
        clientes.registrarCliente("2", "Yuly");
        log.info("Cliente 2 registrado");
        log.debug("Creando clientes 3");
        clientes.registrarCliente("3", "Patricia");
        log.info("Cliente 3 registrado");


        var pedidos = new GestionPedidos(clientes);
        try {
            log.debug("Creando pedido 1");
            pedidos.crearPedido("1", "Laptop", 2);
            log.debug("Creando pedido 2");
            pedidos.crearPedido("2", "Mouse", 1);
            log.debug("Creando pedido 3");
            pedidos.crearPedido("3", "Teclado", 1);
        } catch (PedidoInvalidoException e) {
            log.warn("Error al gestionar el pedido", e);
            System.err.println("Error al gestionar el pedido" +e.getMessage());
        }

        System.out.println("Gracias por usar nuestro servicio");

        log.info("Finalizando la aplicacion");
    }
}