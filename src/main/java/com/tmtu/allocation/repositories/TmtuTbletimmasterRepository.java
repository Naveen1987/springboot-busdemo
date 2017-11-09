package com.tmtu.allocation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.allocation.models.Tbletimmaster;

@Repository
public interface TmtuTbletimmasterRepository extends CrudRepository<Tbletimmaster, String>,TmtuTbletimmasterRepositoryCustom {

	public Tbletimmaster findByimei(String imei);
	
	@Query("select T from Tbletimmaster T where T.status='true'")
	public List<Tbletimmaster> etimbystatus();
	
}
