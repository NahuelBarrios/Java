package com.catalogo.controller;

import com.catalogo.dtos.ProductoDTO;
import com.catalogo.entities.Producto;
import com.catalogo.models.response.GenericResponse;
import com.catalogo.models.response.ProductoResponse;
import com.catalogo.service.ProductoServicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoServicio servicioP;

    @PostMapping("/crearProducto")
    public ResponseEntity<GenericResponse> agregar(@RequestBody ProductoDTO productoDTO, BindingResult results) {

        GenericResponse rta = new GenericResponse();

        if (results.hasErrors()) {
            rta.isOk = false;
            rta.message = "Producto NO creado correctamente";

            return ResponseEntity.badRequest().body(rta);
        } else {
            Producto producto = servicioP.crearNuevoProducto(productoDTO);

            rta.id = producto.getIdProducto();
            rta.isOk = true;
            rta.message = "SE creo correctamente el producto";

            return ResponseEntity.ok(rta);
        }
    }

    @PutMapping("/editarProducto/{idProducto}")
    public ResponseEntity<GenericResponse> editar(@RequestBody ProductoDTO productoDTO, @PathVariable Long idProducto) {
        GenericResponse rta = new GenericResponse();

        Producto producto = servicioP.buscarIdProducto(idProducto);

        if (producto.getIdProducto() != null) {
            producto.setImagenProducto(productoDTO.getImagenProducto());
            producto.setNombreProducto(productoDTO.getNombreProducto());
            producto.setPrecioProducto(productoDTO.getPrecioProducto());
            producto.setCreationDate(productoDTO.getCreationDate());

            rta.isOk = true;
            rta.message = "El producto se edito correctamente";
            servicioP.guardar(producto);
            return ResponseEntity.ok(rta);
        } else {
            rta.isOk = false;
            rta.message = "El producto no se edito correctamente, ya que el id ingresado no existe";
            return ResponseEntity.badRequest().body(rta);
        }
    }

    @DeleteMapping("/eliminarProducto/{idProducto}")
    public ResponseEntity<GenericResponse> eliminar(@PathVariable Long idProducto) {
        GenericResponse rta = new GenericResponse();

        Producto producto = servicioP.buscarIdProducto(idProducto);

        if (producto.getIdProducto() != null) {
            rta.isOk = true;
            rta.message = "El producto se elimino correctamente";
            servicioP.borrar(producto);
            return ResponseEntity.ok(rta);
        } else {
            rta.isOk = false;
            rta.message = "El producto no se elimino correctamente, ya que el id ingresado no existe";
            return ResponseEntity.badRequest().body(rta);
        }
    }

    @GetMapping("/lista")
    public ResponseEntity<List<ProductoResponse>> listarProductos() {
        List<Producto> listaProductos = servicioP.listarProductos();
        List<ProductoResponse> listaProductoResponse = new ArrayList<>();

        for (Producto producto : listaProductos) {
            ProductoResponse productoResponse = new ProductoResponse(producto.getImagenProducto(), producto.getNombreProducto(), producto.getPrecioProducto(), producto.getCreationDate());
            listaProductoResponse.add(productoResponse);
        }
        return ResponseEntity.ok(listaProductoResponse);
    }

    @GetMapping(value = "/lista", params = "name")
    public ResponseEntity<List<Producto>> listarProductosPorNombre(@RequestParam String name) {
        List<Producto> listaProductos = servicioP.buscarNombreProducto(name);

        if (listaProductos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaProductos);
    }

}
