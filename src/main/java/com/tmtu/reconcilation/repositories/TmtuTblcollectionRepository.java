package com.tmtu.reconcilation.repositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.reconcilation.models.Tblcollection;

@Repository
public interface TmtuTblcollectionRepository extends PagingAndSortingRepository<Tblcollection,Long>,TmtuTblcollectionRepositoryCustom{

	
}
