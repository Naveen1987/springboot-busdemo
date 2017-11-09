package com.tmtu.bus_master.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.bus_master.models.Tblroutemaster;
@Repository
public interface TmtuTblroutemasterRepository extends CrudRepository<Tblroutemaster, Long>,TmtuTblroutemasterRepositoryCustom {

	public Tblroutemaster findByrouteNumber(long routenumber);
	
}
