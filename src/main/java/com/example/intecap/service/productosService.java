package com.example.intecap.service;

import java.util.Optional;

import com.example.intecap.common.CommonSvc;
import com.example.intecap.models.productoModel;

public interface productosService extends CommonSvc<productoModel> {

    @Override
    public Iterable<productoModel> findAll();

    @Override
    public Optional<productoModel> findById(int id);

    public productoModel findByNombre(String nombre);

    @Override
    public productoModel save(productoModel entity);

    @Override
    public void deleteById(int id);

    @Override
    Iterable<productoModel> saveAll(Iterable<productoModel> entities);
}