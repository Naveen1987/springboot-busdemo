package com.tmtu.repositories.etim;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tmtu.models.etim.Tbletimmaster;

@Repository
public interface TmtuTbletimmasterRepository extends CrudRepository<Tbletimmaster, String>,TmtuTbletimmasterRepositoryCustom {

	public Tbletimmaster findByimei(String imei);
}
