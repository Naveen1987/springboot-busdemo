package com.tmtu.repositories.manage_bus_master;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.models.manage_bus_master.Tblfarechartmaster;
@Repository
public interface TmtuTblfarechartmasterRepository extends CrudRepository<Tblfarechartmaster, Long> ,TmtuTblfarechartmasterRepositoryCustom{

	
}
