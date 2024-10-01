package com.example.intecap.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.intecap.models.productoModel;
import com.example.intecap.service.productosService;

@RestController
@RequestMapping("/productos")
@CrossOrigin
public class productosController {

    @Autowired
    private productosService productosService;

    @GetMapping("/listar")
    public Iterable<productoModel> getProductos() {
        return this.productosService.findAll();
    }

    @PostMapping("/guardar")
    public ResponseEntity<String> saveProductos(@RequestBody productoModel entity) {

        try {
            this.productosService.save(entity);
            return ResponseEntity.ok("Producto guardado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar el producto");
        }
    }

    @DeleteMapping("/eliminar/{idProducto}")
    public ResponseEntity<String> deleteProductos(@PathVariable int idProducto) {
        try {
            this.productosService.deleteById(idProducto);
            return ResponseEntity.ok("Producto eliminado correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al eliminar el producto");
        }
    }

    @PutMapping("/actualizar/{idProducto}")
    public ResponseEntity<String> updateProductos(@PathVariable int idProducto, @RequestBody productoModel entity) {
        try {
            // Buscamos el id del producto
            Optional<productoModel> existingProducto = this.productosService.findById(idProducto);

            if (existingProducto.isPresent()) {
                productoModel productoToUpdate = existingProducto.get();

                productoToUpdate.setNombre(entity.getNombre());
                productoToUpdate.setPrecio(entity.getPrecio());
                productoToUpdate.setStock(entity.getStock());

                // Guardamos los cambios
                this.productosService.save(productoToUpdate);
                this.productosService.save(entity);
                return ResponseEntity.ok("Producto actualizado correctamente");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar el producto");
        }
    }
}