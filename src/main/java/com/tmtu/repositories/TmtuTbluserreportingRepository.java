package com.tmtu.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tmtu.models.Tbluserreporting;

@Repository
public interface TmtuTbluserreportingRepository extends CrudRepository<Tbluserreporting, Long>,TmtuTbluserreportingRepositoryCustom{

	@Query("select T from tbluserreporting T where T.loginId.tblloginId=:loginid")
	public Tbluserreporting getReportingManagerByLoginId(@Param("loginid") long loginid);
}
