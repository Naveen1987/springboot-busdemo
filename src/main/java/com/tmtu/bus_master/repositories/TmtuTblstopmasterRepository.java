package com.tmtu.bus_master.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tmtu.bus_master.models.Tblstopmaster;
@Repository
public interface TmtuTblstopmasterRepository extends CrudRepository<Tblstopmaster, Long>,TmtuTblstopmasterRepositoryCustom {

	
	@Query("select t from tblstopmaster t where t.tblroutemaster.routeid=:routeid and lower(t.busStopCode) like lower(:busstopcode)")
	public Tblstopmaster getByrouteidandBusstopcode(@Param("routeid") Long routeid, @Param("busstopcode") String busstopcode);
}
