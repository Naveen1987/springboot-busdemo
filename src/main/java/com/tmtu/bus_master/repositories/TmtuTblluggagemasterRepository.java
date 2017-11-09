package com.tmtu.bus_master.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.bus_master.models.Tblluggagemaster;
@Repository
public interface TmtuTblluggagemasterRepository extends CrudRepository<Tblluggagemaster, Long>,TmtuTblluggagemasterRepositoryCustom {

}
