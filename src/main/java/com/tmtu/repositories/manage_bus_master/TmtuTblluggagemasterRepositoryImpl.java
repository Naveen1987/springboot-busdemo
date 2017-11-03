package com.tmtu.repositories.manage_bus_master;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.models.Tbllogin;
import com.tmtu.models.manage_bus_master.Tblfarechartmaster;
import com.tmtu.models.manage_bus_master.Tblluggagemaster;
import com.tmtu.repositories.TmtuTblloginRepository;

public class TmtuTblluggagemasterRepositoryImpl implements TmtuTblluggagemasterRepositoryCustom {

	@Autowired
	TmtuTblluggagemasterRepository tmtuTblluggagemasterRepository;
	
	@Autowired
	TmtuTblfarechartmasterRepository tmtuTblfarechartmasterRepository;
	
	@Autowired
	TmtuTblloginRepository tmtuTblloginRepository;
	
	private static final Logger logger=LoggerFactory.getLogger("Luggage Master Repository");
	
	@Override
	public Tblluggagemaster save(long farechartid, long startkm, long tillkm, double amount, long createdby) {
		Tblfarechartmaster tblfarechartmaster= tmtuTblfarechartmasterRepository.findOne(farechartid);
		if(tblfarechartmaster==null) {return null;}
		
		Tbllogin tbllogin= tmtuTblloginRepository.findOne(createdby);
		if(tbllogin==null) {return null;}
	    
		Tblluggagemaster tblluggagemaster=new Tblluggagemaster();
		tblluggagemaster.setStartKm(startkm);
		tblluggagemaster.setTillKm(tillkm);
		tblluggagemaster.setCreatedBy(createdby);
		tblluggagemaster.setCreatedOn(Calendar.getInstance());
		tblluggagemaster.setTotalAmount(amount);
		tblluggagemaster.setTblfarechartmaster(tblfarechartmaster);
		//adding references
		tblfarechartmaster.addTblluggagemaster(tblluggagemaster);
		try {
			tblluggagemaster=tmtuTblluggagemasterRepository.save(tblluggagemaster);
			logger.info("New Luggage fare is added Id-"+tblluggagemaster.getLuggageid());
			return tblluggagemaster;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Tblluggagemaster save(long startkm, long tillkm, double amount, long createdby) {
		
		Tbllogin tbllogin= tmtuTblloginRepository.findOne(createdby);
		if(tbllogin==null) {return null;}
	    
		Tblluggagemaster tblluggagemaster=new Tblluggagemaster();
		tblluggagemaster.setStartKm(startkm);
		tblluggagemaster.setTillKm(tillkm);
		tblluggagemaster.setCreatedBy(createdby);
		tblluggagemaster.setCreatedOn(Calendar.getInstance());
		tblluggagemaster.setTotalAmount(amount);
		
		try {
			tblluggagemaster=tmtuTblluggagemasterRepository.save(tblluggagemaster);
			logger.info("New Luggage fare is added Id-"+tblluggagemaster.getLuggageid());
			return tblluggagemaster;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	@Override
	public Tblluggagemaster updateluggagefarechart(long luggageid, long farechartid, long modifiedby) {
		Tblluggagemaster tblluggagemaster=tmtuTblluggagemasterRepository.findOne(luggageid);
		if(tblluggagemaster==null) {return null;}
		Tblfarechartmaster tblfarechartmaster= tmtuTblfarechartmasterRepository.findOne(farechartid);
		if(tblfarechartmaster==null) {return null;}
		
		Tbllogin tbllogin= tmtuTblloginRepository.findOne(modifiedby);
		if(tbllogin==null) {return null;}
		tblluggagemaster.setLastModifiedBy(modifiedby);
		tblluggagemaster.setLastModifiedOn(Calendar.getInstance());	
		tblluggagemaster.setTblfarechartmaster(tblfarechartmaster);
		//adding references
		tblfarechartmaster.addTblluggagemaster(tblluggagemaster);
		try {
			tblluggagemaster=tmtuTblluggagemasterRepository.save(tblluggagemaster);
			logger.info("Lugger fare is updated Id-"+tblluggagemaster.getLuggageid());
			return tblluggagemaster;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Tblluggagemaster updateluggageAmount(long luggageid, double amount, long modifiedby) {
		Tblluggagemaster tblluggagemaster=tmtuTblluggagemasterRepository.findOne(luggageid);
		if(tblluggagemaster==null) {return null;}
		
		Tbllogin tbllogin= tmtuTblloginRepository.findOne(modifiedby);
		if(tbllogin==null) {return null;}
		tblluggagemaster.setTotalAmount(amount);
		tblluggagemaster.setLastModifiedBy(modifiedby);
		tblluggagemaster.setLastModifiedOn(Calendar.getInstance());	
		
		try {
			tblluggagemaster=tmtuTblluggagemasterRepository.save(tblluggagemaster);
			logger.info("Lugger fare is updated Id-"+tblluggagemaster.getLuggageid());
			return tblluggagemaster;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
