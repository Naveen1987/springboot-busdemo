package com.tmtu.bus_master.repositories;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.admin.models.Tbllogin;
import com.tmtu.admin.repositories.TmtuTblloginRepository;
import com.tmtu.bus_master.models.Tblbustypemaster;
import com.tmtu.bus_master.models.Tblconcessionmaster;
import com.tmtu.bus_master.models.Tblfarechartmaster;

public class TmtuTblfarechartmasterRepositoryImpl  implements TmtuTblfarechartmasterRepositoryCustom{

	@Autowired
	TmtuTblfarechartmasterRepository tmtuTblfarechartmasterRepository;
	@Autowired
	TmtuTblbustypemasterRepository tmtuTblbustypemasterRepository;
	@Autowired
	TmtuTblconcessionmasterRepository tmtuTblconcessionmasterRepository;
	@Autowired
	TmtuTblloginRepository tmtuTblloginRepository; 
	
	private static final Logger logger=LoggerFactory.getLogger("Fare Chart Master Repository");
	
	@Override
	public Tblfarechartmaster save(long startkm,long tillkm,double amount,long bustypeid,long concessionid,long createdby) {
		Tblbustypemaster tblbustypemaster= tmtuTblbustypemasterRepository.findOne(bustypeid);
		if(tblbustypemaster==null) { return null; }
		Tblconcessionmaster tblconcessionmaster=  tmtuTblconcessionmasterRepository.findOne(concessionid);
		if(tblconcessionmaster==null) {return null;}
		Tbllogin tbllogin=  tmtuTblloginRepository.findOne(createdby);
		if(tbllogin==null) {return null;}
		Tblfarechartmaster tblfarechartmaster=new Tblfarechartmaster();
		tblfarechartmaster.setStartKm(startkm);
		tblfarechartmaster.setTillKm(tillkm);
		tblfarechartmaster.setCreatedBy(createdby);
		tblfarechartmaster.setCreatedOn(Calendar.getInstance());
		tblfarechartmaster.setTotalAmount(amount);
		tblfarechartmaster.setTlbbustypemaster(tblbustypemaster);
		tblfarechartmaster.setTblconcessionmaster(tblconcessionmaster);
		//add reference
		tblbustypemaster.addTblfarechartmaster(tblfarechartmaster);
		tblconcessionmaster.addTblfarechartmaster(tblfarechartmaster);
		try {
			tblfarechartmaster=tmtuTblfarechartmasterRepository.save(tblfarechartmaster);
			logger.info("New Fare Chart is created Id-"+tblfarechartmaster.getFarechartid());
			return tblfarechartmaster;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}


	@Override
	public Tblfarechartmaster updatebusType(long farechartid, long bustypeid, long modifiedby) {
		
		Tblfarechartmaster tblfarechartmaster=tmtuTblfarechartmasterRepository.findOne(farechartid);
		if(tblfarechartmaster==null) {return null;}
		Tblbustypemaster tblbustypemaster= tmtuTblbustypemasterRepository.findOne(bustypeid);
		if(tblbustypemaster==null) { return null; }
		Tbllogin tbllogin=  tmtuTblloginRepository.findOne(modifiedby);
		if(tbllogin==null) {return null;}

		
		tblfarechartmaster.setLastModifiedBy(modifiedby);
		tblfarechartmaster.setLastModifiedOn(Calendar.getInstance());
		tblfarechartmaster.setTlbbustypemaster(tblbustypemaster);
		
		//add reference
		tblbustypemaster.addTblfarechartmaster(tblfarechartmaster);
		
		try {
			tblfarechartmaster=tmtuTblfarechartmasterRepository.save(tblfarechartmaster);
			logger.info("Updated Fare Chart is saved Id-"+tblfarechartmaster.getFarechartid());
			return tblfarechartmaster;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}


	@Override
	public Tblfarechartmaster updateStartTillKm(long farechartid, long startkm, long tillkm, long modifiedby) {
		Tblfarechartmaster tblfarechartmaster=tmtuTblfarechartmasterRepository.findOne(farechartid);
		if(tblfarechartmaster==null) {return null;}
		
		Tbllogin tbllogin=  tmtuTblloginRepository.findOne(modifiedby);
		if(tbllogin==null) {return null;}
		
		tblfarechartmaster.setStartKm(startkm);
		tblfarechartmaster.setTillKm(tillkm);
		tblfarechartmaster.setLastModifiedBy(modifiedby);
		tblfarechartmaster.setLastModifiedOn(Calendar.getInstance());
		
		try {
			tblfarechartmaster=tmtuTblfarechartmasterRepository.save(tblfarechartmaster);
			logger.info("Updated Fare Chart is saved Id-"+tblfarechartmaster.getFarechartid());
			return tblfarechartmaster;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}


	@Override
	public Tblfarechartmaster updateConcession(long farechartid, long concessionid, long modifiedby) {
		Tblfarechartmaster tblfarechartmaster=tmtuTblfarechartmasterRepository.findOne(farechartid);
		if(tblfarechartmaster==null) {return null;}
		
		Tblconcessionmaster tblconcessionmaster=  tmtuTblconcessionmasterRepository.findOne(concessionid);
		if(tblconcessionmaster==null) {return null;}
		Tbllogin tbllogin=  tmtuTblloginRepository.findOne(modifiedby);
		if(tbllogin==null) {return null;}
		
		tblfarechartmaster.setLastModifiedBy(modifiedby);
		tblfarechartmaster.setLastModifiedOn(Calendar.getInstance());
		tblfarechartmaster.setTblconcessionmaster(tblconcessionmaster);
		//add reference
		
		tblconcessionmaster.addTblfarechartmaster(tblfarechartmaster);
		try {
			tblfarechartmaster=tmtuTblfarechartmasterRepository.save(tblfarechartmaster);
			logger.info("Updated Fare Chart is saved Id-"+tblfarechartmaster.getFarechartid());
			return tblfarechartmaster;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Tblfarechartmaster updatefareamount(long farechartid, double amount, long modifiedby) {
		Tblfarechartmaster tblfarechartmaster=tmtuTblfarechartmasterRepository.findOne(farechartid);
		if(tblfarechartmaster==null) {return null;}
			
		Tbllogin tbllogin=  tmtuTblloginRepository.findOne(modifiedby);
		if(tbllogin==null) {return null;}
		tblfarechartmaster.setTotalAmount(amount);
		tblfarechartmaster.setLastModifiedBy(modifiedby);
		tblfarechartmaster.setLastModifiedOn(Calendar.getInstance());
		
		try {
			tblfarechartmaster=tmtuTblfarechartmasterRepository.save(tblfarechartmaster);
			logger.info("Updated Fare Chart is saved Id-"+tblfarechartmaster.getFarechartid());
			return tblfarechartmaster;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	

}
