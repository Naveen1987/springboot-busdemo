package com.tmtu.repositories.manage_bus_master;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import com.tmtu.models.Tbllogin;
import com.tmtu.models.manage_bus_master.Tblconcessionmaster;
import com.tmtu.repositories.TmtuTblloginRepository;

public class TmtuTblconcessionmasterRepositoryImpl implements TmtuTblconcessionmasterRepositoryCustom {

	private static final Logger logger=LoggerFactory.getLogger("concession master Repository");
	
	@Autowired
	TmtuTblconcessionmasterRepository tmtuTblconcessionmasterRepository;
	
	@Autowired
	TmtuTblloginRepository tmtuTblloginRepository;
	
	@Override
	public Tblconcessionmaster save(String concessionName, String concessionCode, long createdBy) {
		
		Tbllogin tbl=tmtuTblloginRepository.findOne(createdBy);
		if(tbl==null) {
			return null;
		}
		Tblconcessionmaster tblconcessionmaster=new Tblconcessionmaster();
		tblconcessionmaster.setConcessionCode(concessionCode);
		tblconcessionmaster.setConcessionName(concessionName);
		tblconcessionmaster.setCreatedBy(createdBy);
		tblconcessionmaster.setCreatedOn(Calendar.getInstance());
		try {
			tblconcessionmaster=tmtuTblconcessionmasterRepository.save(tblconcessionmaster);
			logger.info("New concession created Id="+tblconcessionmaster.getConcessionid());
			return tblconcessionmaster;
		}catch (Exception e) {
		logger.error("Not created");
		}
		return null;
	}

	@Override
	public Tblconcessionmaster update(long concessionid, String concessionName, String concessionCode, long modifiedby) {
		Tbllogin tbl=tmtuTblloginRepository.findOne(modifiedby);
		if(tbl==null) {
			return null;
		}
		Tblconcessionmaster tblconcessionmaster=tmtuTblconcessionmasterRepository.findOne(concessionid);
		if(tblconcessionmaster==null) {
			return null;
		}
		tblconcessionmaster.setConcessionCode(concessionCode);
		tblconcessionmaster.setConcessionName(concessionName);
		tblconcessionmaster.setLastModifiedBy(modifiedby);
		tblconcessionmaster.setLastModifiedOn(Calendar.getInstance());
		try {
			tblconcessionmaster=tmtuTblconcessionmasterRepository.save(tblconcessionmaster);
			logger.info("New concession Updated Id="+tblconcessionmaster.getConcessionid());
			return tblconcessionmaster;
		}catch (Exception e) {
		logger.error("Not created");
		}
		return null;
	}

}
