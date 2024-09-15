package matiaskarlen.preEntrega2.controller;

import matiaskarlen.preEntrega2.model.Cliente;
import matiaskarlen.preEntrega2.model.Producto;
import matiaskarlen.preEntrega2.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/listar")
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        List<Cliente> clientes = clienteService.obtenerTodosLosClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping(value = "/buscar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getClienteById(@PathVariable(name="id") Long id) {
        Optional<Cliente> cliente = clienteService.buscarClienteById(id);
        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value="/agregar",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> guardarCliente(@RequestBody Cliente cliente) {
        //validaciones de los campos
        if (cliente.getNombre() == null || cliente.getCelular() == 0 || cliente.getMail() == null || cliente.getDni() == 0) {
            return ResponseEntity.internalServerError().body("Error datos faltante en la solicitud");
        }
        try {
            Cliente clienteGuardado = clienteService.crearCliente(cliente);
            return ResponseEntity.created(URI.create("")).body(clienteGuardado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @DeleteMapping(value="/eliminar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> eliminarCliente(@PathVariable Long id) {
        try {
            clienteService.eliminarCliente(id);
            return ResponseEntity.ok("Cliente eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado");
        }
    }

    @PutMapping(value="/cambiar/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente,@PathVariable(name="id") Long id) {
        try {
            Cliente clienteActualizado = clienteService.actualizarCliente(cliente, id);
            return ResponseEntity.created(URI.create("")).body(clienteActualizado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }

}
