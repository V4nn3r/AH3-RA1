package com.example.intecap.service.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.intecap.common.CommonSvcImpl;
import com.example.intecap.models.productoModel;
import com.example.intecap.repository.productoRepository;
import com.example.intecap.service.productosService;

@Service
public class productosServiceImpl extends CommonSvcImpl<productoModel, productoRepository> implements productosService {

    @Override
    public void deleteById(int id) {
        this.repository.deleteById(id);
    }

    @Override
    public Iterable<productoModel> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<productoModel> findById(int id) {
        return this.repository.findById(id);
    }

    @Override
    public productoModel save(productoModel entity) {
        return this.repository.save(entity);
    }

    @Override
    public Iterable<productoModel> saveAll(Iterable<productoModel> entities) {
        return this.repository.saveAll(entities);
    }

    @Override
    public productoModel findByNombre(String nombre) {
        return this.repository.findByNombre(nombre);
    }
}