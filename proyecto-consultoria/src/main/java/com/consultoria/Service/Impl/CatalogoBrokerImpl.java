package com.consultoria.Service.Impl;

import com.consultoria.Entity.CatalogoBrokerEntity;
import com.consultoria.Persistence.ICatalagoBrokerDAO;
import com.consultoria.Service.ICatalogoBrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoBrokerImpl implements ICatalogoBrokerService {

    @Autowired
    private ICatalagoBrokerDAO iCatalagoBrokerDAO;

    @Override
    public List<CatalogoBrokerEntity> findAll() {return iCatalagoBrokerDAO.findAll();}

    @Override
    public Optional<CatalogoBrokerEntity> findById(Integer codigo) {return iCatalagoBrokerDAO.findById(codigo);}

    @Override
    public void save(CatalogoBrokerEntity catalogoBrokerEntity) { iCatalagoBrokerDAO.save(catalogoBrokerEntity);}

    @Override
    public void deleById(Integer codigo) {iCatalagoBrokerDAO.deleById(codigo);}
}
