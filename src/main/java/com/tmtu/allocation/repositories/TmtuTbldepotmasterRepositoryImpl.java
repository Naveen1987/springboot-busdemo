package com.tmtu.allocation.repositories;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.admin.models.Tbllogin;
import com.tmtu.admin.repositories.TmtuTblloginRepository;
import com.tmtu.allocation.models.Tbldepotmaster;

public class TmtuTbldepotmasterRepositoryImpl implements TmtuTbldepotmasterRepositoryCustom  {

	@Autowired
	TmtuTbldepotmasterRepository tmtuTbldepotmasterRepository;
	@Autowired
	TmtuTblloginRepository tmtuTblloginRepository;
	
	private static final Logger logger=LoggerFactory.getLogger("Depot Master Repository"); 
	
	@Override
	public Tbldepotmaster save(String depotName, String depotcode, Long createdBy) {
		Tbllogin tbllogin=tmtuTblloginRepository.findOne(createdBy);
		if(tbllogin==null) {
			logger.error("Created by is not exists Id="+createdBy);
			return null;
		}
		Tbldepotmaster tbldepotmaster=new Tbldepotmaster();
		tbldepotmaster.setCreatedBy(createdBy);
		tbldepotmaster.setDepotcode(depotcode);
		tbldepotmaster.setDepotName(depotName);
		tbldepotmaster.setCreatedOn(Calendar.getInstance());
		try {
			tbldepotmaster=tmtuTbldepotmasterRepository.save(tbldepotmaster);
			logger.info("Depot created and Id is:"+tbldepotmaster.getDepotId());
			return tbldepotmaster;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return null;
	}

}
