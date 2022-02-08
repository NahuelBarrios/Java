package com.example.Controller;

import com.example.dtos.ClienteIDDTO;
import com.example.dtos.ProductoDTO;
import com.example.entities.Cliente;
import com.example.entities.Producto;
import com.example.models.response.GenericResponse;
import com.example.models.response.ProductoResponse;
import com.example.service.ClienteService;
import com.example.service.ProductoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @Autowired
    private ProductoService serviceP;

    @Autowired
    private ClienteService serviceC;

    @PostMapping("/crearProducto")
    public ResponseEntity<GenericResponse> crearProducto(@RequestBody ProductoDTO productoDTO) {

        GenericResponse rta = new GenericResponse();

        Producto nuevoProducto = serviceP.crearProducto(productoDTO);

        if (nuevoProducto != null) {
            rta.id = nuevoProducto.getIdProducto();
            rta.isOk = true;
            rta.message = "Producto creado correctamente";
            return ResponseEntity.ok(rta);
        } else {
            rta.isOk = false;
            rta.message = "Producto NO ha sido creado correctamente";
            return ResponseEntity.badRequest().body(rta);
        }

    }

    @PostMapping("/agregarCliente/{idProducto}")
    public ResponseEntity<GenericResponse> agregarClienteProducto(@PathVariable Integer idProducto, @RequestBody ClienteIDDTO clienteIdDTO) {
        GenericResponse rta = new GenericResponse();

        Producto productoEditado = serviceP.idBuscarProducto(idProducto);

        if (productoEditado.getIdProducto() != null) {
            List<Cliente> listaClientes = productoEditado.getCliente();

            for (Cliente aux : listaClientes) {
                if (aux.getIdCliente().equals(clienteIdDTO.getIdCliente())) {
                    rta.isOk = false;
                    rta.message = "El cliente ya esta agregado en la lista";
                    return ResponseEntity.badRequest().body(rta);
                }
            }

            listaClientes.add(serviceC.idBuscarCliente(clienteIdDTO.getIdCliente()));

            productoEditado.setCliente(listaClientes);
            serviceP.guardar(productoEditado);
            rta.isOk = true;
            rta.message = "Cliente agregado a la lista Correctamente";
            return ResponseEntity.ok(rta);

        } else {
            rta.isOk = false;
            rta.message = "El cliente ya esta agregado en la lista";
            return ResponseEntity.badRequest().body(rta);
        }
    }

    @GetMapping("/listaProductos")
    public ResponseEntity<List<ProductoResponse>> listarProductos()
    {
        List<Producto> listaProducto = serviceP.listarProducto();
        List<ProductoResponse> listaProductoResponse = new ArrayList<>();
        
        if(listaProducto != null)
        {
            for(Producto producto: listaProducto)
            {
                ProductoResponse productoResponse = new ProductoResponse(producto.getNombreProducto(),producto.getCliente());
                listaProductoResponse.add(productoResponse);
            }
            return ResponseEntity.ok(listaProductoResponse);
        }else{
            return ResponseEntity.noContent().build();
        }
        
    }
    
    @GetMapping(value="/produto", params="name")
    public ResponseEntity<List<Producto>> listarProductoNombre(@RequestParam String nombreProducto)
    {
        List<Producto> listaProducto = serviceP.nombreBuscarProducto(nombreProducto);
        
        if(listaProducto.isEmpty())
        {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(listaProducto);
    }
    
}
