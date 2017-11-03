package com.tmtu.repositories.manage_bus_master;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.models.manage_bus_master.Tblluggagemaster;
@Repository
public interface TmtuTblluggagemasterRepository extends CrudRepository<Tblluggagemaster, Long>,TmtuTblluggagemasterRepositoryCustom {

}
