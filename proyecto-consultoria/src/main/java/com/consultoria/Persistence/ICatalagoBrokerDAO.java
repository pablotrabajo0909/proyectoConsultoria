package com.consultoria.Persistence;

import com.consultoria.Entity.CatalogoBrokerEntity;

import java.util.List;
import java.util.Optional;

public interface ICatalagoBrokerDAO {


    List<CatalogoBrokerEntity> findAll();

    Optional<CatalogoBrokerEntity> findById(Integer codigo);

    void save(CatalogoBrokerEntity catalogoBrokerEntity);

    void deleById (Integer codigo);
}

