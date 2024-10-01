package com.example.intecap.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.intecap.models.productoModel;

public interface productoRepository extends CrudRepository<productoModel, Object> {

    // funcion para buscar por nombre
    public productoModel findByNombre(String nombre);
}