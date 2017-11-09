package com.tmtu.bus_master.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.bus_master.models.Tblrfidmaster;
@Repository
public interface TmtuTblrfidmasterRepository extends CrudRepository<Tblrfidmaster, Long>,TmtuTblrfidmasterRepositoryCustom {

	public Tblrfidmaster findByKeys(String keys);
}
