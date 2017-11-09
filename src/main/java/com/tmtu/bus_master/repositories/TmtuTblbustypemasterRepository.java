package com.tmtu.bus_master.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.bus_master.models.Tblbustypemaster;
@Repository
public interface TmtuTblbustypemasterRepository extends CrudRepository<Tblbustypemaster, Long> ,TmtuTblbustypemasterRepositoryCustom{

	
}
