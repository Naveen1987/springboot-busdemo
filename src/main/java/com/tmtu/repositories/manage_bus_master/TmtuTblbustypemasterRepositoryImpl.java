package com.tmtu.repositories.manage_bus_master;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.models.manage_bus_master.Tblbustypemaster;

public class TmtuTblbustypemasterRepositoryImpl implements TmtuTblbustypemasterRepositoryCustom {

	@Autowired
	TmtuTblbustypemasterRepository tmtuTblbustypemasterRepository;
	
	private static final Logger logger = LoggerFactory.getLogger("Bus Type Master Repository ");

	@Override
	public Tblbustypemaster save(String serviceTypeName, String servicetypeCode,long createdby) {
		Tblbustypemaster tblbustype=new Tblbustypemaster();
		tblbustype.setCreatedBy(createdby);
		tblbustype.setCreatedOn(Calendar.getInstance());
		tblbustype.setServicetypeCode(servicetypeCode);
		tblbustype.setServiceTypeName(serviceTypeName);
		
		try {
			tblbustype=tmtuTblbustypemasterRepository.save(tblbustype);
			logger.info("Successfully added Id="+tblbustype.getBustypeid());
			return tblbustype;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Tblbustypemaster update(String serviceTypeName, String servicetypeCode, long modifiedby, long bustypeid) {
		Tblbustypemaster tblbustype=tmtuTblbustypemasterRepository.findOne(bustypeid);
		if(tblbustype==null) {
			logger.info("No Bus type exist with Id="+bustypeid);
			return null;
		}
		tblbustype.setLastModifiedBy(modifiedby);
		tblbustype.setLastModifiedOn(Calendar.getInstance());;
		tblbustype.setServicetypeCode(servicetypeCode);
		tblbustype.setServiceTypeName(serviceTypeName);
		
		try {
			tblbustype=tmtuTblbustypemasterRepository.save(tblbustype);
			logger.info("Successfully Updated Id="+tblbustype.getBustypeid());
			return tblbustype;
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		
		return null;
		
	}
}
