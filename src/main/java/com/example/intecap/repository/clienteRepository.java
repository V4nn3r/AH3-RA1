package com.example.intecap.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.intecap.models.clientesModel;

public interface clienteRepository extends CrudRepository<clientesModel, Object> {

    // funcion para buscar por nombre
    public clientesModel findByNombre(String nombre);
}