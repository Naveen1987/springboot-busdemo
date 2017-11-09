package com.tmtu.bus_master.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tmtu.bus_master.models.Tblbusmaster;
@Repository
public interface TmtuTblbusmasterRepository extends CrudRepository<Tblbusmaster, Long>,TmtuTblbusmasterRepositoryCustom {
	@Query("select l from Tblbusmaster l where lower(l.busNo) LIKE lower(concat(:busno,'%'))")
	public List<Tblbusmaster> findByBusNo(@Param("busno") String busno);
}
