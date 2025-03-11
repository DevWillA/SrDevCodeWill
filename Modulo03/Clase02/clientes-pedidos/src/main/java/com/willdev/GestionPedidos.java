package com.willdev;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GestionPedidos {

    private static final Logger LOG = LoggerFactory.getLogger(GestionPedidos.class);

    private List<Pedidos> pedido;
    private GestionClientes clientes;

    public GestionPedidos(GestionClientes clientes) {
        LOG.debug("Creando GestionPedidos");
        this.clientes = clientes;
        this.pedido = new ArrayList<>();
    }

    public void crearPedido(String clienteId, String producto, int cantidad) throws PedidoInvalidoException {

        LOG.trace("llamando a crearPedido");
        LOG.debug("Los parametros son: clienteId={}, producto={}, cantidad={}",
                new Object[] { clienteId, producto, cantidad });

        try {
            var cliente = clientes.buscarCliente(clienteId);
            LOG.debug("El cliente del pedido es: {}", cliente);
        } catch (ClienteNoEncontradoException e) {
            LOG.warn("Cliente no encontrado {}", clienteId);
            throw new PedidoInvalidoException("El cliente no existe");
        }

        if (clienteId.isEmpty()) {
            LOG.warn("Cliente esta vacio");
            throw new PedidoInvalidoException("El cliente no puede estar vacio");
        }

        if (producto.isEmpty()) {
            LOG.warn("Pedido esta vacio");
            throw new PedidoInvalidoException("El producto no puede estar vacio");
        }

        if (cantidad <= 0) {
            LOG.warn("La cantidad no es valida o es 0");
            throw new PedidoInvalidoException("La cantidad no es valida");
        }

        var pedido = new Pedidos(clienteId, producto, cantidad);
        LOG.debug("Agregando el pedido: {}", pedido);
        this.pedido.add(pedido);
        LOG.info("Pedido Agregado con exiso {} {}",clienteId, producto);

    }

    public Pedidos buscarPedido(String clienteId, String producto) throws PedidoInvalidoException {
        LOG.trace("Ingreso a Buscar un pedido");
        LOG.debug("Los parametros son: clienteId={}, producto={}",
                new Object[] { clienteId, producto });

        var cliente = clientes.buscarCliente(clienteId);

        for (Pedidos pedido : this.pedido) {
            if (pedido.getClienteId().equals(clienteId) && pedido.getProducto().equals(producto)) {
                return pedido;
            }

        }
        throw new PedidoInvalidoException("El pedido no existe");

    }
}
