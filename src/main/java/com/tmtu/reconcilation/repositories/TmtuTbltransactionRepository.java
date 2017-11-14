package com.tmtu.reconcilation.repositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tmtu.reconcilation.models.Tbltransaction;

@Repository
public interface TmtuTbltransactionRepository extends PagingAndSortingRepository<Tbltransaction,Long>,TmtuTbltransactionRepositoryCustom  {

	@Query("select T from tbltransaction T where T.tblwaybill.waybillnumber=:waywillno")
	public Page<Tbltransaction> getTranactionByWayWill(@Param("waywillno") Long waywillnumber,Pageable page);
}
