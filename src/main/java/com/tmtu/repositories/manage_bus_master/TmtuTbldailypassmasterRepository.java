package com.tmtu.repositories.manage_bus_master;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.models.manage_bus_master.Tbldailypassmaster;
@Repository
public interface TmtuTbldailypassmasterRepository extends CrudRepository<Tbldailypassmaster, Long> ,TmtuTbldailypassmasterRepositoryCustom{

}
