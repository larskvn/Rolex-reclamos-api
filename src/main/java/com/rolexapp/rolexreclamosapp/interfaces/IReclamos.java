package com.rolexapp.rolexreclamosapp.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rolexapp.rolexreclamosapp.models.Reclamos;

@Repository
public interface IReclamos extends CrudRepository<Reclamos, Integer> {
    public Reclamos findBynomClie(String nombre);
}
