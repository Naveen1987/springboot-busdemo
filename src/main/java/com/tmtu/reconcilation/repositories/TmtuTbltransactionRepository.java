package com.tmtu.reconcilation.repositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.reconcilation.models.Tbltransaction;

@Repository
public interface TmtuTbltransactionRepository extends PagingAndSortingRepository<Tbltransaction,Long>,TmtuTbltransactionRepositoryCustom  {

}
