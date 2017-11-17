package com.tmtu.allocation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.allocation.models.Tbldutyallocation;

@Repository
public interface TmtuTbldutyallocationRepository extends PagingAndSortingRepository<Tbldutyallocation,Long>,TmtuTbldutyallocationRepositoryCustom {

	@Query("Select T from Tbldutyallocation T where T.status=1")
	public Page<Tbldutyallocation> findAllWithActive(Pageable page);
	@Query("Select T from Tbldutyallocation T where T.status=2")
	public Page<Tbldutyallocation> findAllWithCancel(Pageable page);
}
