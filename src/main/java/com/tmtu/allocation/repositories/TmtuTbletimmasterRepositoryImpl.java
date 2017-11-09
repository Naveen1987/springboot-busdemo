package com.tmtu.allocation.repositories;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmtu.admin.models.Tbllogin;
import com.tmtu.admin.repositories.TmtuTblloginRepository;
import com.tmtu.allocation.models.Tbletimmaster;

public class TmtuTbletimmasterRepositoryImpl implements TmtuTbletimmasterRepositoryCustom {
	
	@Autowired
	TmtuTbletimmasterRepository tmtuTbletimmasterRepository;
	@Autowired
	TmtuTblloginRepository tmtuTblloginRepository;
	
	private static final Logger logger=LoggerFactory.getLogger("Etim Master Repository");
	
	public Tbletimmaster save(String imei,String etimName,String serialNumber,String version,Long createdBy) {
	
	Tbletimmaster tbletimmaster =new Tbletimmaster();
	tbletimmaster.setImei(imei);
	if(etimName!=null) {
		tbletimmaster.setEtimName(etimName);
	}
	if(serialNumber!=null) {
		tbletimmaster.setSerialNumber(serialNumber);
	}
	if(version!=null) {
		tbletimmaster.setVersion(version);
	}
	if(createdBy!=null) {
		Tbllogin tbllogin= 	tmtuTblloginRepository.findOne(createdBy);
		if(tbllogin==null) {
			logger.error("User is not exists");
			return null;
		}
		else {
			tbletimmaster.setCreatedBy(createdBy);
		}
		
	}
	tbletimmaster.setStatus(true);
	tbletimmaster.setCreatedOn(Calendar.getInstance());
	try {
		tbletimmaster=tmtuTbletimmasterRepository.save(tbletimmaster);
		logger.info("Etim saved Successfully Etim IMEI Number is:"+tbletimmaster.getImei());
		return tbletimmaster;
	}
	catch (Exception e) {
		logger.error(e.getMessage());
	}
	return null;
	}

	@Override
	public Tbletimmaster update(String imei, String etimName, String serialNumber, String version, Long modifiedBy) {
		Tbllogin tbllogin= 	tmtuTblloginRepository.findOne(modifiedBy);
		if(tbllogin==null) {
			logger.error("User is not exists");
			return null;
		}
		
		Tbletimmaster tbletimmaster =tmtuTbletimmasterRepository.findByimei(imei);
		if(tbletimmaster==null) {
			logger.error("Etim is not exists");
			return null;
		}
		if(etimName!=null) {
			tbletimmaster.setEtimName(etimName);
		}
		if(serialNumber!=null) {
			tbletimmaster.setSerialNumber(serialNumber);
		}
		if(version!=null) {
			tbletimmaster.setVersion(version);
		}
		tbletimmaster.setLastModifiedBy(modifiedBy);
		tbletimmaster.setLastModifiedOn(Calendar.getInstance());
		try {
			tbletimmaster=tmtuTbletimmasterRepository.save(tbletimmaster);
			logger.info("Etim Updated Successfully Etim IMEI Number is:"+tbletimmaster.getImei());
			return tbletimmaster;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public Tbletimmaster stauschange(String imei, Boolean status) {
		Tbletimmaster tbletimmaster =tmtuTbletimmasterRepository.findByimei(imei);
		if(tbletimmaster==null) {
			logger.error("Etim is not exists");
			return null;
		}
		tbletimmaster.setStatus(status);
		tbletimmaster.setLastModifiedOn(Calendar.getInstance());
		try {
			tbletimmaster=tmtuTbletimmasterRepository.save(tbletimmaster);
			logger.info("Etim Updated Successfully Etim IMEI Number is:"+tbletimmaster.getImei());
			return tbletimmaster;
		}
		catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
}
