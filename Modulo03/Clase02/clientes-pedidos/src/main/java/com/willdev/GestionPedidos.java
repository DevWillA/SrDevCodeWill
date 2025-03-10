package com.willdev;

import java.util.ArrayList;
import java.util.List;

public class GestionPedidos {

    private List<Pedidos> pedido;
    private GestionClientes clientes;

    public GestionPedidos(GestionClientes clientes) {
        this.clientes = clientes;
        this.pedido = new ArrayList<>();
    }

    public void crearPedido(String clienteId, String producto, int cantidad) throws PedidoInvalidoException {

        try {
            var cliente = clientes.buscarCliente(clienteId);
        } catch (ClienteNoEncontradoException e) {
            throw new PedidoInvalidoException("El cliente no existe");
        }

        if (clienteId.isEmpty()) {
            throw new PedidoInvalidoException("El cliente no puede estar vacio");
        }

        if (producto.isEmpty()) {
            throw new PedidoInvalidoException("El producto no puede estar vacio");
        }

        if (cantidad <= 0) {
            throw new PedidoInvalidoException("La cantidad no es valida");
        }

        var pedido = new Pedidos(clienteId, producto, cantidad);
        this.pedido.add(pedido);

    }

    public Pedidos buscarPedido(String clienteId, String producto) throws PedidoInvalidoException {

        var cliente = clientes.buscarCliente(clienteId);

        for (Pedidos pedido : this.pedido) {
            if (pedido.getClienteId().equals(clienteId) && pedido.getProducto().equals(producto)) {
                return pedido;
            }

        }
        return null;

    }
}
