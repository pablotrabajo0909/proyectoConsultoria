package com.consultoria.Persistence.Impl;

import com.consultoria.Entity.CatalogoBrokerEntity;
import com.consultoria.Persistence.ICatalagoBrokerDAO;
import com.consultoria.Repository.CatalagoBrokerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CatalagoBrokerDAOImpl implements ICatalagoBrokerDAO {

@Autowired
    private CatalagoBrokerRepository catalagoBrokerRepository;

    @Override
    public List<CatalogoBrokerEntity> findAll() { return (List<CatalogoBrokerEntity>) catalagoBrokerRepository.findAll();
    }

    @Override
    public Optional<CatalogoBrokerEntity> findById(Integer codigo) {return catalagoBrokerRepository.findById(codigo);
    }

    @Override
    public void save(CatalogoBrokerEntity catalogoBrokerEntity) {catalagoBrokerRepository.save(catalogoBrokerEntity);}

    @Override
    public void deleById(Integer codigo) {catalagoBrokerRepository.deleteById(codigo);}
}
