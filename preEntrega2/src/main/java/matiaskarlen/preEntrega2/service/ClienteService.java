package matiaskarlen.preEntrega2.service;

import matiaskarlen.preEntrega2.model.Cliente;
import matiaskarlen.preEntrega2.model.Producto;
import matiaskarlen.preEntrega2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> buscarClienteById(Long idCiente) {
        return clienteRepository.findById(idCiente);
    }

    // Nuevo método para obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public Cliente actualizarCliente(Cliente cliente, Long idCliente) {
        Optional<Cliente> clienteExistente = clienteRepository.findById(idCliente);

        if(!clienteExistente.isPresent()) {
            throw new NoSuchElementException(("Cliente con ID"+ cliente.getId() + " no encontrado"));
        }

        cliente.setNombre(cliente.getNombre());
        cliente.setDni(cliente.getDni());
        cliente.setCelular(cliente.getCelular());
        cliente.setMail(cliente.getMail());

        return clienteRepository.save(cliente);
    }

}
