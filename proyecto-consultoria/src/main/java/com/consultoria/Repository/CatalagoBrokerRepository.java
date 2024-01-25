package com.consultoria.Repository;

import com.consultoria.Entity.CatalogoBrokerEntity;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalagoBrokerRepository  extends ListCrudRepository <CatalogoBrokerEntity,Integer> {
}
