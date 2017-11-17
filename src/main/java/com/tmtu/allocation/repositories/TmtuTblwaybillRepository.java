package com.tmtu.allocation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.allocation.models.Tblwaybill;


@Repository
public interface TmtuTblwaybillRepository extends PagingAndSortingRepository<Tblwaybill,Long>,TmtuTblwaybillRepositoryCustom {

	
	@Query("select T from tblwaybill T where T.status=1 and T.tbldutyallocation.status=1")
	public Page<Tblwaybill> findAllActiveWayWill(Pageable page);
	
	@Query("select T from tblwaybill T where T.status=2 and T.tbldutyallocation.status=2")
	public Page<Tblwaybill> findAllCancelWayWill(Pageable page);
	
	@Query("select T from tblwaybill T where T.status=3 and T.tbldutyallocation.status=3")
	public Page<Tblwaybill> findAllcompleteWayWill(Pageable page);
	
}
