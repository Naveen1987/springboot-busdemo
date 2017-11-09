package com.tmtu.bus_master.repositories;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.bus_master.models.Tblbusmaster;
import com.tmtu.bus_master.models.Tblbustypemaster;

public class TmtuTblbusmasterRepositoryImpl implements TmtuTblbusmasterRepositoryCustom {
	private static final Logger logger = LoggerFactory.getLogger("Bus Master Repository ");

	@Autowired
	TmtuTblbusmasterRepository tmtuTblbusmasterRepository;
	
	@Autowired
	TmtuTblbustypemasterRepository tmtuTblbustypemasterRepository;
	
	
	@Override
	public Tblbusmaster save(String busno, long registeron, long createdby, long bustype) {
		
		Tblbustypemaster tblbustypemaster=tmtuTblbustypemasterRepository.findOne(bustype);
		if(tblbustypemaster==null)
		{
			return null;
		}
			
		Tblbusmaster tblbusmaster=new Tblbusmaster();
		tblbusmaster.setBusNo(busno);
		tblbusmaster.setCreatedBy(createdby);
		tblbusmaster.setCreatedOn(Calendar.getInstance());
		Calendar registerDate=Calendar.getInstance();
		registerDate.setTimeInMillis(registeron);
		tblbusmaster.setRegistedOn(registerDate);
		tblbusmaster.setTlbbustypemaster(tblbustypemaster);
		//Add refrefnce
		tblbustypemaster.addTblbusmaster(tblbusmaster);
		try {
			tblbusmaster=tmtuTblbusmasterRepository.save(tblbusmaster);
			if(tblbusmaster!=null)
				{
				logger.info("New Bus Created with number-"+tblbusmaster.getBusNo());
				return tblbusmaster;
				}
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}


	@Override
	public Tblbusmaster update(long busid, String busno, long registeron, long modifiedby, long bustype) {
		Tblbusmaster tblbusmaster=tmtuTblbusmasterRepository.findOne(busid);
		if(tblbusmaster==null) {
			return null;
		}
		Tblbustypemaster tblbustypemaster=tmtuTblbustypemasterRepository.findOne(bustype);
		if(tblbustypemaster==null)
		{
			return null;
		}
			
		
		tblbusmaster.setBusNo(busno);
		tblbusmaster.setLastModifiedBy(modifiedby);
		tblbusmaster.setLastModifiedOn(Calendar.getInstance());
		Calendar registerDate=Calendar.getInstance();
		registerDate.setTimeInMillis(registeron);
		tblbusmaster.setRegistedOn(registerDate);
		tblbusmaster.setTlbbustypemaster(tblbustypemaster);
		//Add refrefnce
		tblbustypemaster.addTblbusmaster(tblbusmaster);
		try {
			tblbusmaster=tmtuTblbusmasterRepository.save(tblbusmaster);
			if(tblbusmaster!=null)
				{
				logger.info("Bus Updated with number-"+tblbusmaster.getBusNo());
				return tblbusmaster;
				}
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}


	@Override
	public Tblbusmaster update(long busid, long modifiedby, long bustype) {
		Tblbusmaster tblbusmaster=tmtuTblbusmasterRepository.findOne(busid);
		if(tblbusmaster==null) {
			return null;
		}
		Tblbustypemaster tblbustypemaster=tmtuTblbustypemasterRepository.findOne(bustype);
		if(tblbustypemaster==null)
		{
			return null;
		}
		tblbusmaster.setLastModifiedBy(modifiedby);
		tblbusmaster.setLastModifiedOn(Calendar.getInstance());	
		tblbusmaster.setTlbbustypemaster(tblbustypemaster);
		//Add refrefnce
		tblbustypemaster.addTblbusmaster(tblbusmaster);
		try {
			tblbusmaster=tmtuTblbusmasterRepository.save(tblbusmaster);
			if(tblbusmaster!=null)
				{
				logger.info("Bus Updated with number-"+tblbusmaster.getBusNo());
				return tblbusmaster;
				}
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	
}
