package com.tmtu.repositories.manage_bus_master;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tmtu.models.manage_bus_master.Tblconcessionmaster;
@Repository
public interface TmtuTblconcessionmasterRepository extends CrudRepository<Tblconcessionmaster, Long>,TmtuTblconcessionmasterRepositoryCustom {
	@Query("select l from Tblconcessionmaster l where lower(l.concessionName) like lower(concat(:concessionName,'%'))")
	public List<Tblconcessionmaster> findbyName(@Param("concessionName") String concessionName);
	@Query("select l from Tblconcessionmaster l where lower(l.concessionCode) like lower(concat(:concessioncode,'%'))")
	public List<Tblconcessionmaster> findbyCode(@Param("concessioncode")  String concessioncode);
	@Query("select l from Tblconcessionmaster l where lower(l.concessionCode) like lower(concat(:concession,'%')) or lower(l.concessionName) like lower(concat(:concession,'%'))")
	public List<Tblconcessionmaster> findConcesssion(@Param("concession") String concession);
}
