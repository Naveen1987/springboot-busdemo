package com.tmtu.reconcilation.repositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.reconcilation.models.Tbltickets;

@Repository
public interface TmtuTblticketsRepository extends PagingAndSortingRepository<Tbltickets,Long>,TmtuTblticketsRepositoryCustom {

}
