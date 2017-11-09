package com.tmtu.bus_master.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.bus_master.models.Tbldailypassmaster;
@Repository
public interface TmtuTbldailypassmasterRepository extends CrudRepository<Tbldailypassmaster, Long> ,TmtuTbldailypassmasterRepositoryCustom{

}
