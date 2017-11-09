package com.tmtu.allocation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.allocation.models.Tblwaybill;


@Repository
public interface TmtuTblwaybillRepository extends PagingAndSortingRepository<Tblwaybill,Long>,TmtuTblwaybillRepositoryCustom {

	
	@Query("select T from tblwaybill T where T.status=true and T.tbldutyallocation.status=true")
	public Page<Tblwaybill> findAllActiveWayWill(Pageable page);
	
	@Query("select T from tblwaybill T where T.status=false and T.tbldutyallocation.status=false")
	public Page<Tblwaybill> findAllCancelWayWill(Pageable page);
}
