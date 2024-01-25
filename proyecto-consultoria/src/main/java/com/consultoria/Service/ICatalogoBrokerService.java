package com.consultoria.Service;

import com.consultoria.Entity.CatalogoBrokerEntity;

import java.util.List;
import java.util.Optional;

public interface ICatalogoBrokerService {

    List<CatalogoBrokerEntity> findAll();

    Optional<CatalogoBrokerEntity> findById(Integer codigo);

    void save(CatalogoBrokerEntity catalogoBrokerEntity);

    void deleById (Integer codigo);
}
