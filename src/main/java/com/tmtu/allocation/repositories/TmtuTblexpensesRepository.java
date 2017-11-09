package com.tmtu.allocation.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.allocation.models.Tblexpenses;

@Repository
public interface TmtuTblexpensesRepository extends PagingAndSortingRepository<Tblexpenses,Long>,TmtuTblexpensesRepositoryCustom{

}
