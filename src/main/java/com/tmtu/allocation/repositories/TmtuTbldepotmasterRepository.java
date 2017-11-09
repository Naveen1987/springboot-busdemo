package com.tmtu.allocation.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.allocation.models.Tbldepotmaster;

@Repository
public interface TmtuTbldepotmasterRepository extends PagingAndSortingRepository<Tbldepotmaster,Long>,TmtuTbldepotmasterRepositoryCustom{

}
