package com.tmtu.bus_master.repositories;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.admin.models.Tbllogin;
import com.tmtu.admin.repositories.TmtuTblloginRepository;
import com.tmtu.bus_master.models.Tblrfidmaster;

public class TmtuTblrfidmasterRepositoryImpl implements TmtuTblrfidmasterRepositoryCustom {
	
	@Autowired
	TmtuTblrfidmasterRepository tmtuTblrfidmasterRepository;
	@Autowired
	TmtuTblloginRepository tmtuTblloginRepository; 
	
	private static final Logger logger=LoggerFactory.getLogger("Rfid Master Repository ");
	public Tblrfidmaster save(String keys,double amount,long createdby) {
		
		Tbllogin tblogin=tmtuTblloginRepository.findOne(createdby);
		if(tblogin==null) {
			return null;
		}
		Tblrfidmaster tblrfidmaster=new Tblrfidmaster();
		tblrfidmaster.setAmount(amount);
		tblrfidmaster.setCreatedBy(createdby);
		tblrfidmaster.setCreatedOn(Calendar.getInstance());
		tblrfidmaster.setKeys(keys);
		tblrfidmaster.setStatus(true);
		try {
		tblrfidmaster=tmtuTblrfidmasterRepository.save(tblrfidmaster);
		logger.info("new rfid created-"+tblrfidmaster.getRfidmasterid());
		return tblrfidmaster;
		
		}catch (Exception e) {
		logger.error(e.getMessage());
		}
		return null;
	}
	

	
public Tblrfidmaster statusChange(long rfid,long modifiedby,boolean status) {
		
		Tbllogin tblogin=tmtuTblloginRepository.findOne(modifiedby);
		if(tblogin==null) {
			return null;
		}
		Tblrfidmaster tblrfidmaster=tmtuTblrfidmasterRepository.findOne(rfid);
			if(tblrfidmaster==null)
			{
				return null;
			}
		
		tblrfidmaster.setStatus(status);
		tblrfidmaster.setLastModifiedBy(modifiedby);
		tblrfidmaster.setLastModifiedOn(Calendar.getInstance());
		try {
		tblrfidmaster=tmtuTblrfidmasterRepository.save(tblrfidmaster);
		logger.info("new rfid status Updated-"+tblrfidmaster.getStatus());
		return tblrfidmaster;
		}catch (Exception e) {
		logger.error(e.getMessage());
		}
		return null;
	}

public Tblrfidmaster amountChange(long rfid,long modifiedby,double amount) {
	
	Tbllogin tblogin=tmtuTblloginRepository.findOne(modifiedby);
	if(tblogin==null) {
		return null;
	}
	Tblrfidmaster tblrfidmaster=tmtuTblrfidmasterRepository.findOne(rfid);
		if(tblrfidmaster==null)
		{
			return null;
		}
	tblrfidmaster.setAmount(amount);
	tblrfidmaster.setLastModifiedBy(modifiedby);
	tblrfidmaster.setLastModifiedOn(Calendar.getInstance());
	try {
	tblrfidmaster=tmtuTblrfidmasterRepository.save(tblrfidmaster);
	logger.info("new rfid Amount Updated-"+tblrfidmaster.getAmount());
	return tblrfidmaster;
	}catch (Exception e) {
	logger.error(e.getMessage());
	}
	return null;
}
}
