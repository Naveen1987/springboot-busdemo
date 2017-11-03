package com.tmtu.repositories.manage_bus_master;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.models.manage_bus_master.Tblrfidmaster;
@Repository
public interface TmtuTblrfidmasterRepository extends CrudRepository<Tblrfidmaster, Long>,TmtuTblrfidmasterRepositoryCustom {

	public Tblrfidmaster findByKeys(String keys);
}
