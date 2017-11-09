package com.tmtu.allocation.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.allocation.models.TblshiftMaster;

@Repository
public interface TmtuTblshiftMasterRepository extends PagingAndSortingRepository<TblshiftMaster,Long>,TmtuTblshiftMasterRepositoryCustom {


}
